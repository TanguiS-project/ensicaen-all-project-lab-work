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
 * @file City.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 05 December 2022
 */

#ifndef __CITY_HH__
#define __CITY_HH__

#include <iostream>
#include <algorithm>
#include <sstream>
#include <string>

typedef struct City
{
    /* data */
    std::string city;
    int zip;
    std::string toString() const {
        std::stringstream builder;
        std::string upper(city);
        std::transform(city.begin(), city.end(), upper.begin(), ::toupper);
        builder << upper << "(" << zip << ")";
        return builder.str();
    }
    int getMainZipCode() const {
        return zip/1000;
    }
}City_t;

using Cities = std::vector<City_t>;

using CityPredicate = std::function<bool(const City&)>;

std::ostream& operator<<(std::ostream& os, const City& c);

Cities* getCitiesFromCSV( const std::string & csv );

Cities* select( const Cities& cities, CityPredicate predicate );

Cities* selectv2( const Cities& cities, CityPredicate predicate );

bool checkZipCode( const Cities& cities );

CityPredicate city_and( CityPredicate first, CityPredicate second );

bool has_ville_suffix( const City_t& city );

#endif /* __CITY_HH__ */
