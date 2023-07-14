package gl.assignment.springproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import gl.assignment.springproject.model.Ticket;

public interface MyRepository extends JpaRepository<Ticket, Integer> {
}
