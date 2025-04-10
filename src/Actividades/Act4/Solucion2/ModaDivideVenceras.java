package Actividades.Act4.Solucion2;

public class ModaDivideVenceras {

    public static void pivote2(int[] a, int mediana, int prim, int ult, int[] izqDer) {
        int izq = prim, der = prim;

        for (int i = prim; i <= ult; i++) {
            if (a[i] < mediana) {
                int tmp = a[i];
                a[i] = a[izq];
                a[izq++] = tmp;
            }
        }
        der = izq;
        for (int i = izq; i <= ult; i++) {
            if (a[i] == mediana) {
                int tmp = a[i];
                a[i] = a[der];
                a[der++] = tmp;
            }
        }
        izqDer[0] = izq;
        izqDer[1] = der;
    }

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors homog = new SetVectors();
        SetVectors heterog = new SetVectors();

        Limits p = new Limits(a, prim, ult);
        heterog.insertar(p);

        while (heterog.longMayor() > homog.longMayor()) {
            p = heterog.mayor();
            int mediana = a[(p.prim + p.ult) / 2];
            int[] izqDer = new int[2];

            pivote2(p.a, mediana, p.prim, p.ult, izqDer);

            Limits p1 = new Limits(p.a, p.prim, izqDer[0] - 1);
            Limits p2 = new Limits(p.a, izqDer[0], izqDer[1] - 1);
            Limits p3 = new Limits(p.a, izqDer[1], p.ult);

            if (p1.prim <= p1.ult)
                heterog.insertar(p1);
            if (p3.prim <= p3.ult)
                heterog.insertar(p3);
            if (p2.prim <= p2.ult)
                homog.insertar(p2);
        }

        if (homog.esVacio())
            return a[prim];
        p = homog.mayor();
        homog.destruir();
        heterog.destruir();
        return p.a[p.prim];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 4, 4, 5, 5 };
        System.out.println("Moda (Divide y Vencerás): " + moda3(arr, 0, arr.length - 1));
    }
}
