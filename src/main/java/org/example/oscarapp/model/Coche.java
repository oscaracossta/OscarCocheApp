package org.example.oscarapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coches")
@Data
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private int anio;

    private String matricula;
}