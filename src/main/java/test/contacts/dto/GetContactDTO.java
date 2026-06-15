package test.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getter/setter, equals/hashCode
@AllArgsConstructor
public class GetContactDTO { // то что позволяем видеть клиенту извне
    private Long id;

    private String name;

    private String number;
}
