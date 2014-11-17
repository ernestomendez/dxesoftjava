package mx.com.oxsoftware.dxesoft.model.repositories;

import mx.com.oxsoftware.dxesoft.model.entities.contacto.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by ernesto on 11/12/14.
 */
@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
