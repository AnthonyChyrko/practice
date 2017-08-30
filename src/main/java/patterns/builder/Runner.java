package patterns.builder;

/**
 * Created by Anton_Chyrko on 8/30/2017.
 */
public class Runner {
    public static void main(String[] args) {
    User testUser = new User.UserBuilder("Anton", "Chyrko")
            .age(26)
            .phone("7721991")
            .address("Denisovskaia street")
            .build();
        System.out.println(testUser.toString());
    }
}
