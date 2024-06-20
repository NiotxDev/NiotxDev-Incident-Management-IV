package edu.cibertec.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEmpleado;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 50)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNac")
    private LocalDate fechaNac;

    @Column(length = 50)
    private String direccion;

    @Column(length = 50)
    private String tipoEmp;

    @ManyToOne
    @JoinColumn(name = "codDepartamento", nullable = false)
    private Departamento departamento;

    @OneToMany(mappedBy = "empleado")
    private Set<Incidencia> incidencias;
    
    public Empleado(Long codEmpleado, String nombre, String apellido, String email, LocalDate fechaNac, String direccion,
			String tipoEmp, Departamento departamento, Set<Incidencia> incidencias) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.tipoEmp = tipoEmp;
		this.departamento = departamento;
		this.incidencias = incidencias;
	}

	public Empleado() {
		super();
	}

	// Getters and Setters
    public Long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoEmp() {
        return tipoEmp;
    }

    public void setTipoEmp(String tipoEmp) {
        this.tipoEmp = tipoEmp;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Set<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Set<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public int getEdad() {
        return Period.between(this.fechaNac, LocalDate.now()).getYears();
    }
}
