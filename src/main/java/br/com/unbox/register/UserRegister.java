package br.com.unbox.register;

import br.com.unbox.data.UserData;
import br.com.unbox.model.UserModel;
import br.com.unbox.populator.UserModelPopulator;
import br.com.unbox.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegister {

    private final UserRepository userRepository;
    private final UserModelPopulator userModelPopulator;

    public void saveUser(UserData userData){
        try{
            UserModel userModel= new UserModel();
            userModelPopulator.populator(userData, userModel);
            userRepository.save(userModel);
        }catch (Exception e){
            throw new RuntimeException("Error in save user", e);
        }
    }
}
