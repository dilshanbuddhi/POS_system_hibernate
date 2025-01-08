package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;

    public CustomerDTO(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
