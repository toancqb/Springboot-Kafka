package com.cfa.jobs.letter;

import com.cfa.objects.letter.Letter;
import com.cfa.objects.letter.repository.LetterRepository;
import com.cfa.objects.letter.service.LetterService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LetterWriter implements ItemWriter<Letter> {

    @Autowired
    public LetterService letterService;

    @Override
    public void write(List<? extends Letter> letters) throws Exception {
        letterService.createLetters(letters);
        Thread.sleep(5000);
    }
}