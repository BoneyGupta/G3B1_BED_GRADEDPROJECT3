package gl.lab5.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gl.lab5.springproject.model.Ticket;
import gl.lab5.springproject.service.MyService;

@Controller
@RequestMapping("/tickets")
public class MyController {

	@Autowired
	public MyService svc;

	@GetMapping("/")
	public String getAllTickets(Model model) {
		model.addAttribute("tickets", svc.getAllTickets());
		return "tickets";
	}
	
	@GetMapping("/test")
	public String testHTML(Model model) {
		return "test";
	}
	
//	Edit Tickets page
	@GetMapping("/edit/{id}")
	public String editTicket(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("ticket", svc.findByNum(id));
		return "edit_tkt";
	}

	@PostMapping("/save/{id}")
	public String updateTicket(@PathVariable(name = "id") Integer id,
			@ModelAttribute(name = "ticket") Ticket tkt) {
		tkt.setId(id);
		svc.saveTicket(tkt);
		return "redirect:/tickets/";
	}

//	View Tickets Page
	@GetMapping("/view/{id}")
	public String viewTicket(Model model, @PathVariable(name = "id") Integer id) {

		model.addAttribute("ticket", svc.findByNum(id));
		return "/view/{id}";
	}

//	New Ticket
	@GetMapping("/new")
	public String addTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return ("edit_tkt");
	}

	@PostMapping("/save")
	public String saveNewTicket(@ModelAttribute(name = "ticket") Ticket tkt) {

		svc.saveTicket(tkt);
		return "redirect:/tickets/";
	}

//	Search Ticket
	@GetMapping("/search/{query}")
	public String searchTicket(@PathVariable(name = "query") String query, Model model) {
		model.addAttribute("tickets", svc.searchTickets(query));
		return "tickets";
	}

// 	Delete Ticket
	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(name = "id") Integer id) {
		svc.deleteTicket(id);
		return "redirect:/tickets";
	}

	
}
