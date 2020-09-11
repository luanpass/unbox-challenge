package br.com.unbox.validator;

import br.com.unbox.data.UserData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import static br.com.unbox.builder.UserDataBuilder.getUserWithDot;

@SpringBootTest
public class UserValidatorTest {

    private UserValidator userValidator;
    private UserData userData;
    private BindingResult bindingResult;

    @Before
    public void setUp() {
        bindingResult = org.mockito.Mockito.mock(BindingResult.class);
        userValidator = org.mockito.Mockito.mock(UserValidator.class);
        userData = getUserWithDot().now();
    }

    @Test
    public void validateTestWithoutErrors() {
        userValidator.validate(userData, bindingResult);
        Assert.assertFalse(bindingResult.hasErrors());
    }

}


