package br.com.unbox.populator;

import br.com.unbox.data.UserData;
import br.com.unbox.model.UserModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.unbox.builder.UserDataBuilder.getUser;

public class UserModelPopulatorTest {

    private UserModelPopulator modelPopulator;
    private UserData userData;

    @Before
    public void setUp() {
        modelPopulator = new UserModelPopulator();
        userData = getUser().now();
    }

    @Test
    public void populatorTest() {
        UserModel userModel = new UserModel();
        modelPopulator.populator(userData, userModel);
        Assert.assertEquals(userData.getDoc(), userModel.getDoc());
        Assert.assertEquals(userData.getEmail(), userModel.getEmail());
        Assert.assertEquals(userData.getName(), userModel.getName());
    }
}
