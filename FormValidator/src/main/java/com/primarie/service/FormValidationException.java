package com.primarie.service;

public class FormValidationException extends Exception {
    public FormValidationException(){};
    public FormValidationException(String message){
        super(message);
    }

}
