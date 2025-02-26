package org.example.Controller;

public class BuildException extends RuntimeException {
    public BuildException(String attribute, Object value) {
        super(attribute+" value is invalid: "+ value);
    }
}
