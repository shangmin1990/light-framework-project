package com.benjamin.project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体必须使用JPA注解正确标注.
 * 建议保持数据库字段和类属性名称一致, 如果不一致请使用 @Column注解标示
 * 可以定义联合主键, @Id必须存在, 否则通用service xxByPrimaryKey的方法可能会出错
 */
@Table(name = "index_ad")
public class IndexAd {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String image_path;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
