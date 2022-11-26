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
 * @file Obstacle.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Obstacle.h"

Obstacle::Obstacle ( bool last ) : _last(last) 
{

}

bool Obstacle::isLast() const { return _last; }


Obstacle::~Obstacle() {  }