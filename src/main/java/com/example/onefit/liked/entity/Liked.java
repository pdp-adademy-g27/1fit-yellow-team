package com.example.onefit.liked.entity;

import com.example.onefit.course.entity.Course;
import com.example.onefit.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Liked {
    @Id
    private UUID id;

    @ManyToMany(mappedBy = "likeds")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Course> courses;

    @ManyToMany(mappedBy = "likeds")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<User> users;
}
