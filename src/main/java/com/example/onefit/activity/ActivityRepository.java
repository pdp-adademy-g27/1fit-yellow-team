package com.example.onefit.activity;

import com.example.onefit.activity.entity.Activity;
import com.example.onefit.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface ActivityRepository extends GenericRepository<Activity, UUID> {


}
