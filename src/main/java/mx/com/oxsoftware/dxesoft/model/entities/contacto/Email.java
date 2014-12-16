package mx.com.oxsoftware.dxesoft.model.entities.contacto;

import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;
import mx.com.oxsoftware.dxesoft.utils.EmailType;

import javax.persistence.*;

/**
 * Created by ernesto on 12/13/14.
 *
 * Represents the email address in the database.
 */
@Entity
@Table(name = "email")
public class Email extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "contactoId")
    private Contacto contacto;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "tipoEmail")
    @Enumerated(EnumType.STRING)
    private EmailType emailType;

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }
}
