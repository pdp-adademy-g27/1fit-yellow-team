package com.example.onefit.course.entity;

import com.example.onefit.activity.entity.Activity;
import com.example.onefit.category.entity.Category;
import com.example.onefit.facilities.entity.Facilities;
import com.example.onefit.liked.entity.Liked;
import com.example.onefit.location.entity.Location;
import com.example.onefit.rating.entity.Rating;
import com.example.onefit.saved.entity.Saved;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    private UUID id;
    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    private boolean isFemale;

    @ElementCollection
    @CollectionTable(name = "course_images", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "image")
    private List<String> images;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_facilities",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "facilities_id" )
    )
    private Set<Facilities> facilities;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_category",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany
    private Set<Rating> ratings;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_activity",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> activities;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_liked",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Liked> likeds;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_saved",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Saved> saveds;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;
}
