import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class firstFile{
    public static void main(String[] args){
        try {
            File meteor = new File("C:/Users/HP/IdeaProjects/tp1/src/meteor.txt");
            Scanner sc = new Scanner(meteor);
            double val1 = sc.nextDouble();
            while(sc.hasNextDouble()){
                double val2 = sc.nextDouble();
                System.out.println("Variance : " + (val2 - val1));
                val1 = val2;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}