package com.cfa.objects.letter;

import com.cfa.objects.letter.service.LetterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/letter/api/v1")
public class LetterController {

    @Autowired
    private LetterService letterService;

    @GetMapping("/letters")
    public List<Letter> getAll(){
        return letterService.getAll();
    }

    @GetMapping("/letter/{id}")
    public Letter getLetter(@PathVariable int id) throws Exception {
        try {
            return letterService.getById(id);
        } catch (Exception e) {
            log.error("Id" + id + " is not found");
            throw new Exception("Id is not found");
        }
    }

    @PostMapping(value = "/letter",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void createLetter(@RequestBody Letter letter) throws Exception {
        try {
            letterService.createLetter(letter);
        } catch (Exception e) {
            log.error("Letter is invalid");
            throw new Exception("Letter is invalid");
        }
    }

    @PostMapping(value = "/letters",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void createLetters(@RequestBody List<Letter> letters) throws Exception {
        try {
            letterService.createLetters(letters);
        } catch (Exception e) {
            log.error("Letters are invalid");
            throw new Exception("Letters are invalid");
        }
    }
}
