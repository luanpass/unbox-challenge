package br.com.unbox.validator;

import br.com.unbox.data.UserData;
import br.com.unbox.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private static final String EMAIL_REGEX = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+";

    private final DocValidator docValidator;

    private final UserRepository userRepository;

    @Override
    public void validate(Object o, Errors errors) {
        if (o instanceof UserData) {
            UserData userData = (UserData) o;

            if (StringUtils.isBlank(userData.getDoc())) {
                errors.rejectValue("doc", "Void Document");
            }

            if (StringUtils.isBlank(userData.getEmail()) || !userData.getEmail().matches(EMAIL_REGEX)) {
                errors.rejectValue("email", "Invalid E-mail");
            }

            if (StringUtils.isBlank(userData.getName())) {
                errors.rejectValue("name", "Invalid Name");
            }

            if (!docValidator.validateCPF(userData.getDoc())) {
                errors.rejectValue("doc", "Invalid Document");
            }

            if (Objects.nonNull(userRepository.findByEmail(userData.getEmail()))) {
                errors.rejectValue("email", "User alredy exists with this email");
            }

        } else {
            errors.reject("This is not the correct form ! ");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isInstance(UserValidator.class);
    }

}
