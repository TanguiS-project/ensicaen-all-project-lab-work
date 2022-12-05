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

#include "sort.h"
#include "it.h"

using namespace std;

int main( void ) {
    srand( time( nullptr ) );
    cout << "\n\n   3. Tri a l'aide d'une priority_queue : \nV1 : " << endl;
    vector<int> vect = randIntFillingVector();
    vector<int>* vectToSort;
    vectToSort = sortVector( vect );
    cout << "Vector to sort : ";
    displayIterable( vect.begin(), vect.end() );
    cout << "Vector sorted : ";
    displayIterable( vectToSort->begin(), vectToSort->end() );

    delete vectToSort;

    cout << "V2 : " << endl;
    vectToSort = sortVector<int, vector<int>, greater<int>>( vect );
    cout << "Vector<int> to sort : ";
    displayIterable( vect.begin(), vect.end() );
    cout << "Vector<int> sorted : ";
    displayIterable( vectToSort->begin(), vectToSort->end() );

    vector<double> vect_double = {548.4, 87,9.513, 1.3189, 21.3,2.8789, 123.2, 98.7, 20., 8.498, .87,  .4984, 8723.18,7.4,98.49849, 4898.984, 1.51};
    vector<double>* vect_double_sort;
    vect_double_sort = sortVector<double, vector<double>, greater<double>>( vect_double );
    cout << "Vector<double> to sort : ";
    displayIterable( vect_double.begin(), vect_double.end() );
    cout << "Vector<double> sorted : ";
    displayIterable( vect_double_sort->begin(), vect_double_sort->end() );

    delete vect_double_sort;
    delete vectToSort;
    return 1;
}