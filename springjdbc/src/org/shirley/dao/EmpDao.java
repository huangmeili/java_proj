package org.shirley.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.shirley.entity.Emp;
import org.shirley.entity.EmpRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDao {
	@Resource
	private JdbcTemplate template;
	
	public void save(Emp emp){
		String sql ="insert into emp (name,salary,age) values(?,?,?)";
		Object[] params = {
				emp.getName(),
				emp.getSalary(),
				emp.getAge()};
		template.update(sql, params);
	}
	public void delete(int id){
		String sql ="delete from emp where id =?";
		Object[] params={id};
		template.update(sql,params);
	}
	
	public List<Emp> findAll(){
		String sql ="select * from emp";
		EmpRowMapper rowMapper = new EmpRowMapper();
		List<Emp> list = template.query(sql,rowMapper);
		return list;
	}
	//���в�ѯ��query() ����
	//���в�ѯ��queryForObject() ����
	public Emp findById(int id){
		String sql="select * from emp where id = ?";
		Object[] params ={id};
		EmpRowMapper rowMapper = new EmpRowMapper();
		Emp emp = template.queryForObject(sql, params, rowMapper);
		return emp;
	}
}
