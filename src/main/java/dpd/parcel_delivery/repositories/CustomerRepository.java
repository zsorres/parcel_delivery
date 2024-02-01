package dpd.parcel_delivery.repositories;

import dpd.parcel_delivery.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	List<Customer> findByCompanyId(Long companyId);
}
