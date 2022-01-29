package com.greatlearning.week6;

import java.io.IOException;
import java.util.HashMap;

public class ReaderApplication {
    public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("Starting Reader Appliaction ... ");
        //Logging Mechanism
        Logger log = new Logger();
        log.generateLog("******** Log For Last Session ********\n");

        //Main Menu Driven Class obj
        MainMenu stu = new MainMenu();
        stu.enterMenu();
        //Saving Log
        log.saveLog();
    }

}

