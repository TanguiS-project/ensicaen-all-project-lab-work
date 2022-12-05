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
 * @file main.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 23 November 2022
 */

#include "capacity.h"
#include <ctime>
#include <iostream>

using namespace std;

int main( void ) {
    srand( time( nullptr ) );
    cout << "\n\n   2. Taille et capacite d'un vecteur : \n - Random fill with trace on a vector : " << endl;
    vector<double> vect_d = fillRandomDoubleVectorWObserverCapacity();
    return 1;
}