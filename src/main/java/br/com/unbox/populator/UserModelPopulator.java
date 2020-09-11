package br.com.unbox.populator;

import br.com.unbox.data.UserData;
import br.com.unbox.model.UserModel;
import org.springframework.stereotype.Component;

import static br.com.unbox.utils.DocUtils.cleanString;

@Component
public class UserModelPopulator {

    public void populator(UserData userData, UserModel userModel){
        try{
            userModel.setEmail(userData.getEmail());
            userModel.setName(userData.getName());
            userModel.setDoc(cleanString(userData.getDoc()));
        }catch (Exception e){
            throw new RuntimeException("Error in convert user", e);
        }
    }
}
