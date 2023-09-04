package ru.netology.moneytransfer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.moneytransfer.handler.TransferHandlerMethodArgumentResolver;
import ru.netology.moneytransfer.handler.OperationHandlerMethodArgumentResolver;
import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new TransferHandlerMethodArgumentResolver());
		argumentResolvers.add(new OperationHandlerMethodArgumentResolver());
	}
}
