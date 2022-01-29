package com.greatlearning.week7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    //create log file
    static File logfile = new File("reading-log-file.txt");
    static FileWriter fw;

    static {
        try {
            fw = new FileWriter(logfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    PrintWriter pw = new PrintWriter(fw);
    public void generateLog(String printLog){
        pw.println(printLog);
    }

    // method to save changes
    public void  saveLog(){

        pw.close();
    }


}
