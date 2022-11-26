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
 * @file Counter.h
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Obstacle.h"

#ifndef __COUNTER_HH__
#define __COUNTER_HH__

#include <iostream>

class Counter : public Obstacle {
private:
    /* data */
    Counter* _counterPtr;
    int _numberDisc;

public:
    Counter( Counter* ptr = nullptr, bool last = false );
    ~Counter();
    std::string toString() const;
    void getDisc();
    int getNumberDisc() const;
    void resetNumberDisc();
};

#endif /* __COUNTER_HH__ */