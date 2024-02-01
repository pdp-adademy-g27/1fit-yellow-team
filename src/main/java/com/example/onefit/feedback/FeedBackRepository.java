package com.example.onefit.feedback;

import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.feedback.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedBackRepository extends GenericRepository<Feedback, UUID> {
}
