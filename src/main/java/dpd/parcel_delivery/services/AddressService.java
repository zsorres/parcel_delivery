package dpd.parcel_delivery.services;

import dpd.parcel_delivery.entities.Address;
import dpd.parcel_delivery.entities.Parcel;
import dpd.parcel_delivery.repositories.AddressRepository;
import dpd.parcel_delivery.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService
{

	private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public List<Address> findByCustomerId(Long customerId) {
		return addressRepository.findByCustomerId(customerId);
	}

	public Address findById(Long id) {
		return addressRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Address not found"));
	}

	public Address save(Address address) {
		return addressRepository.save(address);
	}

	public Address update(Long id, Address addressDetails) {
		Address address = findById(id);
		// Itt frissítsd az address adatait az addressDetails alapján
		return addressRepository.save(address);
	}

	public void delete(Long id) {
		addressRepository.deleteById(id);
	}

}
