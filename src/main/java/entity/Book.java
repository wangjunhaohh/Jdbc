package entity;

public class Book {
    private String UserId;
    private String UserName;
    private String ustats;

    @Override
    public String toString() {
        return "Book{" +
                "UserId='" + UserId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", ustats='" + ustats + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUstats() {
        return ustats;
    }

    public void setUstats(String ustats) {
        this.ustats = ustats;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserId() {
        return UserId;
    }
}
