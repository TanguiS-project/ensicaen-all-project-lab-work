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
 * @file Thrower.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Obstacle.h"

#ifndef __THROWER_HH__
#define __THROWER_HH__

class Thrower {
private:
    Obstacle* _obstacle;
public:
    Thrower( Obstacle* obstacle = nullptr );
    ~Thrower();
    void throwDisc() const;
};

#endif /* __THROWER_HH__ */
