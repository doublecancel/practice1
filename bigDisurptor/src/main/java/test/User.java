package test;

import com.google.gson.Gson;

public class User {
    private String id;
    private transient String name;

    public static void main(String[] args) {
        User user = new User();
        user.id = "1";
        user.name = "2";
        System.out.println(new Gson().toJson(user));
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
