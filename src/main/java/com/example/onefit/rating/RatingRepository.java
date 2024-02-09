package com.example.onefit.rating;

import com.example.onefit.rating.entity.Rating;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID> {


    Optional<Rating> findByCourse_IdAndAndUser_Id(UUID course_id , UUID user_id) ;


}
