package hashing;

import com.google.common.hash.Hashing;

/**
 * Created by Administrator on 2017/10/30.
 */
public class TestConsist {

    public static void main(String[] args) {
        Hashing.consistentHash(1L, 1);


        Hashing.sha256()
                .newHasher()
                .putInt(1)
                .hash()
                .asLong();


        int a = Hashing.consistentHash(1L, 3);
        int b = Hashing.consistentHash(1L, 3);



    }




}
