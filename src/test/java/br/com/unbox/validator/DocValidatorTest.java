package br.com.unbox.validator;

import br.com.unbox.data.UserData;
import br.com.unbox.populator.UserModelPopulator;
import br.com.unbox.validator.DocValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.unbox.builder.UserDataBuilder.*;

public class DocValidatorTest {

    private DocValidator docValidator;
    private UserData userData;
    private UserData userDataInvalidDoc;

    @Before
    public void setUp() {
        docValidator = new DocValidator();
        userData = getUserWithDot().now();
        userDataInvalidDoc = getUserWithInvalidDoc().now();
    }

    @Test
    public void validateCPFTestTrue(){
        Assert.assertTrue(docValidator.validateCPF(userData.getDoc()));
    }

    @Test
    public void validateCPFTestFalse(){
        Assert.assertFalse(docValidator.validateCPF(userDataInvalidDoc.getDoc()));
    }
}
