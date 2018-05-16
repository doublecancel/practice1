package repeatScan.ConditionOnTest;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/2.
 */
@Conditional(MyCondition2.class)
@Component
public class CityService2 implements ICityService {
    @Override
    public String getCityName() {
        return "2";
    }
}
