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

#include "it.h"
#include "capacity.h"
#include "sort.h"
#include "algorithmes.h"
#include "bonus.h"
#include <vector>
#include <list>
#include <set>
#include <deque>
#include <time.h>
#include <stack>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <map>

using namespace std;

int main( void ) {
    
    srand( time( nullptr ) );
    vector<int> vect = randIntFillingVector();
    set<int> set = randIntFillingSet();
    cout << boolalpha;

    cout << "   1. Les iterateurs version STL :" << endl;
    cout << " - Vector Display : ";
    displayVect<int>( vect );
    cout << "       size = " << vect.size() << endl;

    cout << " - Set Display : ";
    displaySet<int>( set );
    cout << "       size = " << set.size() << endl;

    cout << " - Display Vector/Set with 2 iterators : " << endl;
    cout << " - Vector Display : ";
    displayIterable( vect.begin(), vect.end() );
    cout << " - Set Display : ";
    displayIterable( set.begin(), set.end() );

    // stack<int>::iterator it; //Not an heritage of Collection

    cout << "\n\n   2. Taille et capacite d'un vecteur : \n - Random fill with trace on a vector : " << endl;
    vector<double> vect_d = fillRandomDoubleVectorWObserverCapacity();

    cout << "\n\n   3. Tri a l'aide d'une priority_queue : \nV1 : " << endl;
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

    cout << "\n\n   4. Tableaux associatifs" << endl;

    map<string, int> age;
    age["Gerard"] = 16;
    age["Jean-Claude"] = 73;
    age["DiBen"] = 50;

    cout << " - Fill map with : \nage[\"Gerard\"] = 16;\nage[\"Jean-Claude\"] = 73;\nage[\"DiBen\"] = 50;\n - Display map : " << endl;

    for ( map<string, int>::iterator it = age.begin(); it != age.end(); it++ ) {
        cout << "(" << it->first << "," << it->second << ")";
    }
    cout << endl;
    cout << "   4.2. (Ordre sur) le modele pair : " << endl;
    cout << "(1,10) < (2,3) ? : " << (make_pair<int,int>(1,10) < make_pair<int,int>(2,3)) << endl;
    cout << "(1,10) < (1,20) ? : " << (make_pair<int,int>(1,10) < make_pair<int,int>(1,20)) << endl;
    cout << "(1,10) < (1,5) ? : " << (make_pair<int,int>(1,10) < make_pair<int,int>(1,5)) << endl;
    cout << "(1,10) < (0,8.5) ? : " << (make_pair<int,double>(1,10) < make_pair<int,double>(0,8.5)) << endl;
    cout << "(0,0) != (0,8) ? : " << (make_pair<int,int>(0,0) != make_pair<int,int>(0,0)) << endl;
    cout << "(0,5) > (0,5) ? : " << (make_pair<int,int>(0,5) > make_pair<int,int>(0,5)) << endl;
    cout << "(\"pomme\",10) < (\"tomate\",40) ? : " << (make_pair<string,int>("pomme",10) < make_pair<string,int>("tomate",40)) << endl;

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
    sortContainers<int, vector<int>, vector<int>::iterator, greater<int>>( testSubset3.begin(), testSubset3.end() );
    cout << "vect<int> sorted : ";
    displayIterable( testSubset3.begin(), testSubset3.end() );

    cout << "list<int> to sort : ";
    list<int> listToSort = {9, 6, 8, 5, 3, 66, 4, 1, 9, 0, 6, 7, 4, 88, 65};
    displayIterable( listToSort.begin(), listToSort.end() );
    // /!\ ERROR when computing this line, I can't explain why ?????????????????????????????????
    //sortContainers<int, list<int>, list<int>::iterator>( listToSort.begin(), listToSort.end() );
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

    cout << "\n\n   Bonus. Comparaison vector, deque, list : \n - a. clock comparaison when add 1000000 integers : " << endl;
    vector<int> cmpVector;
    list<int> cmpList;
    deque<int> cmpDeque;
    cout << "Clock for vector<int> : " << timeSpendToAddNElements<vector<int>>( cmpVector, 1000000 ) << endl;
    cout << "Clock for list<int> : " << timeSpendToAddNElements<list<int>>( cmpList, 1000000 ) << endl;
    cout << "Clock for deque<int> : " << timeSpendToAddNElements<deque<int>>( cmpDeque, 1000000 ) << endl;

    cout << " - b. clock comparaison with 10.000 integers step : (output folder)" << endl;
    vector<int> cmpGnuVector;
    list<int> cmpGnuList;
    deque<int> cmpGnuDeque;
    ofstream output { "output/clock_comparaison.dat" };
    output << setiosflags(ios::left);
    output << setw(20) << "# nb_elements" << setw(20) << "nb_clocks_vector" << setw(20) << "nb_clocks_deque" << setw(20) << "nb_clocks_list" << endl;
    int step = 10000;
    for ( int i = step; i <= step * 100; i += step ) {
        output << setw(20) << i
               << setw(20) << timeSpendToAddNElements<vector<int>>( cmpGnuVector, step )
               << setw(20) << timeSpendToAddNElements<deque<int>>( cmpGnuDeque, step )
               << setw(20) << timeSpendToAddNElements<list<int>>( cmpGnuList, step ) << endl;
    }

    return 1;
}
