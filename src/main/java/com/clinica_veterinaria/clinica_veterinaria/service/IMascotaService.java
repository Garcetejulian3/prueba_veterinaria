package com.clinica_veterinaria.clinica_veterinaria.service;

import java.util.List;

import com.clinica_veterinaria.clinica_veterinaria.dto.DTODueno_Mascota;
import com.clinica_veterinaria.clinica_veterinaria.models.Mascota;

public interface IMascotaService {

    // metodo para guardar la clase mascota
    public void saveMascota(Mascota mascota);
    // metodo para traer la lsita de de mascotas de la base de datos
    public List<Mascota> getMascotas();
    // metodo para eliminar por id 
    public void deleteMascota(Long id);
    // metodo para editar
    public void editMascota(Mascota mascota);
    // metodo para obtener una mascota por especie 
    public List<Mascota> getMascotaByRaza(String especie);
    // metodo para obtener listado de los datos combinado de la clase mascota y dueño
    public DTODueno_Mascota getMascotaDueno(Long id);

}
