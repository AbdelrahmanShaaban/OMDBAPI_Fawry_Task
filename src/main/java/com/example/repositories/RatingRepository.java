package com.example.repositories;

import com.example.entities.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
}
