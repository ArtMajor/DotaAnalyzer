package ua.nure.babenko.dotaanalyzer.exceptions;

/**
 * Created by fomenko on 16.06.2017.
 */
public class InitException extends RuntimeException {
    public InitException(){super();}

    public InitException(String message, Throwable cause){super(message, cause);}

    public InitException(String message){super(message);}
}
