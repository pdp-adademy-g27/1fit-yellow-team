package com.example.onefit.liked;

import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.liked.entity.Liked;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LikedRepository extends GenericRepository<Liked, UUID> {
}
