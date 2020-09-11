package br.com.unbox.utils;

import br.com.unbox.data.UserData;
import br.com.unbox.validator.DocValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.unbox.builder.UserDataBuilder.getUserWithDot;
import static br.com.unbox.builder.UserDataBuilder.getUserWithInvalidDoc;
import static br.com.unbox.utils.DocUtils.verifyDocInvalid;

public class DocUtilsTest {

    private UserData userData;
    private UserData userDataInvalidDoc;

    @Before
    public void setUp() {
        userData = getUserWithDot().now();
        userDataInvalidDoc = getUserWithInvalidDoc().now();
    }

    @Test
    public void cleanString(){
        Assert.assertEquals("52144232091", DocUtils.cleanString(userData.getDoc()));
    }

    @Test
    public void verifyDocInvalidTestValid(){
        Assert.assertTrue(verifyDocInvalid(userData.getDoc()));
    }

    @Test
    public void verifyDocInvalidTestInvalid(){
        Assert.assertFalse(verifyDocInvalid(userDataInvalidDoc.getDoc()));
    }
}
