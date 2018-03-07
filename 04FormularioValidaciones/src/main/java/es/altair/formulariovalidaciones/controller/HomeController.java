package es.altair.formulariovalidaciones.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.altair.formulariovalidaciones.bean.Alumno;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("alumno", new Alumno());
		return "home";
	}
	
	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public String mostrarInfoAlumno(@Valid Alumno alumno, BindingResult result, Model modelo) {
		
		if (result.hasErrors())
				modelo.addAttribute("mensaje", "Alumno Incorrecto");
		else
			modelo.addAttribute("mensaje", "Alumno Correcto");
		
		return "home";
	}
}