package com.taskmanager.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
    }
}

