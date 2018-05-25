package com.ecommerce.ECommerce.UserExceptions;

public class UserExistsException extends Throwable {
    public UserExistsException(String message) {
        super(message);
    }
}
