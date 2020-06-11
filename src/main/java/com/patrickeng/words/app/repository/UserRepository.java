package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,String>, CrudRepository<UserEntity,String> {
    UserEntity findByNumber(int number);
}
