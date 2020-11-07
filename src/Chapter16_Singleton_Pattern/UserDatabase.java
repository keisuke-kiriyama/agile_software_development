package Chapter16_Singleton_Pattern;

public interface UserDatabase {
    User readUser(String userName);
    void writeUser(User user);
}
