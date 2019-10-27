package com.vicentem.app.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicentem.app.controller.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
