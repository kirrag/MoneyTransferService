package ru.netology.moneytransfer.repository;

import ru.netology.moneytransfer.domain.Card;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class CardRepositoryStubImpl implements CardRepository {

	private ConcurrentMap<String, Card> repo;

	public CardRepositoryStubImpl() {
		this.repo = new ConcurrentHashMap<>();
	}

	public Optional<Card> getCardByNumber(String cardNumber) {
		return Optional.ofNullable(repo.get(cardNumber));
	}

	public Card save(Card card) {
		repo.put(card.getCardNumber(), card);
		return card;
	}
}
