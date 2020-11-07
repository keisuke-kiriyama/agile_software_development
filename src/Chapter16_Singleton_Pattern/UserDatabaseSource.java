package Chapter16_Singleton_Pattern;

/**
 * こいつはシングルトン
 */
public class UserDatabaseSource implements UserDatabase {
    private static UserDatabase theInstance = new UserDatabaseSource();

    public static UserDatabase instance() {
        return theInstance;
    }

    private UserDatabaseSource() {}

    @Override
    public User readUser(String userName) {
        // なんらかの実装
        return null;
    }

    @Override
    public void writeUser(User user) {
        // なんらかの実装
    }
}
