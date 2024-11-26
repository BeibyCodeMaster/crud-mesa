package restaurante.example.demo.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import restaurante.example.demo.persistence.enums.StatusEnum;
import restaurante.example.demo.persistence.enums.UbicacionEnum;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="mesa")
// Clase que representa la entidad "Mesa", que corresponde a la tabla "mesa" en la base de datos.
public class MesaEntity {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mesa")
    private Long id; // Identificador único de la mesa
    
    private String codigo; // Código único de la mesa
    
    private byte capacidad; // Capacidad máxima de personas que puede acomodar la mesa
    
    @Enumerated(EnumType.STRING)
    private StatusEnum estado; // Estado actual de la mesa (disponible, ocupada, reservada)
    
    private Boolean decorada; // Indica si la mesa está decorada
    
    @Enumerated(EnumType.STRING)
    private UbicacionEnum ubicacion; // Ubicación de la mesa dentro del establecimiento (interior, exterior, terraza)
    
    @Column(length = 50000000)
    private byte[] imagen; // Imagen asociada a la mesa (puede ser una foto, etc.)
    
    @Column(name="ruta_imagen")
    private String rutaImagen; // Ruta del archivo de imagen de la mesa en el sistema
}



