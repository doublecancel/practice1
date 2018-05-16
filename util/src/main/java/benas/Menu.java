package benas;

public class Menu {

    private Integer menu_id;
    private String menu_name;
    private String remark;
    private String menu_url;
    private String menu_class;
    private String menu_type;
    private Integer level;
    private String parent_id;
    private Integer sort;
    private String status;
    private Integer web_id;

    public static Menu create(){
        return new Menu();
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public Menu menu_id(Integer menu_id) {
        this.menu_id = menu_id;
        return this;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public Menu menu_name(String menu_name) {
        this.menu_name = menu_name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Menu remark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public Menu menu_url(String menu_url) {
        this.menu_url = menu_url;
        return this;
    }

    public String getMenu_class() {
        return menu_class;
    }

    public Menu menu_class(String menu_class) {
        this.menu_class = menu_class;
        return this;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public Menu menu_type(String menu_type) {
        this.menu_type = menu_type;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Menu level(Integer level) {
        this.level = level;
        return this;
    }

    public String getParent_id() {
        return parent_id;
    }

    public Menu parent_id(String parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Menu sort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Menu status(String status) {
        this.status = status;
        return this;
    }

    public Integer getWeb_id() {
        return web_id;
    }

    public Menu web_id(Integer web_id) {
        this.web_id = web_id;
        return this;
    }
}
