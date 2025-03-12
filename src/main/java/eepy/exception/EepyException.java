package eepy.exception;

/**
 * Represents a custom exception for the Eepy application.
 * This exception is thrown when an application-specific error occurs.
 */
public class EepyException extends Exception{

    /**
     * Constructs an EepyException with the specified error message.
     *
     * @param message The error message associated with the exception.
     */
    public EepyException(String message){
        super(message);
    }
}
