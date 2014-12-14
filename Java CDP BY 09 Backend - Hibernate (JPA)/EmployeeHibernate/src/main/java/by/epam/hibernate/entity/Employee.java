package by.epam.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "EMPLOYEE_STATUS")
	private EmployeeStatus employeeStatus;

	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private PersonalInfo personalInfo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "employee_project", 
			joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "PROJECT_ID")})
	private Set<Project> projects = new HashSet<Project>();;
	
	@ManyToOne
	@JoinColumn(name="UNIT_ID", referencedColumnName = "UNIT_ID")
	private Unit unit;
	
	
	
	public Employee() {
	}
	
	public Employee(String name, EmployeeStatus employeeStatus){
		this.name = name;
		this.employeeStatus = employeeStatus;
	}
	
	public long getId() {
        return id;
    }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}
	
	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public Set<Project> getProjects() {
		return projects;
	}
}
