package service;

import model.User;

public class UserCreator {
    public static final String USER_TO_LOG_IN_EMAIL = "testdata.userToLogIn.email";
    public static final String USER_TO_LOG_IN_PASSWORD = "testdata.userToLogIn.password";
    public static final String USER_TO_LOG_IN_FULL_NAME = "testdata.userToLogIn.fullName";

    public static final String USER_TO_SUBSCRIBE_EMAIL = "testdata.userToSubscribe.email";

    public static final String USER_TO_REGISTER_FULL_NAME = "testdata.userToRegister.fullName";
    public static final String USER_TO_REGISTER_EMAIL = "testdata.userToRegister.email";
    public static final String USER_TO_REGISTER_PASSWORD = "testdata.userToRegister.password";
    public static final String USER_TO_REGISTER_CONFIRM_PASSWORD = "testdata.userToRegister.confirmPassword";

    public static User forLogin() {
        User user = new User();

        user.setEmail(TestDataReader.getTestData(USER_TO_LOG_IN_EMAIL));
        user.setPassword(TestDataReader.getTestData(USER_TO_LOG_IN_PASSWORD));
        user.setFullName(TestDataReader.getTestData(USER_TO_LOG_IN_FULL_NAME));

        return user;
    }

    public static User forSubscription() {
        User user = new User();

        user.setEmail(TestDataReader.getTestData(USER_TO_SUBSCRIBE_EMAIL));

        return user;
    }

    public static User forRegistration() {
        User user = new User();

        user.setFullName(TestDataReader.getTestData(USER_TO_REGISTER_FULL_NAME));
        user.setEmail(TestDataReader.getTestData(USER_TO_REGISTER_EMAIL));
        user.setPassword(TestDataReader.getTestData(USER_TO_REGISTER_PASSWORD));
        user.setConfirmPassword(TestDataReader.getTestData(USER_TO_REGISTER_CONFIRM_PASSWORD));

        return user;
    }
}