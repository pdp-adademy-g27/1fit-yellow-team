package com.example.onefit.facilities.entity;

import com.example.onefit.course.entity.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facilities {
    @Id
    private String name;
    private String image;

    @ManyToMany(mappedBy = "facilities" , fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Course> courses;
}
