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
 * @file Nail.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Nail.h"
#include "Counter.h"
#include <iostream>

Nail::Nail( Obstacle* leftPtr, Obstacle* rightPtr, bool last ) : Obstacle(last), _leftPtr(leftPtr), _rightPtr(rightPtr)  { }

std::string Nail::toString() const { return "*"; }

void Nail::getDisc()
{
    if ( rand() % 2 == 0 ) {
        _leftPtr->getDisc();
        return;
    }
    _rightPtr->getDisc();
}

Obstacle* Nail::getLeft() const { return _leftPtr; }

Obstacle* Nail::getRight() const { return _rightPtr; }

Nail::~Nail() 
{
    if ( isLast() ) {
        delete _rightPtr;
    }
    delete _leftPtr;
}
