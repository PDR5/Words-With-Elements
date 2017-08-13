package main;

import java.util.Scanner;

/**
 * Test
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementWriter ew = null;
        try {
            ew = new ElementWriter();
        } catch (ElementSourceUnavaibleException e) {
            System.out.println("Unable to load chemical element content");
            return;
        }
        String word;
        while(!(word = scanner.nextLine()).equals("")){
            System.out.println(ew.write(word));
        }
    }
}
