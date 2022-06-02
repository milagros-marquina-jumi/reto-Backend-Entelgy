package com.java.entelgy.entity;

import java.util.List;

public class ResponseUsuarioApi {

    private List<Usuario> data;

    
    public List<Usuario> getData() {
        return this.data;
    }

    public void setData(List<Usuario> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                " data='" + getData() + "'" +
                "}";
    }

}
