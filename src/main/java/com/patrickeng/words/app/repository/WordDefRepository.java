package com.patrickeng.words.app.repository;

import com.patrickeng.words.app.entity.WordDefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordDefRepository extends JpaRepository<WordDefEntity,String>, CrudRepository<WordDefEntity,String> {

    List<WordDefEntity> findByTheWord(String theWord);


}
