package service;

import limiter.Limiter;

/**
 * Created by Administrator on 2017/12/8.
 */
public class CityServiceImpl implements ICityService {

    @Override
    @Limiter(1)
    public String findCityByName(String country) {
        return "city";
    }

    @Override
    public String getCountry() {
        return "city no limit";
    }

    @Override
    @Limiter(1)
    public String getCountryId() {
        return "city id ";
    }

    @Override
    public String toString() {
        return "CityServiceImpl";
    }
}
