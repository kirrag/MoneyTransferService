package ru.netology.moneytransfer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.netology.moneytransfer.domain.Card;
import ru.netology.moneytransfer.domain.Transfer;
import ru.netology.moneytransfer.domain.Operation;
import ru.netology.moneytransfer.service.MoneyTransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class MoneyTransferController {
	private static final Logger logger = LoggerFactory.getLogger(MoneyTransferService.class);
	@Autowired
	private final MoneyTransferService service;

	MoneyTransferController(MoneyTransferService service) {
		this.service = service;
	}


	/*
	@GetMapping("/cards")
	public List<Card> all() {
		return service.findAll();
	}
	*/
	// end::get-aggregate-root[]

	//@PostMapping("/cards")
	//public Card newCard(@RequestBody Transfer newTransfer) {

	//	Card newCard = new Card(newTransfer.getCardFromNumber(), newTransfer.getCardFromValidTill(), newTransfer.getCardFromCVV(), newTransfer.getAmount());
//		return service.newCard(newCard);
//	}

	// Single item
	@GetMapping("/cards/{cardNumber}")
	public Card one(@PathVariable String cardNumber) {
		return service.getCardByNumber(cardNumber);
	}

	@CrossOrigin
	@PostMapping("/transfer")
	public Operation transfer(@RequestBody Transfer newTransfer) {
		return service.transfer(newTransfer);
	}

	@CrossOrigin
	@PostMapping("/confirmOperation")
	public Operation confirmOperation(@RequestBody Operation operation) {
		return service.confirmOperation(operation);
	}

	/*
	@PutMapping("/cards/{id}")
	public void replaceCard(@RequestBody Card newCard, @PathVariable Long id) {
		service.replaceCard(newCard, id);
	}

	@DeleteMapping("/cards/{id}")
	public void deleteCard(@PathVariable Long id) {
		service.deleteCard(id);
	}
	*/
}
