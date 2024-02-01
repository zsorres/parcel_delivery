package dpd.parcel_delivery.controllers;

import dpd.parcel_delivery.entities.Parcel;
import dpd.parcel_delivery.services.ParcelService;
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
@RequestMapping("/rest/parcel")
public class ParcelController {

	@Autowired
	private ParcelService parcelService;

	@GetMapping("/getParcels")
	public List<Parcel> getAllParcels() {
		return parcelService.findAll();
	}

	@GetMapping("/get_by_customer/{customer_id}")
	public List<Parcel> getParcelsByCustomer(@PathVariable Long customer_id) {
		return parcelService.findByCustomerId(customer_id);
	}

	@GetMapping("/{id}")
	public Parcel getParcelById(@PathVariable Long id) {
		return parcelService.findById(id);
	}

	@PostMapping("/add")
	public Parcel createParcel(@RequestBody Parcel parcel) {
		return parcelService.save(parcel);
	}

	@PutMapping("/{id}")
	public Parcel updateParcel(@PathVariable Long id, @RequestBody Parcel parcelDetails) {
		return parcelService.update(id, parcelDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteParcel(@PathVariable Long id) {
		parcelService.delete(id);
	}
}
