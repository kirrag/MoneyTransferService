package ru.netology.moneytransfer.service;

import ru.netology.moneytransfer.domain.Card;
import ru.netology.moneytransfer.domain.Amount;
import ru.netology.moneytransfer.domain.Transfer;
import ru.netology.moneytransfer.domain.Operation;
import ru.netology.moneytransfer.repository.CardRepositoryStubImpl;
import ru.netology.moneytransfer.repository.OperationRepositoryStubImpl;
import ru.netology.moneytransfer.exception.CardNotFoundException;
import ru.netology.moneytransfer.exception.ErrorConfirmation;
import ru.netology.moneytransfer.exception.ErrorInputData;
import ru.netology.moneytransfer.exception.ErrorTransfer;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MoneyTransferService {
	private static final Logger logger = LoggerFactory.getLogger(MoneyTransferService.class);
	@Autowired
	private final CardRepositoryStubImpl repository;
	private final OperationRepositoryStubImpl operationRepository;

	private static Operation operation;

	private Integer value1;
	private Integer value2;

	public MoneyTransferService(CardRepositoryStubImpl repository, OperationRepositoryStubImpl operationRepository) {
		this.repository = repository;
		this.operationRepository = operationRepository;
	}

	public Card newCard(Card newCard) {
		return repository.save(newCard);
	}

	public Card getCardByNumber(String cardNumber) {

		return repository.getCardByNumber(cardNumber).orElseThrow(() -> new CardNotFoundException(cardNumber));
	}

	public Operation transfer(Transfer newTransfer) {
		UUID uuid = UUID.randomUUID();
		String operationId = uuid.toString();

		Card cardFrom;
		Card cardTo;
		Amount newAmountFrom;
		Amount newAmountTo;

		String cardFromNumber = newTransfer.getCardFromNumber();
		Optional<Card> cardFromOpt = repository.getCardByNumber(cardFromNumber);
		String cardFromValidTill = newTransfer.getCardFromValidTill();
		String cardFromCvv = newTransfer.getCardFromCVV();

		String cardToNumber = newTransfer.getCardToNumber();
		Optional<Card> cardToOpt = repository.getCardByNumber(cardToNumber);

		Amount amount = newTransfer.getAmount();

		if (cardFromOpt.isPresent()
				&& cardFromOpt.get().getValidTill().equals(cardFromValidTill)
				&& cardFromOpt.get().getCvv().equals(cardFromCvv)
				&& cardToOpt.isPresent()) {

			cardFrom = cardFromOpt.get();
			cardTo = cardToOpt.get();

			newAmountFrom = cardFrom.getAmount();
			newAmountTo = cardTo.getAmount();
			value1 = amount.getValue();
			// convert value
			value2 = Integer.valueOf(value1.toString().substring(0, value1.toString().length() - 2));

			newAmountFrom.setValue(newAmountFrom.getValue() - value2);
			newAmountTo.setValue(newAmountTo.getValue() + value2);

			operation = new Operation(operationId, "200");
			operationRepository.save(operation);

			logger.info(LocalDateTime.now() + "[" + operationId + "]" + ": " + cardFrom.getCardNumber() + " -> "
					+ cardTo.getCardNumber() + " = " + value2 + " [200]");
			return operationRepository.getOperationByOperationId(operationId)
					.orElseThrow(() -> new ErrorTransfer(operationId));
		}
		logger.error(LocalDateTime.now() + "[" + operationId + "]" + ": [400]");
		return operationRepository.getOperationByOperationId(operationId)
				.orElseThrow(() -> new ErrorInputData(operationId));
	}

	public Operation confirmOperation(Operation operation) {
		String operationId = operation.getOperationId();
		if (operationRepository.getOperationByOperationId(operationId).isPresent()) {
			logger.info(LocalDateTime.now() + "[" + operationId + "]" + ": [200]");
			return operationRepository.getOperationByOperationId(operationId)
					.orElseThrow(() -> new ErrorConfirmation(operationId));
		}
		logger.error(LocalDateTime.now() + "[" + operationId + "]" + ": [400]");
		return operationRepository.getOperationByOperationId(operationId)
				.orElseThrow(() -> new ErrorInputData(operationId));
	}
}
