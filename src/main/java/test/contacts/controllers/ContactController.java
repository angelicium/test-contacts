package test.contacts.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.contacts.dto.CreateContactDTO;
import test.contacts.dto.GetContactDTO;
import test.contacts.dto.ResponseDTO;
import test.contacts.dto.UpdateContactDTO;
import test.contacts.services.IContactService;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@AllArgsConstructor
public class ContactController {
    private IContactService contactService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<GetContactDTO>>> getContacts() {
        List<GetContactDTO> contacts = this.contactService.getContacts();

        ResponseDTO<List<GetContactDTO>> response  = ResponseDTO
                .<List<GetContactDTO>>builder()
                .data(contacts)
                .build();

        return ResponseEntity.ok(response);
    }

  @PostMapping
  public ResponseEntity<ResponseDTO<GetContactDTO>> createContact(@RequestBody CreateContactDTO dto) {
        GetContactDTO contact = this.contactService.createContact(dto);

      ResponseDTO<GetContactDTO> response  = ResponseDTO
              .<GetContactDTO>builder()
              .data(contact)
              .build();
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
  @PutMapping("/{id}")
  public ResponseEntity<ResponseDTO<GetContactDTO>> updateContact(@PathVariable("id") Long id, @RequestBody UpdateContactDTO dto) {
        GetContactDTO contact = this.contactService.updateContact(id, dto);
      ResponseDTO<GetContactDTO> response  = ResponseDTO
              .<GetContactDTO>builder()
              .data(contact)
              .build();
      return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteContact(@PathVariable("id") Long id) {
       this.contactService.deleteContact(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
