package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CardController {
    CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getCardList() {
        return new ResponseEntity<>(cardRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/cards/byColor/{color}")
    public ResponseEntity<List<Card>> getCardsByColor(@PathVariable String color) {
        return new ResponseEntity<>(cardRepository.findByColor(color), HttpStatus.OK);
    }

    @PostMapping("/cards")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        return new ResponseEntity<>(cardRepository.save(card), HttpStatus.OK);
    }

    @PutMapping("/cards/")
    public ResponseEntity<Card> updateCard(@RequestBody Card card) {
        return new ResponseEntity<>(cardRepository.update(card), HttpStatus.OK);
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Card> deleteCard(@PathVariable Long id) {
        return new ResponseEntity<>(cardRepository.remove(id), HttpStatus.OK);
    }

    @GetMapping("/cards/byValue/{value}")
    public ResponseEntity<List<Card>> getCardListByValue(@PathVariable Integer value) {
        return new ResponseEntity<>(cardRepository.findByValue(value), HttpStatus.OK);
    }

    @GetMapping("/cards/byType/{type}")
    public ResponseEntity<List<Card>> getCardListByType(@PathVariable String type) {
        return new ResponseEntity<>(cardRepository.findByType(type), HttpStatus.OK);
    }
}
