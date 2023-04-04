package com.katedraclases.sdk.dto;

import com.katedraclases.sdk.model.UserKatedra;
import com.katedraclases.sdk.util.interfaces.ResponseKatedra;

public class UserKatedraDto implements ResponseKatedra {
    private UserKatedra userKatedra;

    private String password;

    public UserKatedraDto() {
    }

    public UserKatedraDto(UserKatedra userKatedra, String password) {
        this.userKatedra = userKatedra;
        this.password = password;
    }

    public UserKatedra getUserKatedra() {
        return userKatedra;
    }

    public void setUserKatedra(UserKatedra userKatedra) {
        this.userKatedra = userKatedra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
