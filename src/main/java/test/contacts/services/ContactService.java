package test.contacts.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import test.contacts.dto.CreateContactDTO;
import test.contacts.dto.GetContactDTO;
import test.contacts.dto.UpdateContactDTO;
import test.contacts.entities.ContactEntity;
import test.contacts.mappers.ContactMapper;
import test.contacts.repositories.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService implements IContactService {
    private ContactRepository contactRepository;

    private ContactMapper contactMapper;

    @Override
    public List<GetContactDTO> getContacts() {
       List<ContactEntity> entities =  this.contactRepository.findAll();
       return this.contactMapper.toListGetContactDTO(entities);
    }

    @Override
    public GetContactDTO createContact(CreateContactDTO dto) {
        ContactEntity newContact = this.contactMapper.toEntity(dto);

        this.contactRepository.save(newContact);

        return this.contactMapper.toGetContactDTO(newContact);
    }

    private ContactEntity getContactByID(Long id) throws ResponseStatusException {
        Optional<ContactEntity> optContactEntity = this.contactRepository.findById(id);

        return optContactEntity.orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Такого контакта не существует"
                )
        );
    }

    @Override
    public GetContactDTO updateContact(Long id, UpdateContactDTO dto) throws ResponseStatusException {
        ContactEntity contactEntity = this.getContactByID(id);

        this.contactRepository.save(
                this.contactMapper.changeEntity(id, dto)
        );

        return this.contactMapper.toGetContactDTO(contactEntity);
    }

    @Override
    public void deleteContact(Long id) throws ResponseStatusException {
        ContactEntity contactEntity = this.getContactByID(id);

        this.contactRepository.delete(contactEntity);
    }
}
