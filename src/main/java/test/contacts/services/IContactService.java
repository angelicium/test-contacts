package test.contacts.services;

import org.springframework.stereotype.Service;
import test.contacts.dto.CreateContactDTO;
import test.contacts.dto.GetContactDTO;
import test.contacts.dto.UpdateContactDTO;

import java.util.List;

public interface IContactService {
    List<GetContactDTO> getContacts();

    GetContactDTO createContact(CreateContactDTO  dto);

    GetContactDTO updateContact(Long id, UpdateContactDTO dto);

    void deleteContact(Long id);
}
