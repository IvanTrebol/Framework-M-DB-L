

package database.SQLExceptions;


public class DELETEException extends Exception {

    /**
     * Creates a new instance of <code>INSERTException</code> without detail
     * message.
     */
    public DELETEException() {
        System.out.println("An error ocurred in the DELETE operation");
    }

    /**
     * Constructs an instance of <code>INSERTException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DELETEException(String msg) {
        super(msg);
    }

}
