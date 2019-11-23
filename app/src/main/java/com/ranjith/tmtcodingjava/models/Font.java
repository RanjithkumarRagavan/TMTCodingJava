
package com.ranjith.tmtcodingjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Font {

    @SerializedName("size")
    @Expose
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
