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
 * @file Board.cpp
 * @brief /!\ Complete this tag after creating the file /!\
 * @author STEIMETZ Tangui <steimetz.tangui@ecole.ensicaen.fr>
 * @version 1.0.0
 * @date 18 October 2022
 */

#include "Board.h"
#include "Nail.h"
#include <sstream>
#include <iostream>
#include <cmath>

using namespace std;

Board::Board( const int NumberCounter ) : _numberCounter(NumberCounter)
{
    if ( NumberCounter < 1 ) {
        throw "--> Not enough counter : >= 1 /!\\";
    }
    _counters = new Counter*[NumberCounter];
    _terminal = new Counter();
    for ( int i = 0; i < NumberCounter - 1; i++ ) {
        _counters[i] = new Counter( _terminal );
    }
    _counters[_numberCounter - 1] = new Counter( _terminal, true );

    Obstacle* head;
    if ( _numberCounter == 1 ) {
        head = _counters[0];
    } else {
        head = createObstacle();
    }
    _thrower = new Thrower( head );
}



Obstacle* Board::createObstacle()
{
    Nail** sons = new Nail*[_numberCounter-1];
    Nail** parents;
    Nail* result;
    for ( int i = 0; i < _numberCounter-2; i++ ) {
        sons[i] = new Nail(_counters[i], _counters[i+1] );
    }
    sons[_numberCounter-2] = new Nail( _counters[_numberCounter - 2], _counters[_numberCounter - 1], true );

    for ( int i = _numberCounter - 2; i > 0; i-- ) {
        parents = new Nail*[i];
        for ( int j = 0; j < i; j++ ) {
            if ( j == i - 1 ) {
                parents[j] = new Nail( sons[j], sons[j+1], true );
            } else {
                parents[j] = new Nail( sons[j], sons[j+1] );
            }

        }
        delete[] sons;
        sons = parents;
        parents = nullptr;
    }
    result = sons[0];
    delete[] sons;
    return static_cast<Obstacle*>(result);
}

void Board::startSimulation( int numberDisc ) const
{
    srand( time( nullptr ) );
    for ( int i = 0; i < _numberCounter; i++ ) {
        _counters[i]->resetNumberDisc();
    }
    for ( int i = 0; i < numberDisc; i++ ) {
        _thrower->throwDisc();
    }
    stringstream strb;
    strb << endl;
    for ( int i = 0; i < _numberCounter; i++ ) {
        strb << "round(c" << i << "/c0)=" << round( (double)_counters[i]->getNumberDisc() / (double)_counters[0]->getNumberDisc() ) << ", "; 
    }
    cout << strb.str() << endl;

}

Board::~Board()
{
    delete _thrower;
    delete[] _counters;
}

std::string Board::toString() const
{
    stringstream strb;
    stringstream tmpStrb;
    int lengthLine = 3 * (_numberCounter + 1) + 7 * _numberCounter + 2;
    int lengthInside = lengthLine-2;
    int lengthSpace = 0;
    const int lengthBetween = 9;
    for ( int i = 0; i < lengthLine; i++) {
        strb << "_";
    }
    lengthSpace = (lengthInside-5)/2;
    for ( int i = 0; i < lengthSpace; i++ ) {
        tmpStrb << " ";
    }
    strb << "\n|" << tmpStrb.str() << "\\   /" << tmpStrb.str() << "|\n|";
    tmpStrb.str("");
    for ( int i = 0; i < lengthInside; i++  ) {
        strb << " ";
    }
    strb << "|\n";
    for ( int i = 0; i < _numberCounter - 1; i++ ) {
        strb << "|";
        lengthSpace = (lengthInside - i * lengthBetween - ( i + 1 )) / 2;
        for ( int j = 0; j < lengthSpace; j++ ) {
            tmpStrb << " ";
        }
        strb << tmpStrb.str();
        for ( int j = 0; j < i; j++ ) {
            strb << "*";
            for ( int k = 0; k < lengthBetween; k++ ) {
                strb << " ";
            }
        }
        strb << "*" << tmpStrb.str() << "|\n";
        tmpStrb.str("");
    }

    strb << "|   ";
    for ( int i = 0; i < _numberCounter; i++ ) {
        strb << _counters[i]->toString() << "   ";
    }
    strb << "|\n\\";
    for ( int i = 0; i < lengthInside; i++) {
        if ( i > (lengthInside-5)/2 && i < (lengthInside)/2 ) {
            strb << "   ";
            i += 2;
        } else {
            strb << "_";
        }
    }
    strb << "/\n \\";
    for ( int i = 0; i < lengthInside; i++ ) {
        if ( i > (lengthInside-10 )/2 && i < (lengthInside-1)/2 ) {
            strb << _terminal->toString();
            i += 8;
        } else {
            strb << "_";
        }
    }
    strb << "/ \n";
    return strb.str();
}

ostream& operator<<( ostream& stream, const Board& planche )
{
    return ( stream << planche.toString() );
}
