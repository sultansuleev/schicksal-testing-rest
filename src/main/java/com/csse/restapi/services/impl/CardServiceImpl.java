package com.csse.restapi.services.impl;

import com.csse.restapi.entities.Card;
import com.csse.restapi.entities.Rating;
import com.csse.restapi.entities.Roles;
import com.csse.restapi.entities.Users;
import com.csse.restapi.repositories.CardRepository;
import com.csse.restapi.repositories.RatingRepository;
import com.csse.restapi.repositories.RolesRepository;
import com.csse.restapi.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }
}