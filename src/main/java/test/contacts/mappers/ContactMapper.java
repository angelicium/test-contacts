package test.contacts.mappers;

import org.springframework.stereotype.Component;
import test.contacts.dto.GetContactDTO;
import test.contacts.entities.ContactEntity;

import java.util.ArrayList;
import java.util.List;

@Component // mapper почитать что это
public class ContactMapper {
    public GetContactDTO toGetContactDTO(ContactEntity entity) {
        return new GetContactDTO(
                entity.getId(),
                entity.getName(),
                entity.getNumber()
        );
    }

    public List<GetContactDTO> toListGetContactDTO(List<ContactEntity> entities) {
        List<GetContactDTO> result = new ArrayList<>();

        for (ContactEntity entity : entities)
            result.add(
                    this.toGetContactDTO(entity)
            );
        return result;
    }
}
