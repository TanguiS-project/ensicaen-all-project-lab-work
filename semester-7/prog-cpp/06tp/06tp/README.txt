RAPPORT - TP06 c++ - Kylian Picque & Steimetz Tangui

1   Les iterateurs version STL
Q1, Remarque : la taille du 'set' est 20 -> seul une iteration d'un element est tolere dans un 'set'.
Q2, Remarque : une relation d'orde est utilisee car plusieurs ietration d'un element peu etre utilise, il faut donc un 'moyen' pour les differencier.

2   Taille et capcacite d'un vecteur
Q3, Remarque : La taille alloue pour un type 'vector' est un multiple de 2 pour eviter un 'realloc' lors de l'appel a 'push_back' et que l'operation soit o(1).

3   Tri a l'aide d'une priority_queue
Aucune Remarque

4   Tableaux associatifs
Q4, Remarque : Les couples presents dans une 'map' sont tries par leur valeur de 'key' de maniere decroissante par default.
               Dans notre cas, la veleur des premiers characteres semblent etre utilisees pour trier les couples.
Q5, Remarque : 'make_pair()' devait etre utilisee pour normaliser la facon dont le couple (key,value) et 'tuples' sont compares.
Q6, Remarque : l'operateur [] surcharge par 'map' creer ou remplace un (couple). Donc dans cette exemple le couple (0, 0) -> couple par default est cree quand 'tab[0]'est appele.
               C'est pourquoi la condition est toujours vraie car la taille est 3 et non 2 apres l'appel de l'operateur [].

5   Algorithmes
Aucune Remarque

6   Bonus (output dossier, graph.png)
Q7, Remarque : L'ajout est en temps constant ( car en o(1) ) tant que la capacite du vecteur le permet, 
               quand un 'realloc' ou ajout de capacites s'effectue il est necessaire de deplacer tous les elements puis d'ajouter, on l'observe facilement avec les 'picques' qui precedent les temps constants.
Q8, Remarque : L'ajout en fin de 'list' semble constant (je ne saurais expliquer l'apparition des picques de temps) et est plus elevee de maniere generale comapre a l'operation d'ajout en fi nde 'vector'



=-= TRACE =-=

   1. Les iterateurs version STL :
 - Vector Display : 0 19 3 2 9 14 9 0 14 9 12 6 0 4 18 10 14 9 2 5 18 3 1 20 10 20 0 1 6 0 19 6 19 1 6 5 13 15 5 4 
       size = 40
 - Set Display : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
       size = 21
 - Display Vector/Set with 2 iterators : 
 - Vector Display : 0 19 3 2 9 14 9 0 14 9 12 6 0 4 18 10 14 9 2 5 18 3 1 20 10 20 0 1 6 0 19 6 19 1 6 5 13 15 5 4 
 - Set Display : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 


   2. Taille et capacite d'un vecteur : 
 - Random fill with trace on a vector : 
Init capacity observer, capacity = 0
 -> Observed Change of capacity : was : 0 and is : 1
 -> Observed Change of capacity : was : 1 and is : 2
 -> Observed Change of capacity : was : 2 and is : 4
 -> Observed Change of capacity : was : 4 and is : 8
 -> Observed Change of capacity : was : 8 and is : 16
 -> Observed Change of capacity : was : 16 and is : 32
 -> Observed Change of capacity : was : 32 and is : 64
 -> Observed Change of capacity : was : 64 and is : 128
 -> Observed Change of capacity : was : 128 and is : 256
 -> Observed Change of capacity : was : 256 and is : 512
 -> Observed Change of capacity : was : 512 and is : 1024
 -> Observed Change of capacity : was : 1024 and is : 2048
 -> Observed Change of capacity : was : 2048 and is : 4096
 -> Observed Change of capacity : was : 4096 and is : 8192


   3. Tri a l'aide d'une priority_queue : 
V1 : 
Vector to sort : 0 19 3 2 9 14 9 0 14 9 12 6 0 4 18 10 14 9 2 5 18 3 1 20 10 20 0 1 6 0 19 6 19 1 6 5 13 15 5 4 
Vector sorted : 0 0 0 0 0 1 1 1 2 2 3 3 4 4 5 5 5 6 6 6 6 9 9 9 9 10 10 12 13 14 14 14 15 18 18 19 19 19 20 20 
V2 : 
Vector<int> to sort : 0 19 3 2 9 14 9 0 14 9 12 6 0 4 18 10 14 9 2 5 18 3 1 20 10 20 0 1 6 0 19 6 19 1 6 5 13 15 5 4 
Vector<int> sorted : 0 0 0 0 0 1 1 1 2 2 3 3 4 4 5 5 5 6 6 6 6 9 9 9 9 10 10 12 13 14 14 14 15 18 18 19 19 19 20 20 
Vector<double> to sort : 548.4 87 9.513 1.3189 21.3 2.8789 123.2 98.7 20 8.498 0.87 0.4984 8723.18 7.4 98.4985 4898.98 1.51 
Vector<double> sorted : 0.4984 0.87 1.3189 1.51 2.8789 7.4 8.498 9.513 20 21.3 87 98.4985 98.7 123.2 548.4 4898.98 8723.18 


   4. Tableaux associatifs
 - Fill map with : 
age["Gerard"] = 16;
age["Jean-Claude"] = 73;
age["DiBen"] = 50;
 - Display map : 
(DiBen,50)(Gerard,16)(Jean-Claude,73)
   4.2. (Ordre sur) le modele pair : 
(1,10) < (2,3) ? : true
(1,10) < (1,20) ? : true
(1,10) < (1,5) ? : false
(1,10) < (0,8.5) ? : false
(0,0) != (0,8) ? : false
(0,5) > (0,5) ? : false
("pomme",10) < ("tomate",40) ? : true


   5. Algorithme :
 - Algorithme isSubset : 
vect1 : 1 2 3 4 5 4 
vect3 : 9 8 7 6 5 4 3 2 8 8 8 1 
vect1 isSubset of vect3? : true
vect2 : 1 2 3 4 5 4 -1 
vect3 : 9 8 7 6 5 4 3 2 8 8 8 1 
vect2 isSubset of vect3? : false
 - Algorithme sortContainers : 
vect<int> to sort : 9 8 7 6 5 4 3 2 8 8 8 1 
vect<int> sorted : 1 2 3 4 5 6 7 8 8 8 8 9 
list<int> to sort : 9 6 8 5 3 66 4 1 9 0 6 7 4 88 65 
list<int> sorted : 9 6 8 5 3 66 4 1 9 0 6 7 4 88 65 


   5. Swap Algo : 
 - Swap begin with end-1 on a vector :
1 2 3 4 5 6 7 8 8 8 8 9 
unswaped vector : swaped vector : 9 2 3 4 5 6 7 8 8 8 8 1 
 - Swap begin with ++begin on a list : 
unswaped list : 9 6 8 5 3 66 4 1 9 0 6 7 4 88 65 
swaped list : 6 9 8 5 3 66 4 1 9 0 6 7 4 88 65 


   Bonus. Comparaison vector, deque, list : 
 - a. clock comparaison when add 1000000 integers : 
Clock for vector<int> : 38751
Clock for list<int> : 87655
Clock for deque<int> : 33570
 - b. clock comparaison with 10.000 integers step : (output folder)
