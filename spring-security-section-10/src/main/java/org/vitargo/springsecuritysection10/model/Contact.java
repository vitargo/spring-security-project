package org.vitargo.springsecuritysection10.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "contact_messages")
public class Contact {

    @Id
    @Column(name = "contact_id", columnDefinition = "uuid")
    private UUID contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_email")
    private String contactEmail;

    private String subject;

    private String message;

    @Column(name = "create_dt")
    private Date createDt;
}
