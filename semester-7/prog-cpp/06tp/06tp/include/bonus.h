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
 * @file bonus.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 04 December 2022
 */

#ifndef __BONUS_HH__
#define __BONUS_HH__

#include <vector>
#include <array>
#include <list>
#include <deque>
#include <iostream>
#include <ctime>
#include <chrono>

template<typename Sequence>
double timeSpendToAddNElements( Sequence & containers, int n ) {
    std::clock_t start = std::clock();
    for ( int i = 0; i < n; ++i ) {
        containers.push_back(rand());
    }
    std::clock_t end = std::clock();
    return std::chrono::duration<double, std::milli>(end - start).count();
}

#endif /* __BONUS_HH__ */
