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

#include "it.h"
#include <iostream>

using namespace std;

int main ( void ) {
    srand( time( nullptr ) );
    vector<int> vect = randIntFillingVector();
    set<int> set = randIntFillingSet();

    cout << "\n\n   1. Les iterateurs version STL :" << endl;
    cout << " - Vector Display : ";
    displayVect<int>( vect );
    cout << "       size = " << vect.size() << endl;

    cout << " - Set Display : ";
    displaySet<int>( set );
    cout << "       size = " << set.size() << endl;

    cout << " - Display Vector/Set with 2 iterators : " << endl;
    cout << " - Vector Display : ";
    displayIterable( vect.begin(), vect.end() );
    cout << " - Set Display : ";
    displayIterable( set.begin(), set.end() );

    // stack<int>::iterator it; //Not an heritage of Collection
    return 1;
}