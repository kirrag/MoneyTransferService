package ru.netology.moneytransfer.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.moneytransfer.domain.Operation;
import org.springframework.beans.factory.annotation.Autowired;

public final class OperationHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	Operation operation;

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(Operation.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter,
			ModelAndViewContainer modelAndViewContainer,
			NativeWebRequest nativeWebRequest,
			WebDataBinderFactory webDataBinderFactory) throws Exception {
		String operationId = nativeWebRequest.getParameter("operationId");
		String code = nativeWebRequest.getParameter("code");
		return new Operation(operationId, code);
	}
}
