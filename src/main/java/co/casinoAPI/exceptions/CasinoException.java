package co.casinoAPI.exceptions;

public class CasinoException extends Exception{
    public static final String INVALID_VALUE = "The value of the bet must be between 0 - 10000";
    public static final String INVALID_NUMBER = "The number must be between 0 - 36";
    public static final String INVALID_COLOR = "The color must be 'b' for Black or 'r' for red";
    public CasinoException(String message){
        super(message);
    }
}
