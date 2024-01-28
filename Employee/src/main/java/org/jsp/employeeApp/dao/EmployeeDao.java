package org.jsp.employeeApp.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsp.employeeApp.dto.employee;

public class EmployeeDao {
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	
	public employee saveEmployee(employee emp) {
		s.save(emp);
		Transaction t=s.beginTransaction();
		t.commit();
		return emp;
	}
	
	public employee updateEmployee(employee emp) {
		s.update(emp);
		Transaction t=s.beginTransaction();
		t.commit();
		return emp;
		
	}
	
	public employee findById(int id) {
		return s.get(employee.class, id);
	}
	
	public employee verifyEmployee(long phone, String password) {
		String hql="select e from employee e where e.phone=?1 and e.password=?2";
		Query<employee> q=s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public employee verifyEmployee(int id,String password) {
		String hql="select e from employee e where e.id=?1,e.password=?2";
		Query<employee> query=s.createQuery(hql);
		query.setParameter(1, id);
		query.setParameter(2, password);
		try {
			return query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public boolean deleteEmployee(int id) {
		employee e=findById(id);
		if(e!=null) {
			Transaction t=s.beginTransaction();
			s.delete(e);
			t.commit();
			return true;
		}
		return false;
	}
	
	public List<employee> findEmployeeByDesg(String desg){
		String qry="select e. from employee e where e.desg=?1";
		Query<employee> q=s.createQuery(qry);
		q.setParameter(1, desg);
		return q.getResultList();
	}
	
}
