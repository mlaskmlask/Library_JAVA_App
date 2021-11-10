package com.company;

import com.company.GUI.GUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GUI.showMenu();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                //login();
                break;
            case "2":
                GUI.showMenu();
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println("Podano niewłaściwe dane.");
                GUI.showMenu();
        }
    }

}
