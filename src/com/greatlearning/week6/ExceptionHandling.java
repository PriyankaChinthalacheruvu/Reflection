package com.greatlearning.week6;

public class ExceptionHandling extends Exception{
    String err;

    public ExceptionHandling(String msg){ //manually adding err msg
        err = msg;
    }

    public String getErr(){ //param const.
        return err;
    }

}