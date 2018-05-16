package base;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public class MockTest {



    @Test
    public void test(){

        IUserService service = Mockito.mock(IUserService.class);
        Mockito.when(service.save()).thenReturn(1);
//        Mockito.when(service.listUser()).thenThrow(new RuntimeException("not ok"));
//        System.out.println(service.save());
//        service.listUser();

        Mockito.doThrow(new RuntimeException("void throw exception")).when(service).delete();
        service.delete();
    }

    @Test
    public void test1(){
        IUserService service = Mockito.mock(IUserService.class);
        //模拟有参数的情况
        Mockito.when(service.findById(Mockito.anyLong())).then((a) -> {
            return new User(1L, "lxl", "123456");
        });

        System.out.println(service.findById(1L).toString());

        //模拟有参数 抛出异常的情况
        Mockito.when(service.findById(Mockito.anyLong())).thenThrow(new RuntimeException("aaa"));

        service.findById(1L);
    }

    @Test
    public void test2(){

        IUserService service = Mockito.mock(IUserService.class);
        service.findById(1L);
        service.findById(2L);

        //模拟方法的调用次数
        Mockito.verify(service, Mockito.times(2)).findById(Mockito.anyLong());
//        service.delete();

        Mockito.verify(service, Mockito.never()).delete();

    }

    /**
     * 检验调用方法的顺序
     */
    @Test
    public void test3(){

        IUserService userService = Mockito.mock(IUserService.class);
        ITestService testService = Mockito.mock(ITestService.class);
        InOrder inOrder = Mockito.inOrder(userService, testService);

        userService.save();
        userService.update(new User(1L, "lxl", "123456"));
        userService.delete();

        inOrder.verify(userService).save();
        inOrder.verify(userService).update(new User(1L, "lxl", "123456"));
        inOrder.verify(userService).delete();


        //两个mock对象的调用顺序控制


//        testService.test();


        inOrder.verify(testService).test();

    }


    @Mock
    IUserService userService;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test4(){

        Mockito.when(userService.save()).thenReturn(100).thenReturn(101).thenReturn(102);

        System.out.println(userService.save());
        System.out.println(userService.save());
        System.out.println(userService.save());
        System.out.println(userService.save());

    }

    /**
     * 调用真实的对象spy
     */
    @Test
    public void test5(){
        List<String> list = new ArrayList<>();
        List<String> spy = Mockito.spy(list);

        Mockito.when(spy.size()).thenReturn(100);
        spy.add("abc");
        System.out.println(spy.size());

        System.out.println(spy.get(0));

    }







}
