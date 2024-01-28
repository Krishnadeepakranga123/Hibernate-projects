package org.mk.dep_bran.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.mk.dep_bran.dto.Department;
import org.mk.dep_bran.dto.Employee;

public class FetchEmployeeByDeptID {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the department id to find Employees");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Department d=manager.find(Department.class, id);
	if(d!=null){
		List<Employee> emps=d.getEmps();
		for(Employee e:emps) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getSalary());
			System.out.println(e.getDesg());
			System.out.println("---------------");
			
		}
	}
	else
	{
		System.err.println("Invalid id");
	}
}
}
