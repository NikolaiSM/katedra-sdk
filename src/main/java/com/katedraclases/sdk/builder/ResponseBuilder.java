package com.katedraclases.sdk.builder;

import com.katedraclases.sdk.model.ConstraintsKatedra;
import com.katedraclases.sdk.util.interfaces.ResponseKatedra;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ResponseBuilder {
    public static ResponseEntity<List<? extends ResponseKatedra>> build(String message, String field){
        List<ConstraintsKatedra> list = new ArrayList<>();
        list.add(new ConstraintsKatedra(message, field));

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public static ResponseEntity<List<? extends ResponseKatedra>> build(List<? extends ResponseKatedra> list){
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
