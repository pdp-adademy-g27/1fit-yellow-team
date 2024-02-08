package com.example.onefit.category.entity;

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
public class Category {
    @Id
    private String name;
    private String smallImage;
    private String bigImage;

    @ManyToMany(mappedBy = "categories" )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Course> courses;
}