package ru.netology.moneytransfer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.netology.moneytransfer.repository.CardRepository;
import ru.netology.moneytransfer.domain.Card;
import ru.netology.moneytransfer.domain.Amount;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	private static final Amount amount1 = new Amount(1000000, "RUB");
	private static final Amount amount2 = new Amount(2000000, "RUB");

	@Bean
	CommandLineRunner initDatabase(CardRepository repository) {

		return args -> {
			log.info("Preloading "
					+ repository.save(new Card("0000000000000001", "01/24", "101", amount1)));
			log.info("Preloading "
					+ repository.save(new Card("0000000000000002", "02/24", "102", amount2)));
		};
	}
}
