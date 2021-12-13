public class first {
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.print(h('a', 'a') + " ");
        }
        System.out.println();
        for (int i = 0; i < 15; i++){
            System.out.print(h('a', 'b') + " ");
        }
        System.out.println();
        for (int i = 0; i < 20; i++){
            System.out.print(h('a', 'c') + " ");
        }

        System.out.println();

        System.out.println(randomDouble(3, 5));

        System.out.println();

        System.out.println(randomString('a', 'd'));
    }

    public static char h(char c1, char c2){ // cette methode return aleatoirement un caractere entre c1 et c2 (y compris c1 et c2)
        return (char)(c1 + Math.random()*(c2-c1+1));
    }

    public static String charString(char...c){ // prend une table de caractere et la transform en un seul string
        return new String(c);
    }

    public static double randomDouble(double d1, double d2){ // generate double between d1 et d2
        return Math.random()*(d2 - d1) + d1;
   }

   public static String randomString(char c1, char c2){
        int l = c2 - c1;
        char[] c = new char[l];
        for( int i : c){
            c[i] = h(c2, c1);
        }
        return new String(c);
   }
}

