package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.models.Empleado;
import edu.cibertec.services.EmpleadoServicio;

@Controller
public class EmpleadoControlador {
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@RequestMapping("/emp")
	public String verPaginaDeInicio(Model model, @Param("palabraClave") String palabraClave) {
		List<Empleado> listaEmpleado = empleadoServicio.findAll(palabraClave);
		model.addAttribute("listaEmpleado", listaEmpleado);
		model.addAttribute("palabraClave", palabraClave);
		return "indexEmp";
	}
	
	@RequestMapping("/nuevoEmp")
	public String mostrarFormularioDeRegistrar(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("empleado", empleado);
		return "nuevo_empleado";
	}
	
	@RequestMapping(value="/guardarEmp", method=RequestMethod.POST)
	public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		empleadoServicio.save(empleado);
		return "redirect:/emp";
	}
	
	@RequestMapping("/editarEmp/{id}")
	public ModelAndView mostrarFormularioDeEditar(@PathVariable(name="id") Long id) {
		ModelAndView modelo = new ModelAndView("editar_empleado");
		
		Empleado empleado = empleadoServicio.get(id);
		modelo.addObject("empleado", empleado);
		return modelo;
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(name="id") Long id) {
		empleadoServicio.delete(id);
		return "redirect:/emp";
	}
}
