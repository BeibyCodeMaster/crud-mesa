package restaurante.example.demo.service.interfaces;

import restaurante.example.demo.error.EntityDataAccesException;
import restaurante.example.demo.error.EntityNotFoundException;

import java.util.List;

// Interfaz genérica que define los métodos principales para los casos de uso CRUD en el sistema
public interface IUseCases<DTO, ID> {
    List<DTO> getAll(); // Obtener todos los registros
    DTO getOneById(ID id) throws EntityNotFoundException; // Obtener un registro por su ID
    DTO create(DTO entityDto) throws EntityDataAccesException; // Crear nuevo registro
    DTO update(ID id, DTO entityDto) throws EntityNotFoundException, EntityDataAccesException; // Actualizar un registro existente
    String delete(ID id) throws EntityNotFoundException; // Eliminar un registro por su ID
}