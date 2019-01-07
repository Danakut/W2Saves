package com.dana.Exceptions;

public class PropertyNotAssembledException extends Exception {

    public PropertyNotAssembledException() {

    }

    public PropertyNotAssembledException(String message) {
        super(message);
    }

    public PropertyNotAssembledException(String message, Throwable cause) {
        super(message, cause);
    }
}
