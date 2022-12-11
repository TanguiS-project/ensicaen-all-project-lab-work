package chain;

import java.util.ArrayList;
import java.util.List;

public class ResultPool {
    private final List<MathCompute> results;

    public ResultPool() {
        results = new ArrayList<>();
    }

    public synchronized void addResult( MathCompute m ) {
        results.add(m);
    }

    public void printResult() {
        System.out.println("* Affichage des résultats");
        for (MathCompute m : results) {
            System.out.print(m.getValue() + "=");
            for (int j = 0; j < m.getResult().size(); j++) {
                if (j > 0) {
                    System.out.print("*");
                }
                System.out.print(m.getResult().get(j));
            }
            System.out.println("");
        }
    }
}
