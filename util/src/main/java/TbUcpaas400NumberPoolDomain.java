/**
* Created by Administrator on 2017-10-14 10:30:06
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：ucpaas.tb_ucpaas_400_number_pool
*/
public class TbUcpaas400NumberPoolDomain {

    private Long id;//

    private String phone_number;//号码

    private String number_type;//号码类型（与tb_ucpaas_400_number_type.id对应）

    private Integer number_status;//号码状态(0:未分配；1:预分配；2:已分配)

    private String versions;//版本号

    private String remark;//备注

    private Integer up_status;//上线状态(0下线，1上线)

    private Integer add_type;//添加方式（0系统添加，1客户提交）

    private String assign_user;//提交订单的用户邮箱

//    private OptLocalDateTime assign_date;//下订单的时间点

    private String createName;//创建人

//    private OptLocalDateTime createDate;//创建时间

    private String modifyUserName;//修改人

//    private OptLocalDateTime modifyDate;//修改时间

    private Integer sysStatus;//系统状态0:无效,1:有效',-1:异常/脏数据

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getNumber_type() {
        return number_type;
    }

    public void setNumber_type(String number_type) {
        this.number_type = number_type;
    }

    public Integer getNumber_status() {
        return number_status;
    }

    public void setNumber_status(Integer number_status) {
        this.number_status = number_status;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUp_status() {
        return up_status;
    }

    public void setUp_status(Integer up_status) {
        this.up_status = up_status;
    }

    public Integer getAdd_type() {
        return add_type;
    }

    public void setAdd_type(Integer add_type) {
        this.add_type = add_type;
    }

    public String getAssign_user() {
        return assign_user;
    }

    public void setAssign_user(String assign_user) {
        this.assign_user = assign_user;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
    }

    @Override
    public String toString() {
        return "TbUcpaas400NumberPoolDomain{" +
                "id=" + id +
                ", phone_number='" + phone_number + '\'' +
                ", number_type='" + number_type + '\'' +
                ", number_status=" + number_status +
                ", versions='" + versions + '\'' +
                ", remark='" + remark + '\'' +
                ", up_status=" + up_status +
                ", add_type=" + add_type +
                ", assign_user='" + assign_user + '\'' +
                ", createName='" + createName + '\'' +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", sysStatus=" + sysStatus +
                '}';
    }
}