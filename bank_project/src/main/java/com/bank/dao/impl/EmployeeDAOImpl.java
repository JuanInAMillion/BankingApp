package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bank.dao.EmployeeDAO;
import com.bank.dao.dbutil.PostgresSqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public Employee employeeVerifyLogin(String email, String password) throws BusinessException {
		Employee employee= null;
		
		try ( Connection connection = PostgresSqlConnection.getConnection() ) {
			String sql = "select * from bank.employee where email = ? and password = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);	
			ResultSet resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ) {
				employee = new Employee();
				employee.setEmployee_id(resultSet.getInt("employee_id"));
				employee.setFirst_name(resultSet.getString("first_name"));
				employee.setLast_name(resultSet.getString("last_name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPassword(resultSet.getString("password"));	
			}
			else
				throw new BusinessException("Log in Failed, enter a correct email and password");
				
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return employee;	
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByEmail(String email) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
