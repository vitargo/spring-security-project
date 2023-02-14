package org.vitargo.springsecuritysection6.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection6.model.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
