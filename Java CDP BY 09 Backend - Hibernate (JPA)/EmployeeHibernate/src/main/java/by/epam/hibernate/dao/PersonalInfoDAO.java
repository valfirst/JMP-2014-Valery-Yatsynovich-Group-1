package by.epam.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import by.epam.hibernate.entity.PersonalInfo;

public class PersonalInfoDAO extends DAO{

	public PersonalInfo savePersonalInfo(PersonalInfo personalInfo) throws Exception {
		try {
			begin();
			getSession().save(personalInfo);
			commit();
			return personalInfo;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not create PersonalInfo", e);
	        }
	    }

	public PersonalInfo retrievePersonalInfo(long employeeId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from PersonalInfo where EMPLOYEE_ID = :employeeId");
			q.setParameter("employeeId", employeeId);
			PersonalInfo personalInfo = (PersonalInfo) q.uniqueResult();
			commit();
			return personalInfo;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get PersonalInfo for Employee ID " + employeeId, e);
		}
	}

	public void deletePersonalInfo(PersonalInfo personalInfo) throws Exception {
		try {
			begin();
			getSession().delete(personalInfo);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete PersonalInfo", e);
		}
	}

}
