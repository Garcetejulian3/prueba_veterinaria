package com.clinica_veterinaria.clinica_veterinaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.clinica_veterinaria.clinica_veterinaria.dto.DTODueno_Mascota;
import com.clinica_veterinaria.clinica_veterinaria.models.Mascota;
import com.clinica_veterinaria.clinica_veterinaria.service.MascotaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class MascotaController {

    @Autowired
    MascotaService mascoServi;

    @PostMapping("/mascota/crear")
    public String saveMascota(@RequestBody Mascota mascota) {
        mascoServi.saveMascota(mascota);
        
        return "Se guardo a la mascota: " + mascota.getNombre() + " correctamente";
    }

    @GetMapping("/mascota/traer")
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoServi.getMascotas();
        return listaMascotas;
    }
    
    @DeleteMapping("/mascota/delete/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascoServi.deleteMascota(id);
        return "La mascota con el id: " + id + " se elimino correctamente";
    }

    @PutMapping("/mascota/edit")
    public String editMascota(@RequestBody Mascota mascota) {
        mascoServi.editMascota(mascota);
        
        return "Se edito a la mascota: " + mascota.getNombre() + " correctamente";
    }
    
    @GetMapping("/mascota/raza/{especie}")
    public ResponseEntity<?> getMascotaByRaza(@PathVariable String especie) {

        try{
            List<Mascota> listaMascotaEspecie = mascoServi.getMascotaByRaza(especie);
            return ResponseEntity.ok(listaMascotaEspecie);
        } catch(RuntimeException e){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
        }

    }

    @GetMapping("/mascota/duenio/{id}")
    public DTODueno_Mascota getMascotaDueno(@PathVariable Long id) {
        DTODueno_Mascota mascota_duenio = mascoServi.getMascotaDueno(id);
        return mascota_duenio;
    }
    
    
}
