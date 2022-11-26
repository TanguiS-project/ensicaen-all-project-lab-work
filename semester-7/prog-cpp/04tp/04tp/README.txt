STEIMETZ Tangui & PICQUE Kylian- Rapport tp04 C++

Introduction : 
Compiler le programme : $ make
Executer le programme : $ ./bin/main ou $ make run
Verification Valgrind : $ make valgrind
Netoyer archive       : $ make clean ou make distclean

1. Ce genre de sous-graphe portent le nom de ??

2. Le destructeur de 'Obstacle' devra etre 'virtual' pour que les bons destructeurs soient utilises.

Trace programme pour 5 conteurs : 

round(c0/c0)=1, round(c1/c0)=4, round(c2/c0)=6, round(c3/c0)=4, round(c4/c0)=1, 
_______________________________________________________
|                        \   /                        |
|                                                     |
|                          *                          |
|                     *         *                     |
|                *         *         *                |
|           *         *         *         *           |
|   |0.063|   |0.252|   |0.374|   |0.248|   |0.063|   |
\_________________________   _________________________/
 \______________________|1.000|______________________/ 


Trace valgrind : 

valgrind --leak-check=full ./bin/main
==20102== Memcheck, a memory error detector
==20102== Copyright (C) 2002-2017, and GNU GPL'd, by Julian Seward et al.
==20102== Using Valgrind-3.18.1 and LibVEX; rerun with -h for copyright info
==20102== Command: ./bin/main
==20102== 

round(c0/c0)=1, round(c1/c0)=4, round(c2/c0)=6, round(c3/c0)=4, round(c4/c0)=1, 
_______________________________________________________
|                        \   /                        |
|                                                     |
|                          *                          |
|                     *         *                     |
|                *         *         *                |
|           *         *         *         *           |
|   |0.062|   |0.250|   |0.376|   |0.250|   |0.062|   |
\_________________________   _________________________/
 \______________________|1.000|______________________/ 

==20102== 
==20102== HEAP SUMMARY:
==20102==     in use at exit: 0 bytes in 0 blocks
==20102==   total heap usage: 38 allocs, 38 frees, 77,823 bytes allocated
==20102== 
==20102== All heap blocks were freed -- no leaks are possible
==20102== 
==20102== For lists of detected and suppressed errors, rerun with: -s
==20102== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)