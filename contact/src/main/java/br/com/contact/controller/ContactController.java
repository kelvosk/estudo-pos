package br.com.contact.controller;

import br.com.contact.impl.ContactServiceImpl;
import br.com.contact.request.ContactRequest;
import br.com.contact.response.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponse> get(){
        return this.contactService.getAllContact();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addContact(@RequestBody ContactRequest request){
        this.contactService.addContact(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        this.contactService.deleteById(id);
    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse getContactByName(@RequestParam String name){
        return this.contactService.getContactByName(name);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateContact(@RequestBody ContactRequest contact, @RequestParam Long id){
        this.contactService.updateContact(contact, id);
    }

}
