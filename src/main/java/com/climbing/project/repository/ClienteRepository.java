/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climbing.project.repository;

import com.climbing.project.model.Cliente;
import com.climbing.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
