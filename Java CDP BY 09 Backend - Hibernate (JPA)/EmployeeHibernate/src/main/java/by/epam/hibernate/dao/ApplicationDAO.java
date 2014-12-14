package by.epam.hibernate.dao;

import org.hibernate.HibernateException;

public class ApplicationDAO<T> extends DAO{

	public T save(T t) throws Exception {
		try {
			begin();
			getSession().saveOrUpdate(t);
			commit();
			return t;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not save", e);
		}
	}

	public Object retrieve(Class clazz, long id) throws Exception {
		try {
			begin();
			Object employee = (Object) getSession().get(clazz, id);
			commit();
			return employee;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get employee ", e);
		}
	}

	public void delete(T t) throws Exception {
		try {
			begin();
			getSession().delete(t);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete employee ", e);
		}
	}
}
