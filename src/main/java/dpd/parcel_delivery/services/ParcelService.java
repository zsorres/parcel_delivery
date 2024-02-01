package dpd.parcel_delivery.services;

import dpd.parcel_delivery.entities.Parcel;
import dpd.parcel_delivery.repositories.ParcelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParcelService
{

	private final ParcelRepository parcelRepository;

	public ParcelService(ParcelRepository parcelRepository) {
		this.parcelRepository = parcelRepository;
	}

	public List<Parcel> findAll() {
		return parcelRepository.findAll();
	}

	public List<Parcel> findByCustomerId(Long customerId) {
		return parcelRepository.findByCustomerId(customerId);
	}

	public Parcel findById(Long id) {
		return parcelRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parcel not found"));
	}

	public Parcel save(Parcel parcel) {
		return parcelRepository.save(parcel);
	}

	public Parcel update(Long id, Parcel parcelDetails) {
		Parcel parcel = findById(id);
		return parcelRepository.save(parcel);
	}

	public void delete(Long id) {
		parcelRepository.deleteById(id);
	}
}
