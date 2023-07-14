package gl.lab5.springproject.service;

import java.util.List;

import gl.lab5.springproject.model.Ticket;

public interface MyService {

	public List<Ticket> getAllTickets(String query);

	public void saveTicket(Ticket tkt);

	public int deleteTicket(int tkt_num);

	public Ticket findByNum(int tkt_num);

//	List<Ticket> searchTickets(String query);

}
