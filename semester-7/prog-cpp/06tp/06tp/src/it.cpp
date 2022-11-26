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
 * @file it.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 23 November 2022
 */

#include <iostream>
#include "it.h"
#include <vector>
#include <set>

using namespace std;

#define NUMBER_INT 40
#define NUMBER_SET 1000
#define MAX_INT 20
#define MIN_INT 0

vector<int> randIntFillingVector() {
    vector<int> vect;
    for ( int i = 0; i < NUMBER_INT; i++ ) {
        int randInt = (rand() + MIN_INT) % (MAX_INT + 1);
        vect.push_back( randInt );
    }
    return vect;
}

std::set<int> randIntFillingSet() {
    set<int> set;
    for ( int i = 0; i < NUMBER_SET; i++ ) {
        int randInt = (rand() + MIN_INT) % (MAX_INT + 1);
        set.insert( randInt );
    }
    return set;
}