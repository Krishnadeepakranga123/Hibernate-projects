package org.mk.dep_bran.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.mk.dep_bran.dto.Department;
import org.mk.dep_bran.dto.Employee;

public class SaveDeptAndEmp {
	public static void main(String[] args) {
		Department d=new Department();
		d.setLocation("Banglore");
		d.setName("developer");
		
		Employee e1=new Employee();
		e1.setName("krish");
		e1.setSalary(98765);
		e1.setDesg("developer");
		e1.setDept(d);
		
		Employee e2=new Employee();
		e2.setName("deepak");
		e2.setSalary(765467);
		e2.setDesg("java-dev");
		e2.setDept(d);
		
//		List<Employee> employees=new ArrayList<Employee>();
//		employees.add(e1);
//		employees.add(e2);
		
		d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2)));
		
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		
	}

}
