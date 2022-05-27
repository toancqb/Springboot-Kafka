package com.cfa.objects.letter;

import com.cfa.objects.letter.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/letter/api/v1")
public class LetterController {

    @Autowired
    private LetterRepository letterRepository;

    @GetMapping("/letters")
    public List<Letter> getAll(){
        return letterRepository.findAll();
    }

    @GetMapping("/letter/{id}")
    public Letter getLetter(@PathVariable int id) {
        return getAll()
                .stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
