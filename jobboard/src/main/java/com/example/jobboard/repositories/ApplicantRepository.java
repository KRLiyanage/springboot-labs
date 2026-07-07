package com.example.jobboard.repositories;

import com.example.jobboard.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    List<Applicant> findByCountry(String country);

    List<Applicant> findByStatus(String status);

    Optional<Applicant> findByEmail(String email);

    List<Applicant> findByYearsOfExperienceGreaterThanEqual(int years);

    List<Applicant> findByFullNameContaining(String keyword);


}
