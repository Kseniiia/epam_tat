package model;
import java.util.Objects;

public class User {
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;

    public User() {
        fullName = "";
        email = "";
        password = "";
        confirmPassword = "";
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return fullName.equals(user.fullName) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                confirmPassword.equals(user.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, password, confirmPassword);
    }
}