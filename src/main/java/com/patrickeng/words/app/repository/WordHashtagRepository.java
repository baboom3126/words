package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.WordHashtagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordHashtagRepository extends JpaRepository<WordHashtagEntity,String>, CrudRepository<WordHashtagEntity,String> {

    List<WordHashtagEntity> findByTheWord(String theWord);
}
