package edu.cibertec.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Atencion")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAtencion;

    @ManyToOne
    @JoinColumn(name = "codIncidencia", nullable = false)
    private Incidencia incidencia;
    
    public Atencion() {
		super();
	}

	// Getters and Setters
    public int getCodAtencion() {
        return codAtencion;
    }

    public void setCodAtencion(int codAtencion) {
        this.codAtencion = codAtencion;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
}

