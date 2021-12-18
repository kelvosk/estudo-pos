package br.com.contact.repositories;

import br.com.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    public Contact findByName(String name);
}
