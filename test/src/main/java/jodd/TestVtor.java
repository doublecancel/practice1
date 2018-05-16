package jodd;

import jodd.vtor.ValidationContext;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import jodd.vtor.constraint.NotNull;

import java.util.List;

public class TestVtor {


    public static void main(String[] args) {

        Vtor vtor = Vtor.create();
        ValidationContext context = ValidationContext.resolveFor(User.class);
        User user = new User();

        List<Violation> violations =  vtor.validate(context, user);

        if(violations == null || violations.size() == 0){
            System.out.println("没有错误！");
        }
        violations.forEach(a -> {
            String message = a.getCheck().getMessage();
            System.out.println(message);
        });


    }


    static class User {
        @NotNull(message = "用户名称不能为空")
        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
