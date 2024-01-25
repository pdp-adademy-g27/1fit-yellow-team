package com.example.onefit.location.entity;

import com.example.onefit.course.entity.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {
    @Id
    private UUID id;
    private String name;
    private String latitude;
    private String longitude;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Course course;
}
