package com.iftm.start_example.models.dto;

import com.iftm.start_example.models.Address;
import com.iftm.start_example.models.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private String id;
    private String name;
    private int age;
    private Address address;

    public UserDTO(User user) {
        this.id = user.getId().toString();
        this.name = user.getName().toString();
        this.age = user.getAge();
        this.address = user.getAddress();
    }

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

}