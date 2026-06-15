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
       List<ContactEntity> entites =  this.contactRepository.findAll();
       return this.contactMapper.toListGetContactDTO(entites);
    }

    @Override
    public GetContactDTO createContact(CreateContactDTO dto) {
        ContactEntity newContact = ContactEntity.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .number(dto.getNumber())
                .build();

        this.contactRepository.save(newContact);

        return this.contactMapper.toGetContactDTO(newContact);
    }

    @Override
    public GetContactDTO updateContact(Long id, UpdateContactDTO dto) {
        Optional<ContactEntity> optContactEntity = this.contactRepository.findById(id);

        ContactEntity contactEntity = optContactEntity.orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Такого контакта не существует"
                )
        );

        contactEntity.setName(dto.getName());

        contactEntity.setAge(dto.getAge());

        contactEntity.setNumber(dto.getNumber());

        this.contactRepository.save(contactEntity);

        return this.contactMapper.toGetContactDTO(contactEntity);
    }

    @Override
    public void deleteContact(Long id) {
        this.contactRepository.deleteById(id);
    }
}
