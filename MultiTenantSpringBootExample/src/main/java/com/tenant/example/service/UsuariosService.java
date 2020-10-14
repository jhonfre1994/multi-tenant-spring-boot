/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenant.example.service;

import com.tenant.example.dto.UsuariosDTO;
import java.util.List;

/**
 *
 * @author jhon
 */
public interface UsuariosService {

    List<UsuariosDTO> getAll();

    UsuariosDTO guardarUsuario(UsuariosDTO usu);

    UsuariosDTO eliminarUsuario(Integer id);
}
