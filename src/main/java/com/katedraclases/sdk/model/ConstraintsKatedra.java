package com.katedraclases.sdk.model;

import com.katedraclases.sdk.util.interfaces.ResponseKatedra;

public class ConstraintsKatedra implements ResponseKatedra {
    private String message;

    private String type;

    public ConstraintsKatedra() {
    }

    public ConstraintsKatedra(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
