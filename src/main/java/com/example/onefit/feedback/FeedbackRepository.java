package com.example.onefit.feedback;

import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.feedback.entity.Feedback;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedbackRepository extends GenericRepository<Feedback, UUID> {
}
