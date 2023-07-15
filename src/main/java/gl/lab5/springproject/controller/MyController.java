package gl.lab5.springproject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	public String date;

	@Autowired
	public MyService svc;

	@GetMapping("/")
	public String getAllTickets(Model model, @Param("query") String query) {
		System.out.println(query);
		List<Ticket> ticket = svc.getAllTickets(query);
		model.addAttribute("tickets", ticket);
		model.addAttribute("query", query);
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
		date = svc.findByNum(id).getTicketCreatedOn();
		return "edit_tkt";
	}

	@PostMapping("/save/{id}")
	public String updateTicket(@PathVariable(name = "id") Integer id, @ModelAttribute(name = "ticket") Ticket tkt) {
		tkt.setId(id);
		tkt.setTicketCreatedOn(date);
		date = "";
		svc.saveTicket(tkt);
		return "redirect:/tickets/";
	}

//	View Tickets Page
	@GetMapping("/view/{id}")
	public String viewTicket(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("ticket", svc.findByNum(id));
		return "view_tkt";
	}

//	New Ticket
	@GetMapping("/new")
	public String addTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "create_tkt";
	}

	@PostMapping("/save")
	public String saveNewTicket(@ModelAttribute(name = "ticket") Ticket tkt) {

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		tkt.setTicketCreatedOn(currentDate.format(formatter));
		tkt.setTicketContent(tkt.getTicketContent().replaceAll("<p>|</p>|<br>", ""));
		svc.saveTicket(tkt);
		return "redirect:/tickets/";
	}

// 	Delete Ticket
	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(name = "id") Integer id) {
		svc.deleteTicket(id);
		return "redirect:/tickets/";
	}

}
