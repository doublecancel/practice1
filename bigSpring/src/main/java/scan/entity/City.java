package scan.entity;


import lombok.Data;

/**
 * Created by Administrator on 2017/9/18.
 */
@Data
public class City {
    private Long  id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;

}
