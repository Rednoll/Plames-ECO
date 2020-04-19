package enterprises.inwaiders.plames.eco.domain.user.additionals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class EmailsStorage {

	@Column(name = "priority_email")
	private String priorityEmail = null;
	
	@Column(name = "emails")
	@ElementCollection
	private List<String> emails = new ArrayList<>();

	public void setPriorityEmail(String email) {
		
		this.priorityEmail = email;
	}
	
	public String getPriorityEmail() {
		
		return this.priorityEmail;
	}
	
	public List<String> getEmails() {

		return this.emails;
	}
}
