package gl.assignment.springproject.service;

import java.util.List;

import gl.assignment.springproject.model.Ticket;

public interface MyService {

	public List<Ticket> getAllTickets(String query);

	public void saveTicket(Ticket tkt);

	public int deleteTicket(int tkt_num);

	public Ticket findByNum(int tkt_num);

}
