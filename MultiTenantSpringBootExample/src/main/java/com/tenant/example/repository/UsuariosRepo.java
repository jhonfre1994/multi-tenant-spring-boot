/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenant.example.repository;


import com.tenant.example.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhon
 */
@Repository
public interface UsuariosRepo extends JpaRepository<Usuarios, Integer>{
    
}
