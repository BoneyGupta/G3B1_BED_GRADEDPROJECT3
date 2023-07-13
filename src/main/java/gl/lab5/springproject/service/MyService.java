package gl.lab5.springproject.service;

import java.util.List;

import gl.lab5.springproject.model.Ticket;

public interface MyService {

	List<Ticket> getAllTickets();

	void saveTicket(Ticket tkt);

	int deleteTicket(int tkt_num);

	Ticket findByNum(int tkt_num);

	List<Ticket> searchTickets(String query);

}
