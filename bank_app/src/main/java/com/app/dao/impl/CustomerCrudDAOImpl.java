package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bank.Customer;
import com.app.dao.CustomerCrudDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.BusinessException;

public class CustomerCrudDAOImpl implements CustomerCrudDAO{

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql="insert into bank.customer(customer_id, first_name, last_name, dob, gender, ssn, state_id, street, apt, city, state, zip, email, phone) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);			
			preparedStatement.setInt(1, customer.getCustomer_id());
			preparedStatement.setString(2, customer.getFirst_name());
			preparedStatement.setString(3, customer.getLast_name());
			preparedStatement.setString(4, customer.getDob());
			preparedStatement.setString(5, customer.getGender());
			preparedStatement.setString(6, customer.getSsn());
			preparedStatement.setString(7, customer.getState_id());
			preparedStatement.setString(8, customer.getStreet());	
			preparedStatement.setString(9, customer.getApt());	
			preparedStatement.setString(10, customer.getCity());	
			preparedStatement.setString(11, customer.getState());
			preparedStatement.setString(12, customer.getZip());	
			preparedStatement.setString(13, customer.getEmail());
			preparedStatement.setString(14, customer.getPhone());	
			c=preparedStatement.executeUpdate();		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take this line off when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return c;
	}

	@Override
	public Customer getCustomerById(int customer_id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "select first_name, last_name, dob, gender, ssn, state_id, street, apt, city, state, zip, email, phone from bank.customer where customer_id=? ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer();
				customer.setCustomer_id(customer_id);
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setDob(resultSet.getString("dob"));
				customer.setGender(resultSet.getString("gender"));
				customer.setSsn(resultSet.getString("ssn"));
				customer.setState_id(resultSet.getString("state_id"));
				customer.setStreet(resultSet.getString("street"));
				customer.setApt(resultSet.getString("apt"));
				customer.setCity(resultSet.getString("city"));
				customer.setState(resultSet.getString("state"));
				customer.setZip(resultSet.getString("zip"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhone(resultSet.getString("phone"));
			} else {
				throw new BusinessException("No Customer Found wit id " + customer_id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take this line off when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customerList = new ArrayList();
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "select customer_id, first_name, last_name, dob, gender, ssn, state_id, street, apt, city, state, zip, email, phone from bank.customer";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("first_name"));
				customer.setLast_name(resultSet.getString("last_name"));
				customer.setDob(resultSet.getString("dob"));
				customer.setGender(resultSet.getString("gender"));
				customer.setSsn(resultSet.getString("ssn"));
				customer.setState_id(resultSet.getString("state_id"));
				customer.setStreet(resultSet.getString("street"));
				customer.setApt(resultSet.getString("apt"));
				customer.setCity(resultSet.getString("city"));
				customer.setState(resultSet.getString("state"));
				customer.setZip(resultSet.getString("zip"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPhone(resultSet.getString("phone"));
				customerList.add(customer);
			} if(customerList.size()==0) {
				throw new BusinessException("No Customer in DB so far");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take this line off when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return customerList;
	}

}
