package com.github.beatrizgomees.api.authentication.service.email;

public class EmailFormatException extends Exception{

    public EmailFormatException(String msg){
        super(msg);
    }


    public static void emailIncorrectFormatException(){
        throw new RuntimeException("This email is already being used" );

    }

}
