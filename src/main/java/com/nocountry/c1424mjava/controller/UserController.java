package com.nocountry.c1424mjava.controller;

import com.nocountry.c1424mjava.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
/*
    @Autowired
    private AdminService adminService;


    @GetMapping()
    @ResponseBody
    public List<UserDto>getAll(){
        return adminService.getAll();
    }

    @GetMapping("/eliminado")
    @ResponseBody
    public List<UserDto>getAllDisabled(){
        return adminService.getAllDisabled();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAdminById(@PathVariable("id") Long id)  {
        UserDto userDTO = adminService.getAdminById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> save(@RequestBody @Valid UserDto userDTO)  {
        adminService.save(userDTO);
        String message = "El Administrador se ha registrado correctamente ";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable ("id") Long id, @RequestBody @Valid  UserDTO userDTO)  {
        adminService.update(id,userDTO);
        String message = ("registro con el Id " + id + " fue Actualizado");
        return ResponseEntity.ok().body(message);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteById(@PathVariable("id") Long id) {
        adminService.deleteById(id);
        String message = ("administrador  con el Id " + id + " fue eliminado");
        return ResponseEntity.ok().body(message);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object>activeById(@PathVariable("id") Long id) {
        adminService.activeById(id);
        String message = ("administrador  con el Id " + id + " fue activado");
        return ResponseEntity.ok().body(message);

    }
*/

}
