package com.fges.commandes.commandes.customer;

public interface ICustomer {

    Customer findCustomerById(Long id) throws CustomerNotFoundException;
}
