package lesson7.finished.viewmodels;

import lesson7.finished.services.CustomerDaoService;
import lesson7.finished.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {
  static List<Customer> customerList = new ArrayList<>();

  public static void main(String[] args) {

    BusinessLogic mysteryBusiness = new BusinessLogic();
    // Do a bunch of business things for your business
    mysteryBusiness.addCustomer(new Customer(1001, "Keir", "Whitehouse", "k.whitehouse@mysterybusiness.com", "555-555-5000"));
    mysteryBusiness.addCustomer(new Customer(1002, "Anna", "Jenkins", "a.jenkins@mysterybusiness.com", "555-555-5001"));
    mysteryBusiness.addCustomer(new Customer(1003, "Evan", "Huang", "e.huang@mysterybusiness.com", "555-555-5002"));
    mysteryBusiness.addCustomer(new Customer(1004, "Yasser", "Salter", "y.salter@mysterybusiness.com", "555-555-5003"));
    mysteryBusiness.addCustomer(new Customer(1005, "Dawson", "Rangel", "d.rangel@mysterybusiness.com", "555-555-5004"));
    CustomerDaoService.resetDatabase();
    CustomerDaoService.createTable();

    // Add a call to .saveCustomers() here:
    CustomerDaoService.saveCustomers(customerList);

  }

  public void addCustomer(Customer customer) {
    customerList.add(customer);
  }
}
