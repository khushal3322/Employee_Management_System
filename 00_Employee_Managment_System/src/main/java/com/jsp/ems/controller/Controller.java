package com.jsp.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.ems.model.Department;
import com.jsp.ems.model.Employee;
import com.jsp.ems.model.Project;

public class Controller {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgsql");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean add_emp(Employee emp1) {
		if (emp1 != null) {
			entityTransaction.begin();
			entityManager.persist(emp1);
			entityTransaction.commit();

			return true;
		}
		return false;

	}

	// find opration

	public Employee find_emp(int emp_id) {

		return entityManager.find(Employee.class, emp_id);
	}

//	featch all data emp

	public List<Employee> featch() {
		String jpql = "SELECT s FROM Employee s";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
		return query.getResultList();

	}
	
	//featch all data dept
	
	public List<Department> featch_dept() {
		String jpql = "SELECT s FROM Department s";
		TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
		return query.getResultList();

	}
	
	//featch all date project
	
	public List<Project> featch_project() {
		String jpql = "SELECT s FROM Project s";
		TypedQuery<Project> query = entityManager.createQuery(jpql, Project.class);
		return query.getResultList();

	}

	// remove opration

	public boolean remove_emp(int emp_id_remove) {

		if (emp_id_remove != 0) {

			Employee emp_remove = find_emp(emp_id_remove);
			
			Department department = emp_remove.getDepartment();
			List<Project> project = emp_remove.getProject();
			List<Employee> employee = department.getEmployee();
			

			entityTransaction.begin();
			
			project.remove(emp_remove);
			employee.remove(emp_remove);
			entityManager.remove(emp_remove);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

	// update opration
	
	public boolean update_dept_in_Emp(Employee emp,Department dept) {
		
		if (emp!=null && dept!=null) {
			entityTransaction.begin();
			
			entityManager.merge(emp);
			entityManager.merge(dept);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}
	
//	update opration project
	
public boolean update_pro_in_Emp(Employee emp,Project project) {
		
		if (emp!=null && project!=null) {
			entityTransaction.begin();
			
			entityManager.merge(emp);
			entityManager.merge(project);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}

	public boolean update_sal(int emp_id, double new_salary) {

		if (emp_id != 0) {
			Employee employee = find_emp(emp_id);

			employee.setSalary(new_salary);

			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

	public boolean update_position(int emp_id, String new_position) {

		if (emp_id != 0) {
			Employee employee = find_emp(emp_id);

			employee.setPosition(new_position);

			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

	// add depatment

	public boolean add_dept(Department dept) {
		if (dept != null) {
			entityTransaction.begin();
			entityManager.persist(dept);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

//	view depatment
	public Department find_Dept(int dept_id) {

		return entityManager.find(Department.class, dept_id);
	}

//	remove Deptatment
	public boolean remove_Dept(int Dept_id_remove) {

		if (Dept_id_remove != 0) {

			Department Dept_remove = find_Dept(Dept_id_remove);

			entityTransaction.begin();
			entityManager.remove(Dept_remove);
			entityTransaction.commit();

			return true;
		}
		return false;
	}
	
//	update project desc
	
	public void project_desc(int id_project,String update_desc) {
		
		if (id_project!=0 && update_desc!=null) {
			
		}
		
	}

//	add project

	public boolean add_project(Project pro) {
		if (pro != null) {
			entityTransaction.begin();
			entityManager.persist(pro);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

//	find project

	public Project find_project(int project_id) {

		return entityManager.find(Project.class, project_id);
	}

//	remove project
	public boolean remove_Project(int Project_id_remove) {

		if (Project_id_remove != 0) {

			Project find_project = find_project(Project_id_remove);

			entityTransaction.begin();
			entityManager.remove(find_project);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

}
