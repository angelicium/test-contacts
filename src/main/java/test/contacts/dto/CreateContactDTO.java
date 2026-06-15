package test.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateContactDTO {

    private String name;

    private int age;

    private String number;
}
