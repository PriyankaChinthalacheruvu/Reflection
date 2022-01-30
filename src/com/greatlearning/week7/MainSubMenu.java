package com.greatlearning.week7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainSubMenu extends MainMenu {

    Logger log = new Logger();

    public void entersubMenu(String in) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {

        System.out.println("---------------------------------------------------");
        System.out.println("Please Select Operation You Want to Perform :");
        System.out.println("Press 1 to store information to file");
        System.out.println("Press 2 to see all previous files created");
        System.out.println("Press 3 to exit without storing");
        System.out.println("Press 4 to go to main menu after saving");

        System.out.println("---------------------------------------------------");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Press any key:");
        int menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                //printing log in file
                log.generateLog(in);
                entersubMenu(in);
                break;
            case 2:
                //reading old file
                File existlogfile = new File("reading-log-file.txt");
                FileReader fr = new FileReader(existlogfile);
                String file= fr.toString();
                System.out.println("file-->"+file);
                entersubMenu(in);
                break;

            case 3:
                //exit without saving log file
                System.out.println("... Exiting Reading Application ...");
                System.exit(0);
                break;

            case 4:
                //save the log file and go back to main menu
                log.saveLog();
                super.enterMenu();
                break;

        }
    }
}
