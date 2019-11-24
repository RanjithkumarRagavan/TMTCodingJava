
package com.ranjith.tmtcodingjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card extends BaseAttribute{


    @SerializedName("title")
    @Expose
    private BaseAttribute title;
    @SerializedName("description")
    @Expose
    private BaseAttribute description;
    @SerializedName("image")
    @Expose
    private Image image;

    public BaseAttribute getTitle() {
        return title;
    }

    public void setTitle(BaseAttribute title) {
        this.title = title;
    }

    public BaseAttribute getDescription() {
        return description;
    }

    public void setDescription(BaseAttribute description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
