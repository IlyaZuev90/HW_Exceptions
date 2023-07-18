package ru.netology.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Element with id: " + id + " already exist");
    }
}
