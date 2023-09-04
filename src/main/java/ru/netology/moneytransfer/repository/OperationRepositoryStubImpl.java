package ru.netology.moneytransfer.repository;

import ru.netology.moneytransfer.domain.Operation;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class OperationRepositoryStubImpl implements OperationRepository {

	private ConcurrentMap<String, Operation> repo;

	public OperationRepositoryStubImpl() {
		this.repo = new ConcurrentHashMap<>();
	}

	public Optional<Operation> getOperationByOperationId(String operationId) {
		return Optional.ofNullable(repo.get(operationId));
	}

	public Operation save(Operation operation) {
		repo.put(operation.getOperationId(), operation);
		return operation;
	}
}
