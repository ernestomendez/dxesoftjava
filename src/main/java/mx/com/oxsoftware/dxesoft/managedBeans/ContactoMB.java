package mx.com.oxsoftware.dxesoft.managedBeans;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import mx.com.oxsoftware.dxesoft.model.entities.contacto.Email;
import mx.com.oxsoftware.dxesoft.model.entities.contacto.PhoneNumber;
import mx.com.oxsoftware.dxesoft.service.Contacto.ContactoService;
import mx.com.oxsoftware.dxesoft.utils.EmailType;
import mx.com.oxsoftware.dxesoft.utils.Gender;
import mx.com.oxsoftware.dxesoft.utils.PhoneType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
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
    private ContactoService contactoService;

    private Contacto contacto = new Contacto();

    private List<Contacto> contactos;

    private String phone1;

    private PhoneType phoneType1;

    private String phone2;

    private PhoneType phoneType2;

    private String phone3;

    private PhoneType phoneType3;

    private String email1;

    private EmailType emailType1;

    private String email2;

    private EmailType emailType2;

    private String email3;

    private EmailType emailType3;

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

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
        contacto.setPhoneNumbers(this.getPhoneNumbers());
        contacto.setEmails(this.getEmails());
        contactoService.createContacto(contacto);

        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle resourceBundle = fc.getApplication().getResourceBundle(fc, "contact_msg");
        String message = resourceBundle.getString("contact.added.sucess");

        MessageFormat messageFormat = new MessageFormat(message);
        Object params[] = {contacto.getNombres()};

        StringBuffer format = messageFormat.format(params, new StringBuffer(), null);

        message = format.toString();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
    }

    public void getAllContactos() {
        contactos = contactoService.findAll();
    }

    public Gender[] getGenders() {
        return Gender.values();
    }

    public PhoneType[] getPhoneTypes() {
        return PhoneType.values();
    }

    public EmailType[] getEmailTypes() {
        return EmailType.values();
    }

    public PhoneType getPhoneType1() {
        return phoneType1;
    }

    public void setPhoneType1(PhoneType phoneType1) {
        this.phoneType1 = phoneType1;
    }

    public PhoneType getPhoneType2() {
        return phoneType2;
    }

    public void setPhoneType2(PhoneType phoneType2) {
        this.phoneType2 = phoneType2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public PhoneType getPhoneType3() {
        return phoneType3;
    }

    public void setPhoneType3(PhoneType phoneType3) {
        this.phoneType3 = phoneType3;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public EmailType getEmailType1() {
        return emailType1;
    }

    public void setEmailType1(EmailType emailType1) {
        this.emailType1 = emailType1;
    }

    public EmailType getEmailType2() {
        return emailType2;
    }

    public void setEmailType2(EmailType emailType2) {
        this.emailType2 = emailType2;
    }

    public EmailType getEmailType3() {
        return emailType3;
    }

    public void setEmailType3(EmailType emailType3) {
        this.emailType3 = emailType3;
    }

    private List<PhoneNumber> getPhoneNumbers() {

        List<PhoneNumber> phoneNumbers = new ArrayList<>(3);

        for (int i = 1; i < 4; i++) {
            Method getPhone = null;
            Method getPhoneType = null;
            try {
                getPhone = this.getClass().getMethod("getPhone" + i, (Class<?>[]) null);
                getPhoneType = this.getClass().getMethod("getPhoneType" + i, (Class<?>[]) null);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            CharSequence phoneNumber = null;
            PhoneType phoneType = null;
            try {
                phoneNumber =(CharSequence) getPhone.invoke(this, (Object[]) null);
                phoneType =(PhoneType) getPhoneType.invoke(this, (Object[]) null);

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (StringUtils.isNotBlank(phoneNumber)) {
                PhoneNumber number = new PhoneNumber();
                number.setNumber(phoneNumber.toString());
                number.setPhoneType(phoneType);
                number.setContacto(this.contacto);
                phoneNumbers.add(number);
            }
        }

        return phoneNumbers;
    }

    private List<Email> getEmails() {

        List<Email> emails = new ArrayList<>(3);

        for (int i = 1; i < 4; i++) {
            Method getEmail = null;
            Method getEmailType = null;
            try {
                getEmail = this.getClass().getMethod("getEmail" + i, (Class<?>[]) null);
                getEmailType = this.getClass().getMethod("getEmailType" + i, (Class<?>[]) null);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            CharSequence email = null;
            EmailType emailType = null;
            try {
                email =(CharSequence) getEmail.invoke(this, (Object[]) null);
                emailType =(EmailType) getEmailType.invoke(this, (Object[]) null);

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (StringUtils.isNotBlank(email)) {
                Email newEmail = new Email();
                newEmail.setEmail(email.toString());
                newEmail.setEmailType(emailType);
                newEmail.setContacto(this.contacto);
                emails.add(newEmail);
            }
        }

        return emails;
    }
}
