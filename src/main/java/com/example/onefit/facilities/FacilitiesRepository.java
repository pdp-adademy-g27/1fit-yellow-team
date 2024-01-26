package com.example.onefit.facilities;


import com.example.onefit.common.repository.GenericRepository;
import com.example.onefit.facilities.entity.Facilities;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilitiesRepository extends GenericRepository<Facilities , String> {
}
