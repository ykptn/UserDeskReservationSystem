package com.eyl.backend.controller;

import com.eyl.backend.dto.CompanyDTO;
import com.eyl.backend.service.serviceImplementations.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO createdCompany = companyService.createCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long companyId) {
        CompanyDTO companyDTO = companyService.getCompanyById(companyId);
        return ResponseEntity.ok(companyDTO);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long companyId, @RequestBody CompanyDTO updatedCompany) {
        CompanyDTO companyDTO = companyService.updateCompany(companyId, updatedCompany);
        return ResponseEntity.ok(companyDTO);
    }
}
