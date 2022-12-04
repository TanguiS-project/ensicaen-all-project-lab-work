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
 * @file sort.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 23 November 2022
 */

#ifndef __SORT_HH__
#define __SORT_HH__

#include <vector>
#include <queue>
#include <list>
#include <functional>

std::vector<int>* sortVector( const std::vector<int> & vToSort );

template<typename T,
         typename Sequence = std::vector<T>,
         typename Compare = std::less<typename Sequence::value_type>>
Sequence* sortVector( const Sequence & toSort ) {
    std::priority_queue<T, Sequence, Compare> pQueue;
    Sequence* result = new std::vector<T>();

    for ( typename Sequence::const_iterator it = toSort.begin(); it != toSort.end(); it++ ) {
        pQueue.push( *it );
    }
    while ( !pQueue.empty() ) {
        result->push_back( pQueue.top() );
        pQueue.pop();
    }
    return result;
}

#endif /* __SORT_HH__ */
