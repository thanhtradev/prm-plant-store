package com.prmplantstore.repositories;

import com.prmplantstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    Boolean existsByUsername (String username);
    Boolean existsByEmail (String email);
    Boolean existsByPhone (String phone);
    User findByUsername(String username);

}
