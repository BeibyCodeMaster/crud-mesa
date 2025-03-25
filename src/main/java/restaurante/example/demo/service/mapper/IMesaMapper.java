package restaurante.example.demo.service.mapper;

import org.mapstruct.Mapper;
import restaurante.example.demo.persistence.model.MesaEntity;
import restaurante.example.demo.presentation.dto.MesaDTO;

@Mapper(componentModel = "spring")
// Interaz que conviente una entidad a un dto o  un dto a una entidad.
public interface IMesaMapper {    
    MesaDTO mesaEntityToMesaDto(MesaEntity mesaEntity); // Convierte una entidad Mesa a un DTO
    MesaEntity mesaDtoToMesaEntity(MesaDTO mesaDto); // Convierte un DTO Mesa a una entidad    
}
