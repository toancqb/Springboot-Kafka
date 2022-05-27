package com.cfa.objects.letter.service;

import com.cfa.objects.letter.Letter;
import com.cfa.objects.letter.repository.LetterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class LetterService {

    @Autowired
    private LetterRepository letterRepository;

    public List<Letter> getAll() {
        return letterRepository.findAll();
    }

    public Letter getById(Integer id) {
        return getAll()
                .stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public void createLetter(Letter letter) {
        try {
            letterRepository.save(letter);
        } catch (Exception e) {
            log.error("[create letter] : " + e.getMessage());
        }
    }

    public void createLetters(List<? extends Letter> letters) {
        try {
            letterRepository.saveAll(letters);
        } catch (Exception e) {
            log.error("[create letters] : " + e.getMessage());
        }
    }

    private Letter letterBuilder(String message, String creationDate, String treatmentDate) {
        Letter letter = new Letter();
        letter.setMessage(message);
        letter.setCreationDate(creationDate);
        letter.setTreatmentDate(treatmentDate);
        return letter;
    }

}
