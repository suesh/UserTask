package com.sureshbabu.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sureshbabu.restapi.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
