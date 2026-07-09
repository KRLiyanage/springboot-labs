package com.example.jobboard.service;

import com.example.jobboard.entity.Applicant;
import com.example.jobboard.exception.ApplicantNotFoundException;
import com.example.jobboard.exception.DuplicateEmailException;
import com.example.jobboard.repositories.ApplicantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;


    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<Applicant> findAll(){
        return applicantRepository.findAll();
    }

    public Applicant getById(Long id){
        return applicantRepository.findById(id).orElseThrow(ApplicantNotFoundException::new);
    }

    public Applicant register(Applicant applicant) {

        if (applicantRepository.findByEmail(applicant.getEmail()).isPresent()) {
            throw new DuplicateEmailException();
        }

        return applicantRepository.save(applicant);
    }

    @Transactional
    public void deleteById(Long id) {

        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(ApplicantNotFoundException::new);

        applicantRepository.delete(applicant);
    }

    public List<Applicant> findByCountry(String country) {
        return applicantRepository.findByCountry(country);
    }

    public List<Applicant> findByStatus(String status) {
        return applicantRepository.findByStatus(status);
    }

    public List<Applicant> findByExperience(int years) {
        return applicantRepository.findByYearsOfExperienceGreaterThanEqual(years);
    }

    public List<Applicant> findByName(String keyword) {
        return applicantRepository.findByFullNameContaining(keyword);
    }


}
