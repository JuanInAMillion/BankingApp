package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		List<Customer> customerList=new ArrayList<>();
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "select * from bank.customer";
			PreparedStatement preparedStatement=connection.prepareStatement(sql); 
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getLong("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			} 
			if(customerList.size() == 0)
			{
				throw new BusinessException("No Customer in Chase bank DB so far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact SYSADMIN ");
		}		
		return customerList  ;
	}

	@Override
	public Customer getCustomerByEmail(String email) throws BusinessException {
		Customer customer = null;	
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "select * from bank.customer where email =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,email);			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer(); 
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setGender(resultSet.getString("gender"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getLong("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				
			}else {
				throw new BusinessException("No customer found with email: "+ email);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customer;
	}
	
}
