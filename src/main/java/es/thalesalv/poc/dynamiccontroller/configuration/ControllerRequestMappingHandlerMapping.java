package es.thalesalv.poc.dynamiccontroller.configuration;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ControllerRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    private final ApplicationProperties applicationProperties;

    private static final String CONTROLLER = "Controller";

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {

        List<String> enabledControllers = applicationProperties.getControllersEnabled().stream()
                .map(controllerName -> controllerName + CONTROLLER)
                .collect(Collectors.toList());

        boolean isEnabled = enabledControllers.contains(handlerType.getSimpleName());

        if (isEnabled) {
            return super.getMappingForMethod(method, handlerType);
        }

        return null;
    }
}
