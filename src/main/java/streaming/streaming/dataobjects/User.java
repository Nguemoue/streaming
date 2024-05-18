package streaming.streaming.dataobjects;

public class User {
    public String email;
    public String password;
    public String rib;
    public String birthDate;
    public String subscriptionDuration;
    public String subscriptionStartDate;
    public int subscriptionType;
    public int id;

    public User(int id,String email, String password, String rib, String birthDate,String subscriptionDuration, String subscriptionStartDate, int subscriptionType) {
        this.email = email;
        this.password = password;
        this.rib = rib;
        this.birthDate = birthDate;
        this.subscriptionDuration = subscriptionDuration;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionType = subscriptionType;

    }

}
