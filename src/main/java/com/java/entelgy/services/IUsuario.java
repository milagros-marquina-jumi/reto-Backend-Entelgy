package com.java.entelgy.services;

import com.java.entelgy.entity.RequestUsuarioApi;
import com.java.entelgy.entity.ResponseUsuarioApi;

public interface IUsuario {

    public ResponseUsuarioApi getUsuarios(Integer page, Integer perPage);

}
