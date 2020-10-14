/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenant.example.web;

import com.tenant.example.dto.UsuariosDTO;
import com.tenant.example.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author jhon
 */
@RestController
@RequestMapping("/api/v.1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<UsuariosDTO> res = usuariosService.getAll();
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<?> agregar(@RequestBody UsuariosDTO usu) {
        UsuariosDTO res = usuariosService.guardarUsuario(usu);

        return ResponseEntity.ok(res);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Integer id) {
        UsuariosDTO res = usuariosService.eliminarUsuario(id);
        return ResponseEntity.ok(res);
    }
}
