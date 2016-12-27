package com.lucky.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lucky on 16-12-27.
 */
public class Category {

    @Id
    @GeneratedValue(generator = "JDBC")
    private long categoryId;
    private String categoryName;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
