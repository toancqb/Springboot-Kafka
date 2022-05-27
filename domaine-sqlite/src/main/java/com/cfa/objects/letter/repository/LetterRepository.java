package com.cfa.objects.letter.repository;

import com.cfa.objects.letter.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Integer> {
    List<Letter> getByCreationDate(Date creationDate);
}
