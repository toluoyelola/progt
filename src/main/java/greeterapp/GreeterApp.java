package greeterapp;

import greeterlibrary.GreeterLibrary;

import java.util.Scanner;

public class GreeterApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter language (hungarian/english/yoruba, default is hun): ");
        String language = scanner.nextLine().trim();

        if (language.isEmpty()) {
            language = null;
        }

        try {
            String greeting = GreeterLibrary.greet(name, language);
            System.out.println(greeting);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }
    }
}