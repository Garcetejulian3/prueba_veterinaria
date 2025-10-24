package com.clinica_veterinaria.clinica_veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica_veterinaria.clinica_veterinaria.dto.DTODueno_Mascota;
import com.clinica_veterinaria.clinica_veterinaria.models.Dueno;
import com.clinica_veterinaria.clinica_veterinaria.models.Mascota;
import com.clinica_veterinaria.clinica_veterinaria.repository.IDuenoRepository;
import com.clinica_veterinaria.clinica_veterinaria.repository.IMascotaRepository;

@Service
public class MascotaService implements IMascotaService{

    @Autowired IMascotaRepository mascoRepo;
    @Autowired IDuenoRepository duenoRepo;

    @Override
    public void saveMascota(Mascota mascota) {
        mascoRepo.save(mascota);
    }

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void deleteMascota(Long id) {
        Dueno dueno = duenoRepo.findByUnaMascota_Id(id);
        if(dueno != null){
            dueno.setUnaMascota(null);
            duenoRepo.save(dueno);
        }
        mascoRepo.deleteById(id);
    }

    @Override
    public void editMascota(Mascota mascota) {
        mascoRepo.save(mascota);

    }

    @Override
    public List<Mascota> getMascotaByRaza(String especie) {
        String especieEspecifica = especie.toLowerCase(); // por las dudas combierto a minuscula 
        List<Mascota> listaMascotas = mascoRepo.findAll(); // lista con todas las mascotas de la base de datos
        List<Mascota> resultadoBusqueda = new ArrayList<>(); // donde voy a guardar las mascotas con la raza especificada

        for(Mascota masco:listaMascotas){
            if(masco.getEspecie() != null){
                String razaObtenida = masco.getEspecie().toLowerCase(); // obtengo la raza y la convierto en minuscula

                if(razaObtenida.contains(especieEspecifica)){
                    resultadoBusqueda.add(masco);
                }
            }
        }
        if (resultadoBusqueda.isEmpty()) {
            throw new RuntimeException("Especie no encontrada");
        }

        return resultadoBusqueda;
        
    }

    @Override
    public DTODueno_Mascota getMascotaDueno(Long id) {
        
        Dueno dueno = this.duenoRepo.findById(id).orElse(null);
        Mascota masco = this.mascoRepo.findById(dueno.getId()-1).orElse(null);

        DTODueno_Mascota dtoDueno_Mascota = new DTODueno_Mascota();
        dtoDueno_Mascota.setNombre_mascota(masco.getNombre());
        dtoDueno_Mascota.setEspecie(masco.getEspecie());
        dtoDueno_Mascota.setRaza(masco.getRaza());
        dtoDueno_Mascota.setNombre_duenio(dueno.getNombre());
        dtoDueno_Mascota.setApellido_duenio(dueno.getApellido());

        return dtoDueno_Mascota;
    }

}
