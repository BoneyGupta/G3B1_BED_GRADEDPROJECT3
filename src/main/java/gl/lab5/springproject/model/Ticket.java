package gl.lab5.springproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
@Entity
public class Ticket {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "tkt_title")
	String ticketTitle;
	@Column(name = "tkt_short_desc")
	String ticketShortDesc;
	@Column(name = "tkt_created_on")
	String ticketCreatedOn;

}
