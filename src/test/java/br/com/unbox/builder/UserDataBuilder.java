package br.com.unbox.builder;

import br.com.unbox.data.UserData;

public class UserDataBuilder {

    private static UserData user;

    private UserDataBuilder(){}

    public static UserDataBuilder getUser() {
        UserDataBuilder usuarioBuilder = new UserDataBuilder();
        user = new UserData();
        usuarioBuilder.user.setEmail("admin123@gmail.com");
        usuarioBuilder.user.setName("Admin");
        usuarioBuilder.user.setDoc("52144232091");

        return usuarioBuilder;
    }

    public static UserDataBuilder getUserWithDot() {
        UserDataBuilder usuarioBuilder = new UserDataBuilder();
        user = new UserData();
        usuarioBuilder.user.setEmail("admin123@gmail.com");
        usuarioBuilder.user.setName("Admin");
        usuarioBuilder.user.setDoc("521.442.320-91");

        return usuarioBuilder;
    }

    public static UserDataBuilder getUserWithInvalidDoc() {
        UserDataBuilder usuarioBuilder = new UserDataBuilder();
        user = new UserData();
        usuarioBuilder.user.setEmail("admin123@gmail.com");
        usuarioBuilder.user.setName("Admin");
        usuarioBuilder.user.setDoc("1111111111");

        return usuarioBuilder;
    }

    public static UserDataBuilder getUserWithInvalidName() {
        UserDataBuilder usuarioBuilder = new UserDataBuilder();
        user = new UserData();
        usuarioBuilder.user.setEmail("admin123@gmail.com");
        usuarioBuilder.user.setName("");
        usuarioBuilder.user.setDoc("1111111111");

        return usuarioBuilder;
    }


    public UserData now() {
        return user;
    }

}
