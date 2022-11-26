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
 * @file Obstacle.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#ifndef __OBSTACLE_HH__
#define __OBSTACLE_HH__

#include <iostream>

class Obstacle {
private:
    /* data */
    bool _last;
public:
    Obstacle ( bool last = false );
    bool isLast() const;
    virtual std::string toString() const = 0;
    virtual void getDisc() = 0;
    virtual ~Obstacle();
};

#endif /* __OBSTACLE_HH__ */
