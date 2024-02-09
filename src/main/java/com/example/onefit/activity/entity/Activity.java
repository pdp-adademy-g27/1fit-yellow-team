package com.example.onefit.activity.entity;

import com.example.onefit.course.entity.Course;
import com.example.onefit.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Activity {
        @Id
        private UUID id;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime startTime;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime endTime;

        @ManyToMany(mappedBy = "activities")
        @EqualsAndHashCode.Exclude
        @ToString.Exclude
        private Set<Course> courses;

        @ManyToMany(mappedBy = "activities")
        @EqualsAndHashCode.Exclude
        @ToString.Exclude
        private Set<User> users;

}
