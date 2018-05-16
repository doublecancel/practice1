package guice.demo.test.service;

import com.google.common.util.concurrent.RateLimiter;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/5.
 */
public class ProviderServiceImpl implements IProviderService {
    @Inject
    Map<String, RateLimiter> map;
}
