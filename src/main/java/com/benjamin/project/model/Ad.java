package com.benjamin.project.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * 实体必须使用JPA注解正确标注.
 * 建议保持数据库字段和类属性名称一致, 如果不一致请使用 @Column注解标示
 * 可以定义联合主键, @Id必须存在, 否则通用service xxByPrimaryKey的方法可能会出错
 */
@Table(name = "ad")
public class Ad {

    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "id主键 (新增时自动生成,不需要填写, 修改时必须要传递此id)")
    private Integer id;
    @ApiModelProperty(value = "广告名称")
    private String title;
    private String content;
    @ApiModelProperty(value = "联系电话")
    private String contact_phone;
    @ApiModelProperty(value = "联系地址")
    private String contact_address;
    @ApiModelProperty(hidden = true)
    private Boolean publish;
    @ApiModelProperty(hidden = true)
    private Date publish_time;
    @ApiModelProperty(value = "发布时的经纬度, 使用逗号隔开 维度在前 经度再后, 例如:36.98,118.27")
//    @JsonIgnore
    @Transient
    private String publish_longitude_latitude;
    @ApiModelProperty(value = "定价, 不能为负数")
    private BigDecimal price;
    @ApiModelProperty(hidden = true)
    private Integer user_id;
    @ApiModelProperty("所属分类(子分类id)")
    private Integer category_id;

//    @Transient
//    @ApiModelProperty(hidden = true)
//    private Category category;

//    @Transient
//    @ApiModelProperty(hidden = true)
//    private User user;

    @Transient
    @ApiModelProperty("图片地址")
    private Set<String> images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublish_longitude_latitude() {
        return publish_longitude_latitude;
    }

    public void setPublish_longitude_latitude(String publish_longitude_latitude) {
        this.publish_longitude_latitude = publish_longitude_latitude;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
