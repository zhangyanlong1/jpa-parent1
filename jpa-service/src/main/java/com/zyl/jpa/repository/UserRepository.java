package com.zyl.jpa.repository;

import com.zyl.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
