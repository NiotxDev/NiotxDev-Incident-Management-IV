package edu.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Empleado;
import edu.cibertec.repository.EmpleadoRepositorio;

import java.util.List;

@Service
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    
	public List<Empleado> findAll(String palabraClave) {
		if(palabraClave !=null) {
			return empleadoRepositorio.findAll(palabraClave);
		}
		return empleadoRepositorio.findAll();
	}
    
	public void save(Empleado empleado) {
		empleadoRepositorio.save(empleado);
	}
	
	public Empleado get(Long id) {
		return empleadoRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		empleadoRepositorio.deleteById(id);
	}
}
