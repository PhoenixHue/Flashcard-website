package com.techelevator.controller;

import com.techelevator.dao.JdbcCardDao;
import com.techelevator.dao.JdbcDeckDao;
import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class DeckController {

    private JdbcDeckDao deckDao;

    public DeckController(JdbcDeckDao deck) {
        this.deckDao = deck;
    }

    @RequestMapping(path = "/user/{username}/decks", method = RequestMethod.GET)
    public List<Deck> findDeckByUsername(@Valid @PathVariable String username) {
        return deckDao.findDeckByUsername(username);
    }


    @RequestMapping(path = "/deck/editDeck", method = RequestMethod.POST)
    public Deck editDeck(@Valid @RequestBody Deck deck) {
        return deckDao.editDeck(deck.getUsername(), deck.getDeck());

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/deck/createDeck", method = RequestMethod.POST)
    public String createDeck(@Valid @RequestBody Deck deck) {
        return deckDao.createDeck(deck);
    }

}
