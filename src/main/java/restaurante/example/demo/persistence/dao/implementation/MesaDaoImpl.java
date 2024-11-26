package restaurante.example.demo.persistence.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import restaurante.example.demo.persistence.dao.interfaces.IMesaDao;
import restaurante.example.demo.persistence.model.MesaEntity;
import restaurante.example.demo.persistence.repositoy.IMesaRepository;

import java.util.List;
import java.util.Optional;

@Component
// Implementación de la interfaz IMesaDao, que maneja las operaciones de acceso a datos para la entidad "Mesa".
public class MesaDaoImpl implements IMesaDao {
    
    @Autowired
    private IMesaRepository mesaRepository; // Repositorio de acceso a datos para la entidad "Mesa"

    @Override
    @Transactional(readOnly = true)
    public List<MesaEntity> findAll() {
        // Devuelve todos los registros de mesas desde la base de datos.
        return (List<MesaEntity>) this.mesaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MesaEntity> findById(Long id) {
        // Devuelve un registro de mesa basado en su ID, si existe.
        return this.mesaRepository.findById(id);
    }

    @Override
    @Transactional
    public MesaEntity save(MesaEntity mesa) {
        // Guarda o actualiza la mesa en la base de datos y retorna el objeto persistido.
        return this.mesaRepository.save(mesa);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // Elimina un registro de mesa basado en su ID.
        this.mesaRepository.deleteById(id);
    }
    
}
