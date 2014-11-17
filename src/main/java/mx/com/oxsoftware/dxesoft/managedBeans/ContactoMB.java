package mx.com.oxsoftware.dxesoft.managedBeans;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import mx.com.oxsoftware.dxesoft.service.Contacto.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by ernesto on 11/12/14.
 */
@ManagedBean
@Controller
@Scope("request")
public class ContactoMB {

    @Autowired
    ContactoService contactoService;

    Contacto contacto = new Contacto();

    List<Contacto> contactos;

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void addContact() {
        contacto.setId(2L);
        contactoService.createContacto(contacto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contacto " + contacto.getPrimerNombre() + " agregado"));
    }

    public void getAllContactos() {
        contactos = contactoService.findAll();
    }
}
