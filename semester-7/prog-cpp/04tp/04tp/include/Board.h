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
 * @file Board.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Thrower.h"
#include "Counter.h"

#ifndef __BOARD_HH__
#define __BOARD_HH__

#include <iostream>

class Board {
private:
    /* data */
    Thrower* _thrower;
    int _numberCounter;
    Counter** _counters;
    Counter* _terminal;

public:
    Board( const int numberCounter = 1 );
    ~Board();
    std::string toString() const;
    void startSimulation( const int ) const;
private:
    Obstacle* createObstacle();
};

std::ostream& operator<<( std::ostream& stream, const Board& board );


#endif /* __BOARD_HH__ */
