package gl.lab5.springproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gl.lab5.springproject.model.Ticket;

public interface MyRepository extends JpaRepository<Ticket, Integer> {

}
