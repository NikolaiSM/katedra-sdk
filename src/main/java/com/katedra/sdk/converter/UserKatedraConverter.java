package com.katedra.sdk.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import com.katedra.sdk.model.UserKatedra;

public class UserKatedraConverter {
    public static UserKatedra createUserKatedra(Object obj) throws NoSuchFieldException, IllegalAccessException, Exception {
//        Class<?> parentClass = obj.getClass();
//
//        Long id = (Long) parentClass.getDeclaredField("id").get(obj);
//        String name = (String) parentClass.getDeclaredField("name").get(obj);
//        String lastName = (String) parentClass.getDeclaredField("lastName").get(obj);
//        String email = (String) parentClass.getDeclaredField("email").get(obj);
//        String role = (String) parentClass.getDeclaredField("role").get(obj);


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> user = objectMapper.convertValue(obj, Map.class);

        Long id = ((Number) user.get("id")).longValue();
        String name = (String) user.get("name");
        String lastName = (String) user.get("lastName");
        String email = (String) user.get("email");
        String role = (String) user.get("role");

        if (id != null && name != null && lastName != null && email != null && role != null) {
            return new UserKatedra(id, name, lastName, email, role);
        } else {
            throw new Exception("Error parsing fields");
        }
    }
}
