package com.example.onefit.saved;

import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.saved.entity.Saved;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SavedRepository extends GenericRepository<Saved, UUID> {
}
