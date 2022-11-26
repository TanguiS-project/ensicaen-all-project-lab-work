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
 * @file capacity.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 23 November 2022
 */

#include "capacity.h"
#include <vector>
#include <iostream>

#define NB_ELEMENT 5000

using namespace std;

std::vector<double> fillRandomDoubleVectorWObserverCapacity() {
    std::vector<double> vect;
    size_t capacity = vect.capacity();
    cout << "Init capacity observer, capacity = " << capacity << endl;
    for ( int i = 0; i < NB_ELEMENT; i++ ) {
        double randDouble = (double)rand() / (double)RAND_MAX; 
        vect.push_back( randDouble );
        if ( vect.capacity() != capacity ) {
            cout << " -> Observed Change of capacity : was : " << capacity << " and is : " << vect.capacity() << endl;
            capacity = vect.capacity();
        }
    }
    return vect;
}

