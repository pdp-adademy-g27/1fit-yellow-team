package com.example.onefit.liked;


import com.example.onefit.liked.entity.Liked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface LikedRepository extends JpaRepository<Liked, UUID> {

    Optional<Liked> findByCourse_IdAndAndUser_Id(UUID course_id , UUID User_id) ;
}
