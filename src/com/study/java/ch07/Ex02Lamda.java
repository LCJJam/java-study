package com.study.java.ch07;

import java.util.HashMap;
import java.util.Map;

public class Ex02Lamda {
    public static void main(String[] args) {
        Map<String, User> allUsers = UserService.getUserMap();
        Map<String, User> condUser = null;

        condUser = UserService.search(allUsers, new Criteria() {
            @Override
            public boolean where(User user){
                return user.getAge() < 30;
            }
        });

        UserService.printUsers(condUser);

        System.out.println();
        condUser = UserService.search(allUsers, u -> u.getAge() > 20);

        UserService.printUsers(condUser);

        System.out.println();
        condUser = UserService.search(allUsers, u -> u.getName().startsWith("test"));

        UserService.printUsers(condUser);

    }
}

@FunctionalInterface
interface Criteria {
    public abstract boolean where(User user);
}

class UserService {
    private static Map<String, User> userMap;

    static {
        userMap = new HashMap<>();
        UserService.add("admin", new User("admin", 24));
        UserService.add("test2", new User("test2", 17));
        UserService.add("test3", new User("admin2", 28));
        UserService.add("test4", new User("admin3", 32));
        UserService.add("test5", new User("test5", 42));
        UserService.add("test6", new User("admin5", 25));
    }

    public static Map<String, User> getUserMap() {
        return userMap;
    }

    public static void add (String id , User user) {
        userMap.put(id , user);
    }

    public static Map<String, User> search(Map<String,User> users, Criteria c) {
        Map<String, User> condUsers = new HashMap<>();

        for (Map.Entry<String, User> entry : users.entrySet()) {
            if(c.where(entry.getValue())) {
                condUsers.put(entry.getKey(), entry.getValue());
            }
        }
        return condUsers;
    }

    public static void printUsers(Map<String, User> users) {
        for(Map.Entry<String, User> entry : users.entrySet() ) {
            System.out.println(entry.getValue());
        }
    }

}

class User {
    private String name;
    private int age;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }

}