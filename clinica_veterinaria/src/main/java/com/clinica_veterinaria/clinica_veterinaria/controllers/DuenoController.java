package com.clinica_veterinaria.clinica_veterinaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.clinica_veterinaria.clinica_veterinaria.models.Dueno;
import com.clinica_veterinaria.clinica_veterinaria.service.DuenoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class DuenoController {

    @Autowired
    DuenoService duenoServi;

    @PostMapping("/duenio/crear")
    public String saveMascota(@RequestBody Dueno dueno) {
        duenoServi.saveDueno(dueno);
        
        return "El dueño con el id: " + dueno.getApellido() + " se guardado correctamente";
    }
    
    @GetMapping("/duenio/obtener")
    public List<Dueno> getDuenos() {
        List<Dueno> listaDuenos = duenoServi.getDuenos();
        return listaDuenos;
    }

    @DeleteMapping("/duenio/delete/{id}")
    public String deleteDuenio(@PathVariable Long id){
        duenoServi.deleteDueno(id);
        return "El Dueño con el id: " + id + " se elimino correctamente";
    }

    @PutMapping("/duenio/edit")
    public String editDuenio(@RequestBody Dueno dueno) {
        duenoServi.editDueno(dueno);
        
        return "El dueño con el id: " + dueno.getApellido() + " se editado correctamente";
    }
    
}
