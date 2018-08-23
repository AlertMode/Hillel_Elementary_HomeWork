package edu.palmirov.hillel.task_27.exceptions;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message){
        super(message);
    }
}