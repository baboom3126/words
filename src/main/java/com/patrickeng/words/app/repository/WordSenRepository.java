package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.WordSenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordSenRepository extends JpaRepository<WordSenEntity,String>, CrudRepository<WordSenEntity,String> {

    List<WordSenEntity> findByTheWord(String theWord);
}
