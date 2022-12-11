/*
 * ENSICAEN
 * 6 Boulevard Marechal Juin
 * F-14050 Caen Cedex
 *
 * This file is owned by ENSICAEN students.
 * No portion of this document may be reproduced, copied
 * or revised without written permission of the authors.
 */

/**
 * @file City.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 05 December 2022
 */

#include "City.h"
#include <fstream>

using namespace std;

std::ostream& operator<<(std::ostream& os, const City& c) {
    os << c.toString();
    return os;
}

Cities* getCitiesFromCSV( const std::string & csv ) {
    ifstream file { csv };
    string lineBuffer;
    Cities* cities = new Cities();
    while ( getline( file, lineBuffer ) ) {
        City_t tmp = { lineBuffer.substr(lineBuffer.find(";")+1, lineBuffer.length()), stoi(lineBuffer.substr(0, lineBuffer.find(";"))) };
        cities->push_back( tmp );
    }
    return cities;
}

Cities* select( const Cities& cities, CityPredicate predicate ) {
    Cities* predicateIsSatisfied = new Cities();
    Cities::const_iterator it;
    for ( it = cities.begin(); it < cities.end(); it++ ) {
        if ( predicate(*it) ) {
            predicateIsSatisfied->push_back(*it);
        }
    }
    return predicateIsSatisfied;
}

Cities* selectv2( const Cities& cities, CityPredicate predicate ) {
    Cities* predicateIsSatisfied = new Cities();
    copy_if( cities.begin(), cities.end(), back_insert_iterator<Cities>(*predicateIsSatisfied), predicate);
    return predicateIsSatisfied;
}

bool checkZipCode( const Cities& cities ) {
    return all_of( cities.begin(), cities.end(), [](City_t city){ 
        return city.getMainZipCode() >= 0 && city.getMainZipCode() <= 100; 
        });
}

CityPredicate city_and( CityPredicate first, CityPredicate second ) {
    return [=](City_t city) { 
        return first(city) && second(city);
    };
}

bool has_ville_suffix( const City_t& city ) {
    string upperCity = city.city;
    transform( upperCity.begin(), upperCity.end(), upperCity.begin(), ::toupper );
    return upperCity.find( "VILLE " ) != string::npos || (upperCity.length() > 5 && upperCity.substr(upperCity.length()-5) == "VILLE");
}