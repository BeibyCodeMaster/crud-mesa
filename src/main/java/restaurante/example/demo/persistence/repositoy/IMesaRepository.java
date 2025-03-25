package restaurante.example.demo.persistence.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import restaurante.example.demo.persistence.model.MesaEntity;

@Repository
// Interfaz que define las interaciones que puede realizar la mesa con la base de datos
public interface IMesaRepository extends CrudRepository<MesaEntity, Long> {
    // Aquí puedes definir sentencias personalizadas para consultas específicas sobre la entidad Mesa, si es necesario.
}

