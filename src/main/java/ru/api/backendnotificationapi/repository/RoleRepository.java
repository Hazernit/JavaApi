package ru.api.backendnotificationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.api.backendnotificationapi.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
