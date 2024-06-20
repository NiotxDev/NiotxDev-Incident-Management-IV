package edu.cibertec.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Incidencia")
public class Incidencia {

    public enum NivelPrioridad {
        ALTO,
        MEDIO,
        BAJO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codIncidencia;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Column(name = "fechaRegistro")
    private LocalDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivelPrioridad", nullable = false, length = 10)
    private NivelPrioridad nivelPrioridad = NivelPrioridad.BAJO;

    @ManyToOne
    @JoinColumn(name = "codEmpleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "codCategoria", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "incidencia")
    private Set<Atencion> atenciones;

    public Incidencia(Long codIncidencia, String descripcion, LocalDateTime fechaRegistro,
			NivelPrioridad nivelPrioridad, Empleado empleado, Categoria categoria, Set<Atencion> atenciones) {
		super();
		this.codIncidencia = codIncidencia;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
		this.nivelPrioridad = nivelPrioridad;
		this.empleado = empleado;
		this.categoria = categoria;
		this.atenciones = atenciones;
	}
    
	public Incidencia() {
		super();
	}

	// Getters and Setters
    public Long getCodIncidencia() {
        return codIncidencia;
    }

    public void setCodIncidencia(Long codIncidencia) {
        this.codIncidencia = codIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public NivelPrioridad getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(NivelPrioridad nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Atencion> getAtenciones() {
        return atenciones;
    }

    public void setAtenciones(Set<Atencion> atenciones) {
        this.atenciones = atenciones;
    }
}
