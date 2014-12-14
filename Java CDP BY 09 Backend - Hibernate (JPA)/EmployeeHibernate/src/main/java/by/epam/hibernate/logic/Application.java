package by.epam.hibernate.logic;

import by.epam.hibernate.dao.ApplicationDAO;
import by.epam.hibernate.entity.Address;
import by.epam.hibernate.entity.Employee;
import by.epam.hibernate.entity.PersonalInfo;
import by.epam.hibernate.entity.Project;
import by.epam.hibernate.entity.Unit;

public class Application {
	
	private static ApplicationDAO dao = new ApplicationDAO();

	public static Employee createEmployee(Employee employee, Address address, PersonalInfo personalInfo) 
			throws Exception{
		employee.setAddress(address);
		employee.setPersonalInfo(personalInfo);
		personalInfo.setEmployee(employee);
		
		Unit defaultUnit = (Unit) dao.retrieve(Unit.class, 1);
		defaultUnit.getEmployees().add(employee);
		employee.setUnit(defaultUnit);
		
		dao.save(employee);
		
		return employee;
	}

	public static Unit createUnit(Unit unit) throws Exception{
		dao.save(unit);
		
		return unit;
	}
	
	public static Project createProject(Project project) throws Exception{
		dao.save(project);
		
		return project;
	}
	
	public static void updateEmployee(Employee employee) throws Exception {
		dao.save(employee);
	}
	
	public static void updateUnit(Unit unit) throws Exception {
		dao.save(unit);
	}
	
	public static void updateProject(Project project) throws Exception {
		dao.save(project);
	}
	
	public static void addEmployeeToProject(Employee employee, Project project) throws Exception {
		employee.getProjects().add(project);
		project.getEmployees().add(employee);
		
		dao.save(project);
	}
	
	public static void addEmployeeToUnit(Employee employee, Unit unit) throws Exception {
		employee.setUnit(unit);
		unit.getEmployees().add(employee);
		
		dao.save(unit);
	}
	
	public static void removeProject(Project project) throws Exception {
		dao.delete(project);
	}
	
	public static void removeUnit(Unit unit) throws Exception {
		dao.delete(unit);
	}
	
	public static void removeEmployee(Employee employee) throws Exception {
		dao.delete(employee);
	}
	
	public static Employee getEmployeeById(long id) throws Exception {
		return (Employee) dao.retrieve(Employee.class, id);
	}
	
	public static Unit getUnitById(long id) throws Exception {
		return (Unit) dao.retrieve(Unit.class, id);
	}
	
	public static Project getProjectById(long id) throws Exception {
		return (Project) dao.retrieve(Project.class, id);
	}
}
