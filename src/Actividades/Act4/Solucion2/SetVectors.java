package Actividades.Act4.Solucion2;

import java.util.*;

class SetVectors {
    PriorityQueue<Limits> set = new PriorityQueue<>(
            (l1, l2) -> Integer.compare(l2.length(), l1.length()));

    void insertar(Limits p) {
        set.offer(p);
    }

    Limits mayor() {
        return set.poll();
    }

    int longMayor() {
        return set.isEmpty() ? 0 : set.peek().length();
    }

    boolean esVacio() {
        return set.isEmpty();
    }

    void destruir() {
        set.clear();
    }
}