package dpd.parcel_delivery.services;

import dpd.parcel_delivery.entities.Company;
import dpd.parcel_delivery.repositories.CompanyRepository;
import dpd.parcel_delivery.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService
{

	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company findById(Long id) {
		return companyRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Company not found"));
	}

	public Company save(Company company) {
		return companyRepository.save(company);
	}

	public Company update(Long id, Company companyDetails) {
		Company company = findById(id);
		// Itt frissítsd a company adatait a companyDetails alapján
		return companyRepository.save(company);
	}

	public void delete(Long id) {
		companyRepository.deleteById(id);
	}

}
