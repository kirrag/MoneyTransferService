package ru.netology.moneytransfer.repository;

import ru.netology.moneytransfer.domain.Card;
import java.util.Optional;

public interface CardRepository {

	Card save(Card card);

	Optional<Card> getCardByNumber(String cardNumber);

}
