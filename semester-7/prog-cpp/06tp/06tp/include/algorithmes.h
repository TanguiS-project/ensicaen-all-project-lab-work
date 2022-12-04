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
 * @file algorithmes.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 01 December 2022
 */

#ifndef __ALGORITHMES_HH__
#define __ALGORITHMES_HH__

#include <vector>
#include <queue>
#include <functional>
#include <iterator>
#include <list>

template<typename ItLeft, typename ItRight>
bool isSubset( ItLeft leftBegin, ItLeft leftEnd, ItRight rightBegin, ItRight rightEnd ) {
    ItRight save = rightBegin;
    int recognizeNumber = 0;
    int actualSize = 0;
    if ( leftBegin == leftEnd ) { return true; }
    if ( rightBegin == rightEnd ) { return false; }
    for ( ; leftBegin != leftEnd; leftBegin++ ) {
        ++actualSize;
        for ( ; rightBegin != rightEnd; rightBegin++ ) {
            if ( *leftBegin == *rightBegin ) {
                ++recognizeNumber;
                rightBegin = save;
                break;
            }
        }
    }
    return recognizeNumber == actualSize;
}

template<typename T,
         typename Sequence,
         typename Iterator,
         typename Compare = std::less<typename Sequence::value_type>>
void sortContainers( Iterator begin, Iterator end ) {
    std::priority_queue<T, Sequence, Compare> pQueue;
    Iterator current;
    for ( current = begin; current != end; current++ ) {
        pQueue.push( *current );
    }
    current = begin;
    while ( !pQueue.empty() ) {
        *current++ = pQueue.top();
        pQueue.pop();
    }
}

template<typename T,
         typename Iterator>
void swapInContainers( Iterator first, Iterator second ) {
    typename std::iterator_traits<Iterator>::value_type tmp;
    tmp = *first;
    *first = *second;
    *second = tmp;
}

#endif /* __ALGORITHMES_HH__ */
