package com.katedra.sdk.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

import com.katedra.sdk.dto.UserKatedraDto;
import com.katedra.sdk.model.ConstraintsKatedra;
import com.katedra.sdk.model.UserKatedra;
import com.katedra.sdk.util.interfaces.ResponseKatedra;

import java.util.ArrayList;
import java.util.List;

public class ResponseKatedraConverter {

    public static List<? extends ResponseKatedra> createResponseKatedraList(List<Object> list) throws NoSuchFieldException, IllegalAccessException, Exception {
        if (list.isEmpty()) return new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> mapList = objectMapper.convertValue(list, List.class);

        if (mapList.get(0).containsKey("userKatedra")) {
            List<ResponseKatedra> userKatedraDtoList = new ArrayList<>();
            for (Map<String, Object> map : mapList) {
                UserKatedra userKatedra = UserKatedraConverter.createUserKatedra(map.get("userKatedra"));
                UserKatedraDto userKatedraDto = new UserKatedraDto();
                userKatedraDto.setUserKatedra(userKatedra);
                userKatedraDto.setPassword((String) map.get("password"));
                userKatedraDtoList.add(userKatedraDto);
            }
            return userKatedraDtoList;
        } else {
            List<ConstraintsKatedra> constraintsKatedraList = new ArrayList<>();
            for (Map<String, Object> map : mapList) {
                ConstraintsKatedra c = objectMapper.convertValue(map, ConstraintsKatedra.class);
                constraintsKatedraList.add(c);
            }
            return constraintsKatedraList;
        }
    }

}
