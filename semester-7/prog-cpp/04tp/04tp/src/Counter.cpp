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
 * @file Counter.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Counter.h"
#include <sstream>
#include <iostream>

using namespace std;

Counter::Counter( Counter* ptr, bool last ) : Obstacle(last), _counterPtr(ptr), _numberDisc(0) {  }

void Counter::getDisc()
{
    _numberDisc++;
    if ( _counterPtr == nullptr ) {
        return;
    }
    _counterPtr->getDisc();
}

int Counter::getNumberDisc() const { return _numberDisc; }

void Counter::resetNumberDisc() { _numberDisc = 0; }

std::string Counter::toString() const
{
    stringstream strb;
    char buff[255];
    if ( _counterPtr != nullptr ) {
        sprintf( buff, "|%0.3f|", (double)_numberDisc / (double)_counterPtr->getNumberDisc() );
        strb << buff;
        return strb.str();
    }
    sprintf( buff, "|%0.3f|", (double)_numberDisc / (double)_numberDisc );
    strb << buff;
    return strb.str();
}

Counter::~Counter() 
{
    if ( isLast() && _counterPtr != nullptr ) {
        delete _counterPtr;
    }    
}