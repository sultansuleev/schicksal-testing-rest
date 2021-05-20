package com.csse.restapi.repositories;

import com.csse.restapi.entities.Card;
import com.csse.restapi.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Card, Long> {

}
