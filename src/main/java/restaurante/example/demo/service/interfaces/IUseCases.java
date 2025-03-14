package restaurante.example.demo.service.interfaces;

import restaurante.example.demo.error.EntityDataAccesException;
import restaurante.example.demo.error.EntityNotFoundException;

import java.util.List;

// Interfaz que define los casos de usos generales de la aplicacion.
public interface IUseCases<DTO, ID> {
    List<DTO> findAll(); 
    DTO findById(ID id) throws EntityNotFoundException; 
    DTO create(DTO entityDto) throws EntityDataAccesException;
    DTO update(ID id, DTO entityDto) throws EntityNotFoundException, EntityDataAccesException; 
    String delete(ID id) throws EntityNotFoundException;
}