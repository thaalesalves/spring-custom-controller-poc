package es.thalesalv.poc.dynamiccontroller.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RestControllerConfiguration extends DelegatingWebMvcConfiguration {

    private final ApplicationProperties applicationProperties;

    @Bean
    @Primary
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping(
            @Qualifier("mvcContentNegotiationManager") ContentNegotiationManager contentNegotiationManager,
            @Qualifier("mvcConversionService") FormattingConversionService conversionService,
            @Qualifier("mvcResourceUrlProvider") ResourceUrlProvider resourceUrlProvider) {

        return super.requestMappingHandlerMapping(contentNegotiationManager, conversionService, resourceUrlProvider);
    }

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {

        return new ControllerRequestMappingHandlerMapping(applicationProperties);
    }
}
