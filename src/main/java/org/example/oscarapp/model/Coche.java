package org.example.oscarapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.Year;

@Entity
@Table(name = "coches")
@Data
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La marca no puede estar vacía")
    @Size(min = 2, max = 50, message = "La marca debe tener entre 2 y 50 caracteres")
    private String marca;

    @NotBlank(message = "El modelo no puede estar vacío")
    @Size(min = 1, max = 50, message = "El modelo debe tener entre 1 y 50 caracteres")
    private String modelo;

    @Min(value = 1900, message = "El año debe ser mayor o igual a 1900")
    @Max(value = 2100, message = "El año no puede ser superior a 2100")
    private int anio;

    @NotBlank(message = "La matrícula no puede estar vacía")
    @Pattern(
            regexp = "^[0-9]{4}[A-Z]{3}$",
            message = "La matrícula debe seguir el formato español: 4 dígitos seguidos de 3 letras mayúsculas (ej: 1234ABC)"
    )
    private String matricula;
}