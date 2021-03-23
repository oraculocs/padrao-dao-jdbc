package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Department> list = new ArrayList<>();

		System.out.println("==== TEST 1: department findById ====");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department department = departmentDao.findById(3);
		
		System.out.println(department);
		
		System.out.println();
		System.out.println("==== TEST 2: department findAll ====");
		
		list = departmentDao.findAll();
		
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println();
		System.out.println("==== TEST 3: department insert ====");
		department = new Department(null, "Calçados");
		departmentDao.insert(department);
		System.out.println("Inserted! New Id = " + department.getId());
		
		System.out.println();
		System.out.println("==== TEST 5: department update ====");
		
		department = departmentDao.findById(6);
		department.setName("Finanças");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		
		System.out.println();
		System.out.println("==== TEST 4: department delete ====");
		
		System.out.print("Enter id for delete test:");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		
		System.out.println("Delete completed");
		
		
	}

}
