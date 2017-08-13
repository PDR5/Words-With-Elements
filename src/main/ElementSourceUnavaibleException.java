package main;

import java.io.IOException;

/**
 *
 */
public class ElementSourceUnavaibleException extends Exception {
    /**
     * @param ioe
     */
    public ElementSourceUnavaibleException(IOException ioe){
        super(ioe);
    }
}
