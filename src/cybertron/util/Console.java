package cybertron.util;

import java.util.Scanner;

public class Console {

    static Scanner sc = new Scanner(System.in);






    public static String getInput(String msg) {
        System.out.println(msg);
        return sc.next();
    }





    void test() {
        var personsMultitude = getInput("Αριθμός ατόμων: ");
        var stars = getInput("*: ");

        if(stars.equals(1)){

        }
    }
}
