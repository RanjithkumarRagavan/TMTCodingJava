package com.ranjith.tmtcodingjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseAttribute {
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
