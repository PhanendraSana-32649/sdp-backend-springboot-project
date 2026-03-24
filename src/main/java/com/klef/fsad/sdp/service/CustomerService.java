package com.klef.fsad.sdp.service;

import com.klef.fsad.sdp.entity.Customer;

public interface CustomerService {
	public String customerRegistrationString(Customer customer);
	public Customer verifyCustomerLogin(String email, String pwd);
	public String updateCustomerProfile(Customer customer);
	
	
	

}
