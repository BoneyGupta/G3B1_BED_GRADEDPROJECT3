package gl.lab5.springproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.lab5.springproject.dao.MyRepository;
import gl.lab5.springproject.model.Ticket;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	MyRepository repo;

	@Override
	public List<Ticket> getAllTickets() {
		return repo.findAll();
	}

	@Override
	public void saveTicket(Ticket tkt) {
		repo.save(tkt);
	}

	@Override
	public int deleteTicket(int tkt_num) {
		repo.deleteById(tkt_num);
		return tkt_num;
	}

	@Override
	public Ticket findByNum(int tkt_num) {
		Optional<Ticket> optemp = repo.findById(tkt_num);
		if (optemp.isPresent())
			return optemp.get();
		else
			throw new RuntimeException("Ticket does not exist");
	}

	@Override
	public List<Ticket> searchTickets(String query) {
		List<Ticket> ls = repo.findAll();
		List<Ticket> temp = new ArrayList<>();
		for (Ticket tktemp : ls) {
			if (tktemp.getTicketTitle().toLowerCase().contains(query)
					|| tktemp.getTicketShortDesc().toLowerCase().contains(query))
				temp.add(tktemp);
		}
		return temp;
	}
}
