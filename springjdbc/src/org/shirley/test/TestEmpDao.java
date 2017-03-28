package org.shirley.test;

import java.util.List;

import org.shirley.dao.EmpDao;
import org.shirley.entity.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDao {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		EmpDao empDao = ac.getBean("empDao",EmpDao.class);
	   /* Emp emp = new Emp();
		emp.setName("¹þ¹þ1");
		emp.setSalary(3200.0);
		emp.setAge(26);
		empDao.save(emp);*/
		//empDao.delete(4);
		/*List<Emp> list = empDao.findAll();
		for(Emp e:list){
			int id = e.getId();
			String name = e.getName();
			Double salary = e.getSalary();
			int age = e.getAge();
			System.out.println("id:"+id+",name:"+name+",salary:"+salary+",age:"+age);
		}*/
		Emp e = empDao.findById(1);
		int id = e.getId();
		String name = e.getName();
		Double salary = e.getSalary();
		int age = e.getAge();
		System.out.println("id:"+id+",name:"+name+",salary:"+salary+",age:"+age);
	}
}
