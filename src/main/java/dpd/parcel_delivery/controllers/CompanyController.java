package dpd.parcel_delivery.controllers;

import dpd.parcel_delivery.entities.Company;
import dpd.parcel_delivery.services.CompanyService;
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
@RequestMapping("/rest/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/get_companies")
	public List<Company> getAllCompanies() {
		return companyService.findAll();
	}

	@GetMapping("/{id}")
	public Company getCompanyById(@PathVariable Long id) {
		return companyService.findById(id);
	}

	@PostMapping("/add")
	public Company createCompany(@RequestBody Company company) {
		return companyService.save(company);
	}

	@PutMapping("/{id}")
	public Company updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
		return companyService.update(id, companyDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable Long id) {
		companyService.delete(id);
	}
}
