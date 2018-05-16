package lambda;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompartor {

    private static final TestCompartor instance = new TestCompartor();

    public static void main(String[] args) {
        User user1 = new User(3L, "daa");
        User user2 = new User(2L, "aafdsa");
        User user3 = new User(1L, "argg");
        User user4 = new User(4L, "adfdsafd");
        User user5 = new User(5L, "abg");
        List<User> users = Lists.newArrayList(user1, user2, user3, user4, user5);

        users.forEach(System.out::println);
        System.out.println("=====================================================");
//        users.sort((User u1, User u2) -> u1.getName().length() - u2.getName().length());
//        users.sort(Comparator.comparingInt(a -> a.getName().length()));
//        users = users.stream().sorted(Comparator.comparingInt(a -> a.getName().length())).collect(Collectors.toList());
        Collections.sort(users, Comparator.comparingInt(a -> a.getName().length()));
        users.forEach(System.out::println);

    }

    static class User{
        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }





    public void print(Integer x){
        System.out.println(x);
    }






}
