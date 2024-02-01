package dpd.parcel_delivery.repositories;

import dpd.parcel_delivery.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>
{
	List<Address> findByCustomerId(Long customerId);
}
