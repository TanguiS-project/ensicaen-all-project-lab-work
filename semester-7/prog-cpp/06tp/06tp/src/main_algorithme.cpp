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

#include "algorithmes.h"
#include "it.h"

using namespace std;

int main( void ) {
    cout << "\n\n   5. Algorithme :\n - Algorithme isSubset : " << endl;
    vector<int> testSubset1 = {1, 2, 3, 4, 5, 4};
    vector<int> testSubset2 = {1, 2, 3, 4, 5, 4, -1};
    vector<int> testSubset3 = {9, 8, 7, 6, 5, 4, 3, 2, 8, 8, 8, 1};
    cout << "vect1 : ";
    displayIterable( testSubset1.begin(), testSubset1.end() );
    cout << "vect3 : ";
    displayIterable( testSubset3.begin(), testSubset3.end() );
    cout << "vect1 isSubset of vect3? : " << isSubset( testSubset1.begin(), testSubset1.end(), testSubset3.begin(), testSubset3.end() ) << endl;
    cout << "vect2 : ";
    displayIterable( testSubset2.begin(), testSubset2.end() );
    cout << "vect3 : ";
    displayIterable( testSubset3.begin(), testSubset3.end() );
    cout << "vect2 isSubset of vect3? : " << isSubset( testSubset2.begin(), testSubset2.end(), testSubset3.begin(), testSubset3.end() ) << endl;

    cout << " - Algorithme sortContainers : \nvect<int> to sort : ";
    displayIterable( testSubset3.begin(), testSubset3.end() );
    sortContainers<int, vector<int>::iterator, greater<int>>( testSubset3.begin(), testSubset3.end() );
    cout << "vect<int> sorted : ";
    displayIterable( testSubset3.begin(), testSubset3.end() );

    cout << "list<int> to sort : ";
    list<int> listToSort = {9, 6, 8, 5, 3, 66, 4, 1, 9, 0, 6, 7, 4, 88, 65};
    displayIterable( listToSort.begin(), listToSort.end() );
    sortContainers<int, list<int>::iterator, greater<int>>( listToSort.begin(), listToSort.end() );
    cout << "list<int> sorted : ";
    displayIterable( listToSort.begin(), listToSort.end() );

    cout << "\n\n   5. Swap Algo : \n - Swap begin with end-1 on a vector :" << endl;
    displayIterable( testSubset3.begin(), testSubset3.end() );
    cout << "unswaped vector : ";
    swapInContainers<int, vector<int>::iterator>( testSubset3.begin(), testSubset3.end()-1 );
    cout << "swaped vector : ";
    displayIterable( testSubset3.begin(), testSubset3.end() );
    cout << " - Swap begin with ++begin on a list : " << endl;
    cout << "unswaped list : ";
    displayIterable( listToSort.begin(), listToSort.end() );
    swapInContainers<int, list<int>::iterator>( listToSort.begin(), ++listToSort.begin() );
    cout << "swaped list : ";
    displayIterable( listToSort.begin(), listToSort.end() );
    return 1;
}