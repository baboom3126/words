package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends JpaRepository<WordEntity,String>, CrudRepository<WordEntity,String> {
}
