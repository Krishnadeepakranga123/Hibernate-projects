package org.mk.dep_bran.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.mk.dep_bran.dto.Employee;

public class FetchEmpByDeptId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the dept id to find Employee");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry1="select e from employee e where e.dept_id=?1";
		String qry2="select  d.emps from Department d where d.id=?1";
		Query q=manager.createQuery(qry2);
		q.setParameter(1, id);
		List<Employee> emps=q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println(e.getId());
				System.out.println(e.getName());
				System.out.println(e.getDesg());
				System.out.println(e.getSalary());
				System.out.println("--------------");
				
			}
		}
		else
		{
			System.err.println("You have Entered an Invalid Department id");
		}
		
		
		
	}

}
