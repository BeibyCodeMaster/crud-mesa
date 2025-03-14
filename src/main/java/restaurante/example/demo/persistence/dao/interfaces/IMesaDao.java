package restaurante.example.demo.persistence.dao.interfaces;

import restaurante.example.demo.persistence.model.MesaEntity;

import java.util.List;
import java.util.Optional;

// Interfaz que define las operaciones de base datos que realiza la entida mesa.
public interface IMesaDao {
    List<MesaEntity> findAll();
    Optional<MesaEntity> findById(Long id); 
    MesaEntity save(MesaEntity mesa);
    void deleteById(Long id); 
}
