package dpd.parcel_delivery.repositories;

import dpd.parcel_delivery.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
	// Itt szükség szerinti egyedi lekérdezések
}
