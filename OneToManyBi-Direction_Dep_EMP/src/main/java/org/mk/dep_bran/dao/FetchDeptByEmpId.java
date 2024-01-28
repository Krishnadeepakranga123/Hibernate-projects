package org.mk.dep_bran.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.mk.dep_bran.dto.Department;

public class FetchDeptByEmpId {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter employee id to print department details");
		int eid=s.nextInt();
		String qry="select e from employee e where e.dept.id=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, eid);
		try {
			Department d=(Department)q.getSingleResult();
			System.out.println(d.getId());
			System.out.println(d.getName());
			System.out.println(d.getLocation());
		}
		catch (NoResultException e) {
			System.err.println("Invalid Employee id");
			
		}
	}

}
