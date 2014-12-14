package by.epam.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "CITY")
	private String city;
	
	@Column(name = "OFFICE")
	private String office;
	
	public Address(){}
	
	public Address(String city, String office){
		this.city = city;
		this.office = office;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}
	
	public String getOffice() {
		return office;
	}

}
