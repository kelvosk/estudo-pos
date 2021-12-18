package br.com.contact.impl;

import br.com.contact.entity.Contact;
import br.com.contact.repositories.ContactRepository;
import br.com.contact.request.ContactRequest;
import br.com.contact.response.ContactResponse;
import br.com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void addContact(ContactRequest request) {
        this.contactRepository.save(Contact.builder().build().convertRequestToEntity(request));
    }

    @Override
    public void deleteById(Long id) {
        this.contactRepository.deleteById(id);
    }

    @Override
    public ContactResponse getContactByName(String name) {
        return Contact.builder().build()
                .convertEntityToResponse(contactRepository.findByName(name));
    }

    @Override
    public List<ContactResponse> getAllContact() {
        return this.contactRepository.findAll().stream().
                map(contact -> contact.convertEntityToResponse(contact))
                .collect(Collectors.toList());
    }

    @Override
    public void updateContact(ContactRequest contactRequest, Long id) {

        Contact c = getContactById(id);

        c.setName(contactRequest.getName());
        c.setEmail(contactRequest.getEmail());
        c.setPhone(contactRequest.getPhone());

        this.contactRepository.save(c);
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.getById(id);
    }

}
