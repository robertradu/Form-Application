package com.primarie.model;

public abstract class  StateForm extends Form {
    protected String authorizationNr;

    public String getAuthorizationNr() {
        return authorizationNr;
    }

    public void setAuthorizationNr(String authorizationNr) {
        this.authorizationNr = authorizationNr;
    }
}
