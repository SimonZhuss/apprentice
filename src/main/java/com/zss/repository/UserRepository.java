package com.zss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zss.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
