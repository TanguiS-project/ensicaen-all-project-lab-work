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
 * @file main.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 05 December 2022
 */

#include "City.h"
#include <map>

using namespace std;

int main( int argc, char** argv ) {
    City_t caen = {"caen", 14000};
    cout << caen << endl;
    Cities* cities = getCitiesFromCSV( "./ressources/villes.csv" );

/*     for ( auto city : *cities ) {
        cout << city << endl;
    }
 */
    Cities* zipCodeRound = select( *cities, [](const City_t& city) {
        return city.city.find("MET") == 0;
    });

    for ( auto city : *zipCodeRound ) {
        cout << city << endl;
    }

    delete zipCodeRound;

    zipCodeRound = selectv2( *cities, [](const City_t& city) {
        return city.city.find("MET") == 0;
    });
    cout << "\n\n";
    for ( auto city : *zipCodeRound ) {
        cout << city << endl;
    }

    cout << boolalpha;

    cout << "Zip code from csv  in [0, 100] ? : " << checkZipCode( *cities ) << endl;

    Cities* parcours = selectv2( *cities, city_and( [](const City_t& city) {
        return city.city.find("SAINTE") != string::npos;
    }, [](const City_t& city) {
        return city.getMainZipCode() == 17;
    } ) );

    cout << "\n\n SAINTE AND 17" << endl;
    for ( auto city : *parcours ) {
        cout << city << endl;
    }
    delete parcours;

    parcours = selectv2( *cities, [](const City_t& city) { return has_ville_suffix( city ); });
    cout << "\n\n HAS VILLE SUFFIXE" << endl;
    for ( auto city : *parcours ) {
        cout << city << endl;
    }
    delete parcours;
    CityPredicate is_in_calvados = [](const City_t& city) {
        return city.getMainZipCode() == 14;
    };
    cout << "\n\nis_in_calvados and has_ville_suffix, number : "
    << count_if( cities->begin(), cities->end(), city_and(is_in_calvados, [](const City_t& city) { return has_ville_suffix(city); } ) ) << endl;

    map<int, int> countZipCodeHasVilleSuffix;
    for_each( cities->begin(), cities->end(), [&cities, &countZipCodeHasVilleSuffix]( const City_t& city ) {
        pair<int, int> tmp = make_pair ( city.getMainZipCode(), count_if( cities->begin(), cities->end(), city_and( [&city](const City& cityTest) {
            return cityTest.getMainZipCode() == city.getMainZipCode();
        }, [](const City_t& city) { 
            return has_ville_suffix(city); 
        } ) ) );
        countZipCodeHasVilleSuffix.insert(tmp);
    });

    for ( auto pair : countZipCodeHasVilleSuffix ) {
        cout << "(" << pair.first << ", " << pair.second << ")" << endl;
    }

    delete zipCodeRound;
    delete cities;
    return 1;
}
