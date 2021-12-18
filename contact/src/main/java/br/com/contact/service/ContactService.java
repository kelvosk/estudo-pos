package br.com.contact.service;

import br.com.contact.entity.Contact;
import br.com.contact.request.ContactRequest;
import br.com.contact.response.ContactResponse;

import java.util.List;

public interface ContactService {

    public void addContact(ContactRequest request);
    public void deleteById(Long id);
    public ContactResponse getContactByName(String name);
    public List<ContactResponse> getAllContact();
    public void updateContact(ContactRequest contact, Long id);
    public Contact getContactById(Long id);
}
