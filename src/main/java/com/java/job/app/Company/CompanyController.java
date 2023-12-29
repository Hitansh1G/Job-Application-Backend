package com.java.job.app.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company>getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>updateCompany(@PathVariable Long id,
                                               @RequestBody Company company){
        if(companyService.updateCompany(company,id))
            return new ResponseEntity<>("Company has been updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("updation failed",HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String>addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("company added successfully",HttpStatus.CREATED);
    }
}
