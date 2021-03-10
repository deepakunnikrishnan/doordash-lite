package com.androidnerds.doordash.data.remote.model.menu.detail;

import com.androidnerds.doordash.data.remote.model.category.CategoryDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuDetailDTO {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("subtitle")
    private String subTitle;
    private List<CategoryDTO> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
