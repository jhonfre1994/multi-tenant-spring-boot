package com.tenant.example.service.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.tenant.example.config.TenantContext;
import com.tenant.example.dto.UsuariosDTO;
import com.tenant.example.entity.Usuarios;
import com.tenant.example.exceptions.responses.BadRequestException;
import com.tenant.example.repository.UsuariosRepo;
import com.tenant.example.service.UsuariosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhon
 */
@Service
public class UsuariosServiceimpl implements UsuariosService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsuariosRepo usuariosRepo;

    @Override
    public List<UsuariosDTO> getAll() {
        List<UsuariosDTO> res = new ArrayList<>();
        List<Usuarios> usuariosList = usuariosRepo.findAll();
        if (usuariosList != null && !usuariosList.isEmpty()) {
            for (Usuarios usuarios : usuariosList) {
                res.add(mapper.map(usuarios, UsuariosDTO.class));
            }
            return res;
        }
        throw new BadRequestException("No hay usuarios en el esquema " + TenantContext.getCurrentTenant());
    }

    @Override
    public UsuariosDTO guardarUsuario(UsuariosDTO usu) {
        usuariosRepo.save(mapper.map(usu, Usuarios.class));
        return usu;
    }

    @Override
    public UsuariosDTO eliminarUsuario(Integer id) {
        Optional<Usuarios> usu = usuariosRepo.findById(id);
        if (usu != null) {
            usuariosRepo.deleteById(id);
        }
        throw new BadRequestException("Ocurrio un error al eliminar el usuario.");
    }
}
