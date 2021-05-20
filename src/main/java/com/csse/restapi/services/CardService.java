package com.csse.restapi.services;

import com.csse.restapi.entities.Card;
import com.csse.restapi.entities.Rating;
import com.csse.restapi.entities.Users;

import java.util.List;

public interface CardService {
    List<Card> getAll();
    Card createCard(Card card);
    void deleteCard(Card card);
    Rating createRating(Rating rating);
    List<Rating> getRatings();
}