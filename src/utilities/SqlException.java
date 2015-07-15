package utilities;

/**
 * Exception when an SQL error occurs.
 * 
 * @author hirscha
 */
public class SqlException extends RuntimeException {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -5797835641816283239L;

    /**
     * Public constructor.
     * 
     * @param message The error message.
     */
    public SqlException(final String message) {
        super(message);
    }

    /**
     * Public constructor.
     * 
     * @param message The error message
     * @param throwable The underlying throwable
     */
    public SqlException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}