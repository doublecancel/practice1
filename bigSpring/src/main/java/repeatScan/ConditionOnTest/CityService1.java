package repeatScan.ConditionOnTest;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/2.
 */
@Conditional(MyCondition.class)
@Component
public class CityService1 implements ICityService {
    @Override
    public String getCityName() {
        return "1";
    }
}
