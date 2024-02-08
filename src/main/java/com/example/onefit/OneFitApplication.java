package com.example.onefit;

import com.example.onefit.course.CourseRepository;
import com.example.onefit.course.entity.Course;
import com.example.onefit.location.LocationRepository;
import com.example.onefit.location.entity.Location;
import com.example.onefit.subscription.SubscriptionRepository;
import com.example.onefit.user.UserRepository;
import com.example.onefit.user.entity.User;
import com.example.onefit.user.permission.PermissionRepository;
import com.example.onefit.user.permission.entity.Permission;
import com.example.onefit.user.role.RoleRepository;
import com.example.onefit.user.role.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@RequiredArgsConstructor
public class OneFitApplication implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final LocationRepository locationRepository;
    private final SubscriptionRepository subscriptionRepository;

    public static void main(String[] args) {
        SpringApplication.run(OneFitApplication.class, args);
    }

    @Override
    public void run(String... args) {
        createPermissions();
        createAdmin();
        createLocation();
       createCourses();
        createSubscription();
    }

    private void createSubscription() {
        subscriptionRepository.deleteAll();
    }

    private void createAdmin() {
        String phoneNumber = "1";
        String email = "yellowteam@gmail.com";

        Set<Permission> adminPermissions = new HashSet<>(permissionRepository.findAll());
        Set<Permission> userPermissions = permissionRepository
                .findAllByNameIn(Set.of("activity:read", "category:read", "course:read", "facilities:read", "liked:read", "location:read", "rating:read", "saved:read"));
        Set<Permission> staffPermissions = permissionRepository
                .findAllByNameIn(Set.of("course:create", "course:read", "course:delete", "feedback:read", "subscription:create", "subscription:read", "subscription:update", "subscription:delete"));

        Role existAdmin = roleRepository.findByName("ADMIN").orElse(null);
        Role existUser = roleRepository.findByName("USER").orElse(null);
        Role existStaff = roleRepository.findByName("STAFF").orElse(null);

        if (existAdmin == null) {
            Role admin = new Role(UUID.randomUUID(), "ADMIN", adminPermissions, null);
            roleRepository.save(admin);
        }
        if (existUser == null) {
            Role user = new Role(UUID.randomUUID(), "USER", userPermissions, null);
            roleRepository.save(user);
        }
        if (existStaff == null) {
            Role staff = new Role(UUID.randomUUID(), "STAFF", staffPermissions, null);
            roleRepository.save(staff);
        }

        if (!userRepository.existsByPhoneNumberOrEmail(phoneNumber, email)) {
            Role role = roleRepository.findByName("ADMIN").orElseThrow();
            User user = new User(UUID.randomUUID(), "Admin",
                    phoneNumber, email, passwordEncoder.encode("1"),
                    LocalDate.now(), Set.of(role), new HashSet<>(permissionRepository.findAll()),
                    Collections.emptySet(), Collections.emptySet(), Collections.emptySet(),
                    Collections.emptySet(), null, null);

            userRepository.save(user);
        }
    }

    private void createPermissions() {
        permissionRepository.deleteAll();
        Set<Permission> permissions = new HashSet<>();

        // Activity table permissions
        permissions.add(new Permission(UUID.randomUUID(), "activity:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "activity:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "activity:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "activity:delete", null, null));

        // Category table permissions
        permissions.add(new Permission(UUID.randomUUID(), "category:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "category:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "category:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "category:delete", null, null));

        // Course table permissions
        permissions.add(new Permission(UUID.randomUUID(), "course:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "course:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "course:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "course:delete", null, null));

        // Facilities table permissions
        permissions.add(new Permission(UUID.randomUUID(), "facilities:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "facilities:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "facilities:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "facilities:delete", null, null));

        // Feedback table permissions
        permissions.add(new Permission(UUID.randomUUID(), "feedback:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "feedback:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "feedback:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "feedback:delete", null, null));

        // Liked table permissions
        permissions.add(new Permission(UUID.randomUUID(), "liked:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "liked:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "liked:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "liked:delete", null, null));

        // Location table permissions
        permissions.add(new Permission(UUID.randomUUID(), "location:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "location:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "location:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "location:delete", null, null));

        // Rating table permissions
        permissions.add(new Permission(UUID.randomUUID(), "rating:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "rating:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "rating:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "rating:delete", null, null));

        // Saved table permissions
        permissions.add(new Permission(UUID.randomUUID(), "saved:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "saved:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "saved:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "saved:delete", null, null));

        // Subscription table permissions
        permissions.add(new Permission(UUID.randomUUID(), "subscription:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "subscription:read", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "subscription:update", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "subscription:delete", null, null));

        // Role table permissions
        permissions.add(new Permission(UUID.randomUUID(), "role:create", null, null));
        permissions.add(new Permission(UUID.randomUUID(), "role:read", null, null));

        permissionRepository.saveAll(permissions);
    }


    private void createLocation(){

        locationRepository.deleteAll();
        Location location1 = new Location(UUID.randomUUID() , "Tashkent" , "123" , "123" ) ;
        Location location2 = new Location(UUID.randomUUID() , "Tashkent1" , "1233" , "1233") ;


        locationRepository.save(location1);
        locationRepository.save(location2);
    }

    private void createCourses(){
      courseRepository.deleteAll();

      List<Location> locations = locationRepository.findAll();

        List<Course> courses = new ArrayList<>();

        courses.add(new Course(UUID.randomUUID() , "Swim" , "The best course" , locations.get(0) , false , List.of("1231231") , Collections.emptySet() ,
                Collections.emptySet() , Collections.emptySet() , Collections.emptySet()  , Collections.emptySet() , Collections.emptySet(), LocalDateTime.now() , LocalDateTime.now()));

        courses.add(new Course( UUID.randomUUID(), "Football" , "The best course" , locations.get(1) , true , List.of("1231478"),
                Collections.emptySet() , Collections.emptySet() , Collections.emptySet() , Collections.emptySet() ,  Collections.emptySet()  , Collections.emptySet(), LocalDateTime.now() , LocalDateTime.now()));


        courseRepository.saveAll(courses);
    }

}
