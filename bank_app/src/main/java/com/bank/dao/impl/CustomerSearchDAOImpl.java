package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.CustomerSearchDAO;
import com.bank.dao.dbutil.PostgresSqlConnection;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public class CustomerSearchDAOImpl implements CustomerSearchDAO{

	@Override
	public Customer getCustomerById(int customer_id) throws BusinessException {
		Customer customer = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "select first_name, last_name, dob, gender, ssn, address, phone, email from bank.customer where customer_id=? ";
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
				customer.setSsn(resultSet.getLong("ssn"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getLong("phone"));
				customer.setEmail(resultSet.getString("email"));
			} else {
				throw new BusinessException("No Customer Found wit id " + customer_id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take this line off when app is live
			throw new BusinessException("Internal error occured contact SYSADMIN");
		}
		return customer;
	}

	
}
