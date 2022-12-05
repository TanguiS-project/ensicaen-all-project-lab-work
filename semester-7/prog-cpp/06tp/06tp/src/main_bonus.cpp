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

#include "bonus.h"
#include <iomanip>
#include <fstream>

using namespace std;

int main( void ) {
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