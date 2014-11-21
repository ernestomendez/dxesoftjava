package mx.com.oxsoftware.dxesoft.managedBeans;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import mx.com.oxsoftware.dxesoft.service.Contacto.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by ernesto on 11/12/14.
 */
@ManagedBean
@Controller
@Scope("request")
public class ContactoMB {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactoMB.class);

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
        LOGGER.debug("addContact");
        contacto.setId(2L);
        contactoService.createContacto(contacto);

        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle resourceBundle = fc.getApplication().getResourceBundle(fc, "contact_msg");
        String message = resourceBundle.getString("contact.added.sucess");

        MessageFormat messageFormat = new MessageFormat(message);
        Object params[] = {contacto.getPrimerNombre()};

        StringBuffer format = messageFormat.format(params, new StringBuffer(), null);

        message = format.toString();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
    }

    public void getAllContactos() {
        contactos = contactoService.findAll();
    }
}
