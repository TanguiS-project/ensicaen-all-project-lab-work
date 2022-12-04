set size 1,1
set title("Comparaison clock time to push\\_back 10.000 integers step between Vector/Deque/List")
set xlabel("Number of integers in the containers")
set ylabel("Clock, time (ms)")
set key
set grid
set terminal png truecolor size 800,600
set output "output/graph.png"
plot "output/clock_comparaison.dat" using 1:2 with lp pt "+" lt rgb "#c080ff" title "vector<>",\
     "output/clock_comparaison.dat" using 1:3 with lp pt "+" lt rgb "#008040" title "deque<>",\
     "output/clock_comparaison.dat" using 1:4 with lp pt "+" lt rgb "#7fffd4" title "list<>"