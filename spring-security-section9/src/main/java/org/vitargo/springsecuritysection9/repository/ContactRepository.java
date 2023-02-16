package org.vitargo.springsecuritysection9.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vitargo.springsecuritysection9.model.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
