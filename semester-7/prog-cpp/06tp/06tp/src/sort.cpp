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
 * @file sort.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 23 November 2022
 */

#include "sort.h"

using namespace std;

std::vector<int>* sortVector( const std::vector<int> & vToSort ) {
    vector<int>::const_iterator it;
    priority_queue<int> pQueue;
    vector<int>* result = new vector<int>;

    for ( it = vToSort.begin(); it != vToSort.end(); it++ ) {
        pQueue.push( *it );
    }
    while ( !pQueue.empty() ) {
        result->push_back( pQueue.top() );
    }

    return result;
}
