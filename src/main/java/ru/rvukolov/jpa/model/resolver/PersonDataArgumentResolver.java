package ru.rvukolov.jpa.model.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.rvukolov.jpa.model.PersonData;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class PersonDataArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(PersonData.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String name = webRequest.getParameter("name");
        String surname = webRequest.getParameter("surname");
        Integer age = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("age")));

        return new PersonData(name, surname, age);
    }
}
