package dpd.parcel_delivery.services;

import dpd.parcel_delivery.entities.Customer;
import dpd.parcel_delivery.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public List<Customer> findByCompanyId(Long companyId) {
		return customerRepository.findByCompanyId(companyId);
	}

	public Customer findById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer update(Long id, Customer customerDetails) {
		Customer customer = findById(id);
		// Itt frissítsd a customer adatait a customerDetails alapján
		return customerRepository.save(customer);
	}

	public void delete(Long id) {
		customerRepository.deleteById(id);
	}
}
