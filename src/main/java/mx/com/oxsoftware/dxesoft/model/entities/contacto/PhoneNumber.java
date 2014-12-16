package mx.com.oxsoftware.dxesoft.model.entities.contacto;

import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;
import mx.com.oxsoftware.dxesoft.utils.PhoneType;

import javax.persistence.*;

/**
 * Created by ernesto on 12/11/14.
 *
 * Represents the Phone numbers in the database.
 */
@Entity
@Table(name = "telefono")
public class PhoneNumber extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "contactoId")
    private Contacto contacto;

    @Column(name = "codigoInternacional", length = 3)
    private String internationalCode;

    @Column(name = "numero", length = 14)
    private String number;

    @Column(name = "extension", length = 5)
    private String extension;

    @Column(name = "tipoTelefono")
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getInternationalCode() {
        return internationalCode;
    }

    public void setInternationalCode(String internationalCode) {
        this.internationalCode = internationalCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
