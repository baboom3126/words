package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>, CrudRepository<UserEntity,Long> {

}
