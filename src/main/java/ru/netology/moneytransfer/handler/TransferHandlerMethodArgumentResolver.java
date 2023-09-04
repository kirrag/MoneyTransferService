package ru.netology.moneytransfer.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.moneytransfer.domain.Amount;
import ru.netology.moneytransfer.domain.Transfer;
import org.springframework.beans.factory.annotation.Autowired;

public final class TransferHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	Transfer transfer;

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(Transfer.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter,
			ModelAndViewContainer modelAndViewContainer,
			NativeWebRequest nativeWebRequest,
			WebDataBinderFactory webDataBinderFactory) throws Exception {
		String cardFromNumber = nativeWebRequest.getParameter("cardFromNumber");
		String cardFromValidTill = nativeWebRequest.getParameter("cardFromValidTill");
		String cardFromCVV = nativeWebRequest.getParameter("cardFromCVV");
		String cardToNumber = nativeWebRequest.getParameter("cardToNumber");
		String value = nativeWebRequest.getParameter("value");
		String type = nativeWebRequest.getParameter("type");

		Amount amount = new Amount(Integer.parseInt(value), type);
		return new Transfer(cardFromNumber, cardFromValidTill, cardFromCVV, cardToNumber, amount);
	}
}
