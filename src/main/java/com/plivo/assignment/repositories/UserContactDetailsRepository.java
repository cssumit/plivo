package com.plivo.assignment.repositories;


import com.plivo.assignment.models.UserContactDetails;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactDetailsRepository extends JpaRepository<UserContactDetails,Long> {
    UserContactDetails findByEmail(String email);

    Page<UserContactDetails> findByName(String name, Pageable pageable);
}
