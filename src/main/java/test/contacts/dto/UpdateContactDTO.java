package test.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateContactDTO {

    private String name;

    private int age;

    private String number;
}
