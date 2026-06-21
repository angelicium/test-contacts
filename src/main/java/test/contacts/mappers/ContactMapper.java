package test.contacts.mappers;

import org.mapstruct.Mapper;
import test.contacts.dto.CreateContactDTO;
import test.contacts.dto.GetContactDTO;
import test.contacts.dto.UpdateContactDTO;
import test.contacts.entities.ContactEntity;
import java.util.List;

@Mapper(componentModel = "spring") // mapper почитать что это
public interface ContactMapper {
    GetContactDTO toGetContactDTO(ContactEntity entity);

    List<GetContactDTO> toListGetContactDTO(List<ContactEntity> entities);

    ContactEntity toEntity(CreateContactDTO dto);

    ContactEntity changeEntity(Long id, UpdateContactDTO dto);
}
