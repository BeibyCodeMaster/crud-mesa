package restaurante.example.demo.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import restaurante.example.demo.exceptions.EntityDataAccesException;
import restaurante.example.demo.exceptions.EntityNotFoundException;
import restaurante.example.demo.persistence.dao.interfaces.IMesaDao;
import restaurante.example.demo.persistence.model.MesaEntity;
import restaurante.example.demo.presentation.dto.MesaDTO;
import restaurante.example.demo.service.interfaces.IMesaService;
import restaurante.example.demo.service.mapper.IMesaMapper;

import java.util.List;
import java.util.Optional;

@Service
// Contiene todos los casos de uso referentes a la mesa en la aplicacion.
public class MesaServiceImpl implements IMesaService {

    @Autowired
    private IMesaDao mesaDao; // DAO para acceder a la base de datos

    @Autowired
    private IMesaMapper mesaMapper; // Mapper para convertir entre entidad y DTO

    // Obtiene la lista de todas las mesas en forma de DTOs
    @Override
    public List<MesaDTO> findAll() {  
        return this.mesaDao.findAll().stream()
            .map(this.mesaMapper::mesaEntityToMesaDto)
            .toList();        
    }

    // Obtiene una mesa específica por su ID y la convierte en un DTO
    @Override
    public MesaDTO findById(Long id) throws EntityNotFoundException { 
        return this.mesaDao.findById(id)
            .map(this.mesaMapper::mesaEntityToMesaDto)
            .orElseThrow(() -> new EntityNotFoundException("La mesa con el id " + id + " no existe."));
    }

    // Crea una nueva mesa en la base de datos a partir de un DTO proporcionado
    @Override
    public MesaDTO create(MesaDTO mesaDto) throws EntityDataAccesException {                    
        MesaEntity mesaEntity = this.mesaMapper.mesaDtoToMesaEntity(mesaDto);            
        try {
            this.mesaDao.save(mesaEntity); // Guarda la entidad en la base de datos
            return this.mesaMapper.mesaEntityToMesaDto(mesaEntity); // Devuelve la entidad guardada como DTO
        } catch (DataAccessException e) {
            System.err.println("service/create :" + e.getMessage()); // Log de error
            throw new EntityDataAccesException("Error interno del servidor."); // Manejo de excepción
        }            
    }   
    
    // Actualiza una mesa existente, validando primero su existencia
    @Override
    public MesaDTO update(Long id, MesaDTO mesaDto) throws EntityNotFoundException, EntityDataAccesException {        
        MesaEntity mesaEntity =  this.mesaDao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("La mesa no existe."));
        this.updateEntityFromDto(mesaEntity, mesaDto); // Actualiza los campos de la entidad
        try {
            this.mesaDao.save(mesaEntity); // Guarda los cambios en la base de datos
            return this.mesaMapper.mesaEntityToMesaDto(mesaEntity); // Devuelve la entidad actualizada como DTO
        } catch (DataAccessException e) {
            System.err.println("service/update :" + e.getMessage()); // Log de error
            throw new EntityDataAccesException("Error interno del servidor."); // Manejo de excepción
        }
    }

    // Elimina una mesa específica por su ID, verificando su existencia
    @Override
    public String delete(Long id) throws EntityNotFoundException {        
        Optional<MesaEntity> mesaOptional = this.mesaDao.findById(id);       
        if (mesaOptional.isEmpty()) {         
            throw new EntityNotFoundException("La mesa con el ID " + id + " no existe.");
        }
        this.mesaDao.deleteById(id);       
        return "La mesa con el ID " + id + " fue eliminada.";
    }

    // Método auxiliar que actualiza los atributos de la entidad Mesa a partir de un DTO
    private void updateEntityFromDto(MesaEntity mesaEntity, MesaDTO mesaDto) {
        mesaEntity.setCodigo(mesaDto.getCodigo()); // Asigna el código de la mesa
        mesaEntity.setCapacidad(mesaDto.getCapacidad()); // Asigna la capacidad
        mesaEntity.setEstado(mesaDto.getEstado()); // Asigna el estado
        mesaEntity.setUbicacion(mesaDto.getUbicacion()); // Asigna la ubicación
        mesaEntity.setDecorada(mesaDto.getDecorada()); // Asigna la decoración
        mesaEntity.setImagen(mesaDto.getImagen()); // Asigna la imagen
        mesaEntity.setRutaImagen(mesaDto.getRutaImagen()); // Asigna la ruta de la imagen
    }
}