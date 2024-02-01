package dpd.parcel_delivery.controllers;

import dpd.parcel_delivery.entities.Customer;
import dpd.parcel_delivery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/customer")
public class CustomerController
{
	@Autowired
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/get_customers")
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	@GetMapping("/get_by_company/{company_id}")
	public List<Customer> getCustomersByCompanyId(@PathVariable Long company_id) {
		return customerService.findByCompanyId(company_id);
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@PostMapping("/add")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
		return customerService.update(id, customerDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
	}

}
