package com.java.entelgy.entity;

public class RequestUsuarioApi {
    private Integer page;
    private Integer perPage;
    
    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return this.perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @Override
    public String toString() {
        return "{" +
                " page='" + getPage() + "'" +
                ", perPage='" + getPerPage() + "'" +
                "}";
    }

}
