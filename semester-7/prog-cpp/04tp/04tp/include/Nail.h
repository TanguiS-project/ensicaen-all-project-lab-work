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
 * @file Nail.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Obstacle.h"

#ifndef __NAIL_HH__
#define __NAIL_HH__

class Nail : public Obstacle {
private:
    Obstacle* _leftPtr;
    Obstacle* _rightPtr;
public:
    Nail( Obstacle* leftPtr = nullptr, Obstacle* rightPtr = nullptr, const bool last = false );
    ~Nail();
    std::string toString() const;
    void getDisc();
    Obstacle* getLeft() const;
    Obstacle* getRight() const;
};

#endif /* __NAIL_HH__ */