package com.clinica_veterinaria.clinica_veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica_veterinaria.clinica_veterinaria.models.Dueno;
import com.clinica_veterinaria.clinica_veterinaria.repository.IDuenoRepository;

@Service
public class DuenoService implements IDuenoService{

    @Autowired
    IDuenoRepository duenoRepo;

    @Override
    public void saveDueno(Dueno dueno) {
        duenoRepo.save(dueno);
    }

    @Override
    public List<Dueno> getDuenos() {
        List<Dueno> listaDenos = duenoRepo.findAll();
        return listaDenos;
    }

    @Override
    public void deleteDueno(Long id) {
        duenoRepo.deleteById(id);
    }

    @Override
    public void editDueno(Dueno dueno) {
        duenoRepo.save(dueno);
    }

    @Override
    public Dueno findDueñoByMasco(Long id_mascota) {
        Dueno dueno = duenoRepo.findByUnaMascota_Id(id_mascota);
        return dueno;
    }

}
