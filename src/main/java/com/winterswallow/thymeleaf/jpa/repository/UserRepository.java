package com.winterswallow.thymeleaf.jpa.repository;

import com.winterswallow.thymeleaf.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

    List<User> findAllByNameContains(String name);
}
