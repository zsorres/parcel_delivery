package dpd.parcel_delivery.controllers;

import dpd.parcel_delivery.entities.Address;
import dpd.parcel_delivery.entities.Parcel;
import dpd.parcel_delivery.services.AddressService;
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
@RequestMapping("/rest/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/get_addresses")
	public List<Address> getAllAddresses() {
		return addressService.findAll();
	}

	@GetMapping("/get_by_customer/{customer_id}")
	public List<Address>  getParcelsByCustomer(@PathVariable Long customer_id) {
		return addressService.findByCustomerId(customer_id);
	}

	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable Long id) {
		return addressService.findById(id);
	}

	@PostMapping("/add")
	public Address createAddress(@RequestBody Address address) {
		return addressService.save(address);
	}

	@PutMapping("/{id}")
	public Address updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
		return addressService.update(id, addressDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressService.delete(id);
	}
}
