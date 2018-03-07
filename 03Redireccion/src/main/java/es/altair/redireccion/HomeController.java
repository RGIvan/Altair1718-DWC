package es.altair.redireccion;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/redireccionar", method = RequestMethod.GET)
	public String tratamientoRedireccion() {
		return "redirect:finalRedireccion";
	}
	@RequestMapping(value = "/finalRedireccion", method = RequestMethod.GET)
	public String metodoFinal() {
		//codigo
		return "redirect:/resources/inicio.html";
	}
}