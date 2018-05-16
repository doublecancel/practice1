package immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Created by Administrator on 2017/10/17.
 */

public class ImmutableListTest {

    public static void main(String[] args) {


        System.out.println(Integer.toBinaryString(0xfff));// 16 * 16 + 16
        System.out.println(Integer.toBinaryString(0x00000040));


        System.out.println((0x10000 | 0x111) == (0x10111));

        ImmutableList list = ImmutableList.of(1, 2);


        ImmutableMap map = ImmutableMap.of();




    }




}
