package dpd.parcel_delivery.repositories;

import dpd.parcel_delivery.entities.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelRepository extends JpaRepository<Parcel, Long>
{
	List<Parcel> findByCustomerId(Long customerId);
}
