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
 * @file it.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 23 November 2022
 */

#ifndef __IT_HH__
#define __IT_HH__

#include <vector>
#include <set>
#include <list>
#include <iostream>
#include <iterator>

std::vector<int> randIntFillingVector(); 

std::set<int> randIntFillingSet();

template<typename T>
void displayVect( std::vector<T> v ) {
    typename std::vector<T>::iterator it;
    for ( it = v.begin(); it != v.end(); it++ ) {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
}

template<typename T>
void displaySet( std::set<T> s ) {
    typename std::set<T>::iterator it;
    for ( it = s.begin(); it != s.end(); it++ ) {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
}

template<typename Iterator>
void displayIterable( Iterator begin, Iterator end ) {
    Iterator it;
    for ( it = begin; it != end; it++ ) {
        std::cout << *it << " ";
    }
    std::cout << std::endl;
}

#endif /* __IT_HH__ */
