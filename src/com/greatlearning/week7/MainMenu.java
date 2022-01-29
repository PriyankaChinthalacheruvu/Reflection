package com.greatlearning.week7;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainMenu {
    int menuChoice; //Menu Choice
    Logger log = new Logger();
    Scanner scanner = new Scanner(System.in);
    String out="";
    //Method to do menu functions
    public void enterMenu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {

        System.out.println("Enter Class Name to search , or exit to close app");
        String in = scanner.next();
        if (in.equalsIgnoreCase("exit"))
            System.exit(0); //giving option to exit early

        Class c = null;
        //Creating class and instance from .forName()
        try {
            c = Class.forName(in);
            System.out.println("Class Exists");
            out = c.getName();
        } catch (ClassNotFoundException e) {
            System.out.println("Class does not exist"); //Checking if class name really exists
            enterMenu(); // else asks again for appropriate class

        }

//Start Menu
        System.out.println("---------------------------------------------------");
        System.out.println("Please Select Operation You Want to Perform :");
        System.out.println("Press 1 to see Methods");
        System.out.println("Press 2 to see Class");
        System.out.println("Press 3 to see SubClasses");
        System.out.println("Press 4 to see ParentClasses");
        System.out.println("Press 5 to see Constructors");
        System.out.println("Press 6 to see data Members");
        System.out.println("Press 9 to exit Application");
        System.out.println("---------------------------------------------------");
        System.out.println(" ");
        System.out.println ("Press any key:");
        menuChoice = scanner.nextInt();
    //switch case for menu driven choice
        switch (menuChoice) {
            case 1:
                //case for Method JAVA Reflect API
                Method[] methods= c.getDeclaredMethods();

                System.out.println("List of Methods :");
                for (Method method:methods) { //parsing through list
                    System.out.println(method.getName());
                    out += "\n " + method.getName();
                }
                getsubmenu(out); //passing data / result to submenu for saving etc
                break;
            case 2:
                //case for .class / getclassname method Reflection API
                out =c.getName();
                System.out.println("Class information --> "+out);
                getsubmenu(out);
                break;
            case 3:
                //case for SUBCLASS information by creating instance
                Class[] subclasses = c.getDeclaredClasses() ;
                if(subclasses.length>0) {
                    System.out.println("List of Sub Classes :");
                    for (Class class1 : subclasses) {
                        System.out.println(class1.getName());
                        out += "\n " + class1.getName();
                    }
                }
                else
                {
                    System.out.println("No Subclasses");
                    getsubmenu("NO Subclasses");
                }

                break;

            case 4:
                //case for SUPERCLASS java reflections
                Class superclass = c.getSuperclass() ;
                if(superclass!=null) {
                    System.out.println("Super Class :");
                    System.out.println(superclass.getName());
                    out += "\n " + superclass.getName();
                    getsubmenu(out);
                }
                else
                {
                    System.out.println("No Superclass");
                    getsubmenu("NO Superclass");
                }
                break;

            case 6:
                //case for FIELD Reflection type
                Field[] fields= c.getFields();

                System.out.println("List of Fields/Data Members :");
                for (Field field:fields) {
                    System.out.println(field.getName());
                    out += "\n " + field.getName();
                }
                getsubmenu(out);


                getsubmenu(out);
                break;

            case 5:
                //case for COnstructor Reflections API
                Constructor[] constructors= c.getConstructors();

                System.out.println("List of Constructors :");
                for (Constructor constructor:constructors) {
                    System.out.println(constructor.getName());
                    out += "\n " + constructor.getName();
                }
                getsubmenu(out);
                break;

            case 9:
                System.out.println("... Exiting Reading Application ...");

                log.saveLog();

                System.exit(0);
                break;

        }



    }

    public void getsubmenu(String out) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
        log.generateLog("Main menu");
        System.out.println("Do you want to see more information ? \n Press 1 if yes 0 if no");
        int menusubChoice;
        menusubChoice = scanner.nextInt();
        if(menusubChoice==1) {
            MainSubMenu studentsSubMenu = new MainSubMenu();
            studentsSubMenu.entersubMenu(out);
        }
        else if(menusubChoice==0){
            System.out.println("Do you want to EXIT !! ? \n Press 1 if yes 0 if no");
            int menusubChoice2;
            menusubChoice2 = scanner.nextInt();
            if(menusubChoice2==1)
                System.exit(0);
            else
                enterMenu();
        }

    }
}


