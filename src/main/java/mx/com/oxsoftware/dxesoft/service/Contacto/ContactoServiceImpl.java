package mx.com.oxsoftware.dxesoft.service.Contacto;

import com.google.common.base.Preconditions;
import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import mx.com.oxsoftware.dxesoft.model.repositories.ContactoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ContactoServiceImpl implements ContactoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactoServiceImpl.class);

    @Autowired
    ContactoRepository contactoRepository;

    @Override
    @Transactional
    public void createContacto(Contacto contacto) {
        LOGGER.debug("CreateContacto");
        contactoRepository.save(contacto);
    }

    @Override
    @Transactional
    public void deleteContacto(Contacto contacto) {
        LOGGER.debug("deleteContacto");
        contactoRepository.delete(contacto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> findAll() {
        LOGGER.debug("contacto findAll");
        return contactoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Contacto findById(Long id) {
        LOGGER.debug("findById");
        return contactoRepository.findOne(id);
    }

    @Override
    @Transactional
    public void update(Contacto contacto) throws Exception {
        LOGGER.debug("update");
        Preconditions.checkNotNull(contacto);
        Contacto exist = contactoRepository.findOne(contacto.getId());
        if (exist == null) {
            throw new Exception("alsdkfj");
        } else {
            contactoRepository.save(contacto);
        }
    }
}
