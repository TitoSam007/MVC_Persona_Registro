package service;

import dao.PersonaDAO;
import model.exceptions.ReglaNegocioException;

public class PersonaService {

    private final PersonaDAO dao = new PersonaDAO();

    /**Crear una persona nueva (con validaciones)*/

    public Integer crearPersona(String nombre, String apellidos,String email,int edad){
        validarCamposComunes(nombre,apellidos,email,edad);
        return dao.cre;
    }

    /**Validaciones más generales, pero vosotros podéis añadir más*/

    private void validarCamposComunes(String nombre, String apellidos,String email, int edad){

        if (nombre == null || nombre.isBlank()){
            throw new ReglaNegocioException("El nombre de la persona es obligatorio");
        }
        if (apellidos == null || apellidos.isBlank()){
            throw new ReglaNegocioException("El apellido de la persona es obligatorio");
        }
        if (email == null || email.isBlank()){
            throw new ReglaNegocioException("El email es obligatorio");
        }
        if (edad <= 0){
            throw  new ReglaNegocioException("El edad debe ser un entero positivo");
        }
    }
}
