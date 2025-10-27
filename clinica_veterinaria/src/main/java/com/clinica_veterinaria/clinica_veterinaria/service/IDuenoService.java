package com.clinica_veterinaria.clinica_veterinaria.service;

import java.util.List;

import com.clinica_veterinaria.clinica_veterinaria.models.Dueno;

public interface IDuenoService {

    // metodo para guardar la clase dueño
    public void saveDueno(Dueno dueno);
    // metodo para traer la lsita de de dueños de la base de datos
    public List<Dueno> getDuenos();
    // metodo para eliminar por id 
    public void deleteDueno(Long id);
    // metodo para editar
    public void editDueno(Dueno dueno);
    // metodo para buscar dueño por id de mascota 
    public Dueno findDueñoByMasco(Long id_mascota);
}
