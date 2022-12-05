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
 * @date 23 November 2022
 */

#include "tableaux_associatifs.h"
#include <iostream>
#include <map>
#include <iterator>

using namespace std;

int main( void ) {
    cout << boolalpha;
    cout << "\n\n   4. Tableaux associatifs" << endl;

    map<string, int> age;
    age["Gerard"] = 16;
    age["Jean-Claude"] = 73;
    age["DiBen"] = 50;

    cout << " - Fill map with : \nage[\"Gerard\"] = 16;\nage[\"Jean-Claude\"] = 73;\nage[\"DiBen\"] = 50;\n - Display map : " << endl;

    for ( map<string, int>::iterator it = age.begin(); it != age.end(); it++ ) {
        cout << "(" << it->first << "," << it->second << ")";
    }
    cout << endl;
    cout << "\n\n   4.2. (Ordre sur) le modele pair : " << endl;
    cout << "(1,10) < (2,3) ? : " << (make_pair<int,int>(1,10) < make_pair<int,int>(2,3)) << endl;
    cout << "(1,10) < (1,20) ? : " << (make_pair<int,int>(1,10) < make_pair<int,int>(1,20)) << endl;
    cout << "(1,10) < (1,5) ? : " << (make_pair<int,int>(1,10) < make_pair<int,int>(1,5)) << endl;
    cout << "(1,10) < (0,8.5) ? : " << (make_pair<int,double>(1,10) < make_pair<int,double>(0,8.5)) << endl;
    cout << "(0,0) != (0,8) ? : " << (make_pair<int,int>(0,0) != make_pair<int,int>(0,0)) << endl;
    cout << "(0,5) > (0,5) ? : " << (make_pair<int,int>(0,5) > make_pair<int,int>(0,5)) << endl;
    cout << "(\"pomme\",10) < (\"tomate\",40) ? : " << (make_pair<string,int>("pomme",10) < make_pair<string,int>("tomate",40)) << endl;
    return 1;
}