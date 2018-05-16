package scan.dao;

import scan.entity.City;

/**
 * Created by Administrator on 2017/9/28.
 */
public interface CityDao {
    City findCityById(Long id);
}
