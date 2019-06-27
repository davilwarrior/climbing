/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climbing.project.controller;

import com.climbing.project.exception.ResourceNotFoundException;
import com.climbing.project.model.Cliente;
import com.climbing.project.repository.ClienteRepository;
import com.climbing.project.repository.UserRepository;
import com.climbing.project.request.ClienteRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {
   @Autowired
   ClienteRepository clienteRepository;
  
   @Autowired
   UserRepository userRepository;
   
   @PostMapping("/guardarCliente")
   private Cliente guardarCliente(@Valid @RequestBody ClienteRequest cliente){
       Cliente c = new Cliente();
       c.setApellido(cliente.getApellido());
       c.setNombre(cliente.getNombre());
       c.setEdad(cliente.getEdad());
       c.setUser(userRepository.findById(cliente.getUser()).get());
      return  clienteRepository.save(c);
     }
   
      @GetMapping("/clientes")
    public List<Cliente> allClientes() {
        return clienteRepository.findAll();
    }
    
    @PutMapping("/clientes/{id}")
    public Cliente updateClient(@PathVariable(value = "id") Long id,
            @Valid @RequestBody Cliente clientDetails) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

        cliente.setApellido(clientDetails.getApellido());
        cliente.setNombre(clientDetails.getNombre());
        cliente.setEdad(clientDetails.getEdad());

        Cliente updatedClient = clienteRepository.save(cliente);

        return updatedClient;

    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long id) {
        Cliente client = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id));

        clienteRepository.delete(client);

        return ResponseEntity.ok().build();
    }
}
