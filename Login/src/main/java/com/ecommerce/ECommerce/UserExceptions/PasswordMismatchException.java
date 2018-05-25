package com.ecommerce.ECommerce.UserExceptions;

public class PasswordMismatchException extends Throwable {
    public PasswordMismatchException(String message) {
        super(message);
    }
}
