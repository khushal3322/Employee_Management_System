package com.jsp.ems.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.ems.controller.Controller;
import com.jsp.ems.model.Department;
import com.jsp.ems.model.Employee;
import com.jsp.ems.model.Project;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		Controller controller = new Controller();
		do {
			System.out.println("1. Emp \n2. dep \n3. project \n0.Exit\nEnter no.");
			int choose_Entity = myInput.nextInt();
			myInput.nextLine();
			switch (choose_Entity) {
			case 0:
				myInput.close();
				System.out.println("-------------------------EXIT----------------------------------");
				System.exit(0);
				break;
			
			case 1:

				System.out.println("1.add Emp \n2.view emp\n3.remove emp\n4.Update emp \n5.Featch all data");
				int choose_CURD_emp = myInput.nextInt();
				myInput.nextLine();
				if (choose_CURD_emp == 1) {
					Employee emp1 = new Employee();
					System.out.println("Enter Employee name");
					emp1.setName(myInput.nextLine());

					System.out.println("Enter postion");
					emp1.setPosition(myInput.nextLine());
					System.out.println("Enter salary");
					emp1.setSalary(myInput.nextDouble());
					// emp1.setDepartment(null);
					// emp1.setProject(null);
					boolean add_emp = controller.add_emp(emp1);
					// controller
					if (add_emp) {
						System.out.println("Added employee");
					} else {
						System.out.println("not added");
					}

				} else if (choose_CURD_emp == 2) {

					// controller
					System.out.println("Enter emp id to featch data");
					int emp_id = myInput.nextInt();
					Employee find_emp = controller.find_emp(emp_id);
					if (find_emp != null) {
						System.out.println(find_emp.getId());
						System.out.println(find_emp.getName());
						System.out.println(find_emp.getPosition());
						System.out.println(find_emp.getSalary());
						System.out.println(find_emp.getDOJ());
					} else {
						System.out.println("Id not found");
					}

				} else if (choose_CURD_emp == 3) {

					System.out.println("Enter Emp_id to remove Emp");
					int remove_id = myInput.nextInt();

					boolean remove_emp = controller.remove_emp(remove_id);
					if (remove_emp) {
						System.out.println("Remove Emp");
					} else {
						System.out.println("not remove");
					}

				} else if (choose_CURD_emp == 4) {
					System.out.println("update \n1.salary \n2.Position\n3.Depatment\n4.Project");

					int Update_emp = myInput.nextInt();
					myInput.nextLine();
					System.out.println("Enter id to update");
					int Update_id_emp = myInput.nextInt();
					switch (Update_emp) {
					case 1:
						System.out.println("Enter Update salary ");
						double new_salary = myInput.nextDouble();

						boolean update_sal = controller.update_sal(Update_id_emp, new_salary);
						if (update_sal) {
							System.out.println("salary update");
						} else {
							System.out.println("not update salary");
						}
						break;
					case 2:
						System.out.println("Enter Update position ");
						String new_position = myInput.nextLine();

						boolean update_position = controller.update_position(Update_id_emp, new_position);
						if (update_position) {
							System.out.println("position update");
						} else {
							System.out.println("not update position");
						}

						break;
					case 3:
						System.out.println("Department zal ny aahe aajun");
						
						
						
						List<Department> featch_dept = controller.featch_dept();
						for (Department featch_dept1 : featch_dept) {
							System.out.println("id :"+featch_dept1.getId());
							System.out.println("name :"+featch_dept1.getName());
							System.out.println();
							System.out.println("------------------------------");
						}
						
						System.out.println("Enter Which Dept id you add");
						
						int Which_dept = myInput.nextInt();
						Department find_Dept = controller.find_Dept(Which_dept);
						
						Employee find_emp = controller.find_emp(Update_id_emp);
						
						ArrayList<Employee> all_emp = new ArrayList();
						all_emp.add(find_emp);
						
						find_emp.setDepartment(find_Dept);
						find_Dept.setEmployee(all_emp);
						
						boolean update_dept_in_Emp = controller.update_dept_in_Emp(find_emp,find_Dept);
						if (update_dept_in_Emp) {
							System.out.println("set dept");
						} else {
							System.out.println("not set");
						}
						break;
					case 4:
						System.out.println("project zal ny aahe aajun");
						
						List<Project> featch_project = controller.featch_project();
						for (Project featch_project1 : featch_project) {
							System.out.println("id :"+featch_project1.getId());
							System.out.println("name :"+featch_project1.getName());
							System.out.println();
							System.out.println("------------------------------");
						}
						
						System.out.println("Enter Which Project id you add");
						
						int Which_Project = myInput.nextInt();
						 Project find_project = controller.find_project(Which_Project);
						
						Employee find_emp1 = controller.find_emp(Update_id_emp);
						
						ArrayList<Project> all_pro = new ArrayList();
						all_pro.add(find_project);
						
						ArrayList<Employee> all_emp1 = new ArrayList();
						all_emp1.add(find_emp1);
						
						find_emp1.setProject(all_pro);
						find_project.setEmployees(all_emp1);
						
						 boolean update_pro_in_Emp = controller.update_pro_in_Emp(find_emp1,find_project);
						if (update_pro_in_Emp) {
							System.out.println("set dept");
						} else {
							System.out.println("not set");
						}
						
						break;
					default:
						System.out.println("Wrong input for Update");
						break;
					}
				
				}else if(choose_CURD_emp==5) {
					
					List<Employee> featch = controller.featch();
					for (Employee employee1 : featch) {
						System.out.println("id :"+employee1.getId());
						System.out.println("name :"+employee1.getName());
						System.out.println();
						System.out.println("---------------------------");
					}
				}
				
				else {
					System.out.println("Wrong CURD no.");
				}

				break;
				

			case 2:
				System.out.println("1.add Dept \n2.view dept\n3.remove dept\n4.Update dept \n5.Featch all Dpet data");
				int choose_CURD_dept = myInput.nextInt();
				myInput.nextLine();
				if (choose_CURD_dept == 1) {
					Department dept1 = new Department();
					System.out.println("Enter Deptatment name");
					dept1.setName(myInput.nextLine());
					
					boolean add_dept = controller.add_dept(dept1);
					if (add_dept) {
						System.out.println("Depatment added");
					} else {
						System.out.println("dept not add");
					}

				} else if (choose_CURD_dept == 2) {
					System.out.println("Enter Dept id to featch data");
					int dept_id = myInput.nextInt();

					Department find_Dept = controller.find_Dept(dept_id);
					if (find_Dept != null) {
						System.out.println(find_Dept.getId());
						System.out.println(find_Dept.getName());
					} else {
						System.out.println("Dept id not found");
					}
				} else if (choose_CURD_dept == 3) {
					System.out.println("Enter Dept_id to remove Dept");
					int remove_id = myInput.nextInt();

					boolean remove_Dept = controller.remove_Dept(remove_id);
					if (remove_Dept) {
						System.out.println("dept removed ");
					} else {
						System.out.println("not remove");
					}
				} else if (choose_CURD_dept == 4) {
					System.out.println("update Aajun ny kel aahe");
					System.out.println("Enter id to update");
					int Update_id_emp = myInput.nextInt();
					
					
					
				} else if(choose_CURD_dept==5) {
					List<Department> featch_dept = controller.featch_dept();
					for (Department featch_dept1 : featch_dept) {
						System.out.println("id :"+featch_dept1.getId());
						System.out.println("name :"+featch_dept1.getName());
						System.out.println();
						System.out.println("------------------------------");
					}
				}
				else {
					System.out.println("worng input in Dept CURD");
				}
				break;

			case 3:
				System.out.println("1.add project \n2.view project\n3.remove project\n4.Update project");
				int choose_CURD_project = myInput.nextInt();
				myInput.nextLine();
				if (choose_CURD_project == 1) {
					Project project1 = new Project();
					System.out.println("Enter Project name");
					project1.setName(myInput.nextLine());
					System.out.println("Enter Project Description");
					project1.setDescription(myInput.nextLine());
					
					boolean add_project = controller.add_project(project1);
					if (add_project) {
						System.out.println("project added");
					} else {
						System.out.println("Project not add");
					}

				} else if (choose_CURD_project == 2) {
					System.out.println("Enter Project id to featch data");
					int project_id = myInput.nextInt();

					 Project find_project = controller.find_project(project_id);
					if (find_project != null) {
						System.out.println(find_project.getId());
						System.out.println(find_project.getName());
						System.out.println(find_project.getDescription());
					} else {
						System.out.println("Project id not found");
					}
				} else if (choose_CURD_project == 3) {
					System.out.println("Enter Project_id to remove Dept");
					int remove_id = myInput.nextInt();
					

				 boolean remove_Project = controller.remove_Project(remove_id);
					if (remove_Project) {
						System.out.println("Project removed ");
					} else {
						System.out.println("not remove");
					}
					
				} else if (choose_CURD_project == 4) {
					System.out.println("update Aajun ny kel aahe");
					
					
					
				}else if(choose_CURD_project==5) {
					List<Project> featch_project = controller.featch_project();
					for (Project featch_project1 : featch_project) {
						System.out.println("id :"+featch_project1.getId());
						System.out.println("name :"+featch_project1.getName());
						System.out.println();
						System.out.println("------------------------------");
					}
				}
				else {
					System.out.println("worng input in Dept CURD");
				}


				break;

			default:System.out.println("1,2,3 select kr na ky pn ky select kart aahes");
				break;
			}

		} while (true);

	}

}
