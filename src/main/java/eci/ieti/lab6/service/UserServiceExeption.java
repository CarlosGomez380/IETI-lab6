package eci.ieti.lab6.service;

public class UserServiceExeption extends Exception{

    public UserServiceExeption(String message) {
        super(message);
    }

    public UserServiceExeption(String message, Throwable cause) {
        super(message, cause);

    }
}
