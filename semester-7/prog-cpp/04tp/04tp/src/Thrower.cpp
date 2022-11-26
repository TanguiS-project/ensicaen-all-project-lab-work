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
 * @file Thrower.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include <iostream>
#include "Thrower.h"

Thrower::Thrower( Obstacle* obstacle ) : _obstacle(obstacle) {  }

void Thrower::throwDisc() const { _obstacle->getDisc(); }

Thrower::~Thrower() 
{  
    delete _obstacle;
}