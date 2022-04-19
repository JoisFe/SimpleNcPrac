package com.nhnacademy;

public class InvalidCommandException extends IllegalArgumentException {
    public InvalidCommandException(String s) {
        super(s);
    }
}
