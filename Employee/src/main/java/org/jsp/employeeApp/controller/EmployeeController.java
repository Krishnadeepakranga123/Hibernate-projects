package org.jsp.employeeApp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.employeeApp.dao.EmployeeDao;
import org.jsp.employeeApp.dto.employee;

public class EmployeeController {
static Scanner sc=new Scanner(System.in);
static EmployeeDao dao=new EmployeeDao();
public static void main(String[] args) {
	System.out.println("1.save Employee");
	System.out.println("2.upadte Employee");
	System.out.println("3.Find Employee By Id");
	System.out.println("4.verify by phone and password");
	System.out.println("5.verify by id and password");
	System.out.println("6.Delete Employee By ID");
	System.out.println("7.Find Employee By Designation");
	
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
	{
		save();
		break;
	}
	case 2:
	{
		update();
		break;
	}
	case 3:
	{
		verifyByPhone();
		break;
	}
	case 4:
	{
		findById();
		break;
	}
	case 5:
	{
		verifyById();
		break;
	}
	case 6:{
		delete();
		break;
	}
	case 7:
	{
		findByDesg();
		break;
	}
	default:{
		System.out.println("Invalid choice That you have Entered "+choice);
	}
	}
	
}
public static void save() {
	System.out.println("enter the employee name,desg,salary,phone,email and password");
	employee e=new employee();
	e.setName(sc.next());
	e.setDesg(sc.next());
	e.setSalary(sc.nextDouble());
	e.setPhone(sc.nextLong());
	e.setEmail(sc.next());
	e.setPassword(sc.next());
	e=dao.saveEmployee(e);
	System.out.println("Employee Saved with id: "+e.getId());
	
}
public static void update() {
	System.out.println("Enter your id to update");
	int id=sc.nextInt();
	System.out.println("enter the employee name,desg,salary,phone,email and password");
	employee e=new employee();
	e.setId(id);
	e.setName(sc.next());
	e.setDesg(sc.next());
	e.setSalary(sc.nextDouble());
	e.setPhone(sc.nextLong());
	e.setEmail(sc.next());
	e.setPassword(sc.next());
	e=dao.updateEmployee(e);
	System.out.println("Employee Updated with id: "+e.getId());
}
public static void verifyByPhone() {
	System.out.println("Enter your phone and password to verify:");
	long phone=sc.nextLong();
	String password=sc.next();
	employee e=dao.verifyEmployee(phone, password);
	if(e!=null) {
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getDesg());
		System.out.println(e.getSalary());
		System.out.println(e.getEmail());
		System.out.println(e.getPhone());
	}
	else {
		System.out.println("Invalid phone or password");
	}
	
}
public static void findById() {
	System.out.println("Enter the employee id to display details");
	int id=sc.nextInt();
	employee e=dao.findById(id);
	if(e!=null) {
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getEmail());
		System.out.println(e.getPhone());
		System.out.println(e.getDesg());
		System.out.println(e.getSalary());
	}
	else {
		System.out.println("You entered an Invalid ID");
	}
	
}
public static void verifyById() {
	System.out.println("Enter your id and password:");
	int id=sc.nextInt();
	String password=sc.next();
	employee e=dao.verifyEmployee(id, password);
	if(e!=null) {
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getDesg());
		System.out.println(e.getEmail());
		System.out.println(e.getPhone());
		System.out.println(e.getSalary());
	}
	else {
		System.out.println("Inavalid id or password");
	}

}
public static void delete() {
	System.out.println("Enter id to delete");
	int id=sc.nextInt();
	boolean deleted=dao.deleteEmployee(id);
	if(deleted) {
		System.out.println("Employee deleted");
	}
	else {
		System.out.println("you enter an invalid id");
	}
}
public static void findByDesg() {
	System.out.println("Enter the Employee Designation to display details");
	String desg=sc.next();
	List<employee> emps=dao.findEmployeeByDesg(desg);
	if(emps.size()>0) {
		for(employee e:emps) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getEmail());
			System.out.println(e.getPhone());
			System.out.println(e.getDesg());
			System.out.println(e.getSalary());
		}
	}
	else {
			System.out.println("no employee found with enterd designation");
		}
	
}
}
