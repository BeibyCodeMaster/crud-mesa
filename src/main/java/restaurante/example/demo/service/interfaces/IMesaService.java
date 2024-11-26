package restaurante.example.demo.service.interfaces;

import restaurante.example.demo.presentation.dto.MesaDTO;


// Interfaz que define los casos de uso específicos para la entidad Mesa en el sistema.
// Extiende la interfaz genérica IUseCases.
public interface IMesaService extends IUseCases<MesaDTO, Long> {
    // Aquí puedes definir métodos adicionales exclusivos para los casos de uso de Mesa.
}
