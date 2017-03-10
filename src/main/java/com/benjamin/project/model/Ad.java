package com.benjamin.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by benjamin on 2017/3/9.
 */
@Table(name = "ad")
public class Ad {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String title;
    private String content;
    private String contact_phone;
    private String contact_address;
    private Boolean publish;
    private String pushlish_longitude_latitude;
    private BigDecimal price;
    private Integer user_id;
    private Integer category_id;

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

    public String getPushlish_longitude_latitude() {
        return pushlish_longitude_latitude;
    }

    public void setPushlish_longitude_latitude(String pushlish_longitude_latitude) {
        this.pushlish_longitude_latitude = pushlish_longitude_latitude;
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
}
