package test.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.contacts.dto.CreateContactDTO;
import test.contacts.dto.GetContactDTO;
import test.contacts.dto.UpdateContactDTO;
import test.contacts.entities.ContactEntity;
import test.contacts.entities.PersonEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
