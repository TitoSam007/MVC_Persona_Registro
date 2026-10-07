package app;

import controller.PersonaController;
import dao.PersonaDAO;
import dao.RegistreDAO;
import model.Persona;
import model.Registre;
import service.PersonaService;
import view.ConsolaView;

import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {


        var view = new ConsolaView();
        var service = new PersonaService();
        var controller = new PersonaController(view,service);
        controller.run();

        PersonaDAO personaDAO = new PersonaDAO();

        try {
            List<Persona> personas= personaDAO.seleccionar();

            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        /*
        Persona novaPersona = new Persona(
                "Rafa",
                "Nadal",
                "rafa@gmail.com",
                23
        );

         */
        Persona novaPersona1 = new Persona(
                "Jose",
                "Ortega",
                "joseortega@gmail.com",
                32
        );

        /*
        try {
            int files = personaDAO.insertar(novaPersona1);
            System.out.println("Registro insertados:" + files);

            List<Persona> personas = personaDAO.seleccionar();
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         */

        /*
        try {
            int deleteFiles = personaDAO.eliminar(5);
            System.out.println("Registro eliminados:" + deleteFiles);
        }catch (Exception e){
            e.printStackTrace();
        }
         */



        /*
        try {
            int deleteFilesOver = personaDAO.eliminarMayorDeQuince();
            System.out.println("Registro de datos eliminados mayores de 15 años: " + deleteFilesOver);

        }catch(Exception e){
            e.printStackTrace();
        }
         */

        /*
        try{
            int updateFilesWithS = personaDAO.actualizarNombreAgregandoLaS();
            System.out.println("Registro de los nombres actualizados añadiendo la s al final: " + updateFilesWithS);

        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        /*
        try {
            int updateFilesDatesUser = personaDAO.actualizarConParametrosDelUsuario(5,"Sam","Zam","samzam@gmail.com",23);
            System.out.println("Actualizaciones por parametros dados por el usuaio: " +updateFilesDatesUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         */

        //Creación  de una instancia de la clase RegistreDAO
        RegistreDAO registreDAO = new RegistreDAO();



        Registre registre1 = new  Registre(5,"serpiuser","serpis2");
        Registre registreDemostracion = new Registre (10,"OrtegaUser","Ortega2");

        try {
            System.out.println("Registro de filas insertadas: " + registreDAO.insertar(registreDemostracion));

        }catch (SQLException e) {
            e.printStackTrace();
        }


        //
        try {
            for(String linea : registreDAO.listarUsuariosConPersona()){
                System.out.println(linea);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        int idRegistro = 1;

        try {
            registreDAO.eliminar(idRegistro);

        }catch(SQLException e){
            e.printStackTrace();
        }
         */

    }
}
