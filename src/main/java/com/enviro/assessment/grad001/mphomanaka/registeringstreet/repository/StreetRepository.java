package com.enviro.assessment.grad001.mphomanaka.registeringstreet.repository;

import com.enviro.assessment.grad001.mphomanaka.registeringstreet.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface StreetRepository extends JpaRepository<Street, Long> {
}
