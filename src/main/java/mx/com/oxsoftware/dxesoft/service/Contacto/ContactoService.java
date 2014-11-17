package mx.com.oxsoftware.dxesoft.service.Contacto;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;

import java.util.List;

/**
 * Created by ernesto on 11/12/14.
 *
 * Manages all "Contacto" operations.
 */
public interface ContactoService {

    void createContacto (Contacto contacto);

    void deleteContacto (Contacto contacto);

    List<Contacto> findAll ();

    Contacto findById (Long id);

    void update (Contacto contacto) throws Exception;

}
