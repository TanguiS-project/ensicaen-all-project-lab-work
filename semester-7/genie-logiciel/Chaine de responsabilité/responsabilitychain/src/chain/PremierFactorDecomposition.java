package chain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PremierFactorDecomposition {
    private PremierFactorDecomposition() {
    }

    public static List<Integer> decomposePowPremiers( int number ) {
        HashMap<Integer, Integer> decomposition = decompose(number);
        return new ArrayList<>(decomposition.keySet());
    }

    private static HashMap<Integer, Integer> decompose( int number ) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int i = 2;
        while (i <= number) {
            if (isPremier(i)) {
                if (number % i == 0) {
                    processHashtable(res, i);
                    number /= i;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return res;
    }

    private static void processHashtable( HashMap<Integer, Integer> hashMap, int i ) {
        boolean present = false;
        for (Integer v : hashMap.keySet()) {
            if (v == i) {
                present = true;
                break;
            }
        }
        if (present) {
            hashMap.put(i, hashMap.get(i) + 1);
        } else {
            hashMap.put(i, 1);
        }
    }

    private static boolean isPremier( int n ) {
        boolean p = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                p = false;
                break;
            }
        }
        return p;
    }
}

