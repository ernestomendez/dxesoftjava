package mx.com.oxsoftware.dxesoft.model.entities.contacto;

import mx.com.oxsoftware.dxesoft.model.entities.AbstractEntity;
import mx.com.oxsoftware.dxesoft.utils.Gender;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ernesto on 11/8/14.
 *
 * Represents the contact into the data base.
 */
@Entity
@Table(name = "contacto")
public class Contacto extends AbstractEntity {

    @Column(length = 200)
    private String nombres;

    @Column(length = 60)
    private String apellidoPaterno;

    @Column(length = 60)
    private String apellidoMaterno;

    @Column(length = 50)
    private String titulo;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender genero;

    @Column
    private String paginaWeb;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime fechaCreacion;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime fechaNacimiento;

    @Column(length = 15)
    private String rfc;

    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL)
    private List<Email> emails;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Gender getGenero() {
        return genero;
    }

    public void setGenero(Gender genero) {
        this.genero = genero;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public DateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(DateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public DateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(DateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
