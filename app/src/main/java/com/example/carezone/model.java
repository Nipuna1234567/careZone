package com.example.carezone;

public class model
{
  String name,category,description,purl;
    model()
    {

    }
    public model(String name, String category, String description, String purl) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
