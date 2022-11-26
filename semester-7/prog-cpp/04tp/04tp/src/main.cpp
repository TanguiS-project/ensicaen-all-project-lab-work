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
 * @date 18 October 2022
 */

#include "Board.h"
#include <iostream>

using namespace std;

int main( int argc, char** argv ) 
{
    argc = argc;
    argv = argv;
    try {
        Board board(3);
        board.startSimulation(1000000);
        cout << board << endl;
    }
    catch( const char* err ) {
        cout << err << endl;
    }
    return 1;
}
