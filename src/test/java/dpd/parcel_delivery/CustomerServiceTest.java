package dpd.parcel_delivery;

import dpd.parcel_delivery.entities.Customer;
import dpd.parcel_delivery.repositories.CustomerRepository;
import dpd.parcel_delivery.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	private Customer customer;

	@BeforeEach
	void setUp() {
		customer = new Customer();
		customer.setId(1L);
		customer.setFirstName("John");
		customer.setLastName("Doe");
		// További Customer beállítások
	}

	@Test
	void findAllCustomersTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);

		when(customerRepository.findAll()).thenReturn(customers);

		List<Customer> foundCustomers = customerService.findAll();

		assertNotNull(foundCustomers);
		assertFalse(foundCustomers.isEmpty());
		assertEquals(foundCustomers.size(), 1);
		assertEquals(foundCustomers.get(0).getFirstName(), "John");
	}

	@Test
	void findCustomerByIdTest() {
		when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

		Customer foundCustomer = customerService.findById(1L);

		assertNotNull(foundCustomer);
		assertEquals(foundCustomer.getFirstName(), "John");
	}

	// További tesztesetek, mint például save, update, delete
}
