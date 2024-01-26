package com.example.onefit.activity;


import com.example.onefit.activity.entity.Activity;
import com.example.onefit.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActivityRepository extends GenericRepository<Activity , UUID> {
}
