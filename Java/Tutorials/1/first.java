

public class td1 {
    public static void main(String[] args) {
        int[] tab = { 1, 2, 5, 4, 5 };
        int [] A = new int[6];
        readTab(tab);
        System.out.println(isOrderedTab(tab, 0, 3));
    }

    public static int smallerOfTwo(int i, int j) {
        return Math.min(i, j);
    }

    public static void switchElements(int[] tab, int i, int j){
        int c = tab[i];
        tab[i] = tab[j];
        tab[j] = c;
        System.out.println("Elements switched");
    }

    public static void readTab(int[] tab){
        for (int i : tab) {
            System.out.println(i);
        }
    }

    public static void copyTab(int[] A, int[] B){
        for (int i : A) {
            B[i] = A[i];
        }
        System.out.println("Elements of A are copied in the end of B");
    }

    public static boolean isOrderedTab(int[] tab, int i, int j) {
        for (int k = i; k < j; k++) {
            if (tab[k] > tab[k + 1]) {
                return false;
            }
        }
        return true;
    }
}


