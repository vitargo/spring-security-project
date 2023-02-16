package org.vitargo.springsecuritysection10.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection10.model.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
