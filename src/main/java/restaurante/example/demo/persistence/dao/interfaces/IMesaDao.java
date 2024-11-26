package restaurante.example.demo.persistence.dao.interfaces;

import restaurante.example.demo.persistence.model.MesaEntity;

import java.util.List;
import java.util.Optional;

// Interfaz que define las operaciones básicas de acceso a datos para la entidad "Mesa".
public interface IMesaDao {
    List<MesaEntity> findAll(); // Listar todos los registros de mesas en la base de datos.
    Optional<MesaEntity> findById(Long id); // Buscar un registro de mesa por su ID.
    MesaEntity save(MesaEntity mesa); // Guardar o actualizar una mesa en la base de datos.
    void deleteById(Long id); // Eliminar un registro de mesa por su ID.
}
