package enums;

import java.util.Iterator;
import java.util.Set;

public class Text {

    enum Status {A(2), B(4), C(8), D(16), E(32);
    private int a;

        Status(int a) {
            this.a = a;
        }
    }

    public static int add(Set<Status> set){
        int a = 0;
        Iterator<Status> it = set.iterator();
        while (it.hasNext()){
            a = a | it.next().a;
        }
        return a;
    }


}
