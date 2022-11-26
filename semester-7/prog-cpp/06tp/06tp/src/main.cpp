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
#include "capacity.h"
#include <vector>
#include <set>
#include <time.h>
#include <stack>
#include <iostream>

using namespace std;

int main( int argc, char** argv ) {
    
    srand( time( nullptr ) );
    vector<int> vect = randIntFillingVector();
    set<int> set = randIntFillingSet();

    cout << "Vector Display : \n";
    displayVect<int>( vect );
    cout << "size = " << vect.size() << endl;

    cout << "Set Display : \n";
    displaySet<int>( set );
    cout << "size = " << set.size() << endl;

    cout << "Q1, Remarq : size of set is 20 : only one element is tolerated in a set\n";
    cout << "Q2, Remarq : order relation used because multiple value of an element can be inserted, so they need to be differientable\n";

    displayIterable( vect.begin(), vect.end() );
    displayIterable( set.begin(), set.end() );

    // stack<int>::iterator it; //Not an heritage of Collection

    vector<double> vect_d = fillRandomDoubleVectorWObserverCapacity();
    cout << "Q3, Remarq : a vector is allocated with a multiple of two\n";

    vector<int>


    return 1;
}
