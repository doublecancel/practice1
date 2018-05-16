package guice.demo.test.service;

import com.google.inject.ImplementedBy;

/**
 * Created by Administrator on 2017/12/8.
 */
@ImplementedBy(AopServiceImpl.class)
public interface IAopService {


    String test(String name);


}
