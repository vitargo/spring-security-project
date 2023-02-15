package org.vitargo.springsecuritysection8.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection8.model.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
