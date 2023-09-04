package ru.netology.moneytransfer.repository;

import ru.netology.moneytransfer.domain.Operation;
import java.util.Optional;

public interface OperationRepository {

	Operation save(Operation operation);

	Optional<Operation> getOperationByOperationId(String OperationId);

}
