package restaurante.example.demo.service.mapper;

import org.mapstruct.Mapper;
import restaurante.example.demo.persistence.model.MesaEntity;
import restaurante.example.demo.presentation.dto.MesaDTO;

@Mapper(componentModel = "spring")
// Interfaz para realizar la conversión entre objetos DTO y entidades de Mesa.
// Utiliza MapStruct para la generación automática de código de mapeo.
public interface IMesaMapper {    
    MesaDTO mesaEntityToMesaDto(MesaEntity mesaEntity); // Convierte una entidad Mesa a un DTO
    MesaEntity mesaDtoToMesaEntity(MesaDTO mesaDto); // Convierte un DTO Mesa a una entidad    
}
