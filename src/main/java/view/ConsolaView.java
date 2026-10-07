package view;

import dao.PersonaDAO;
import model.Persona;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ConsolaView {

    private final Scanner sc = new Scanner(System.in);

    /**
     * Muestra el menú principal y devuelve la opción seleccionada por el usuario.
     */
    public int menu() {

        System.out.println("\n=== GESTIÓN DE PERSONAS ===" +
                "\n1. Registrar un nueva persona" +
                "\n2. Listar todas las personas" +
                "\n3. Actualizar los datos de una persona" +
                "\n4. Borrar los datos de una persona" +
                "\n5. Ver una persona por ID" +
                "\n0. Salir" +
                "Elige una opción");

        return leerEntero();
    }

    /**
     * Pide un texto al usuario (por ejemplo, título o autor).
     */
    public String pedir(String etiqueta) {
        System.out.print(etiqueta + ": ");
        return sc.nextLine().trim();
    }

    /**
     * Pide un número entero al usuario, VALIDANDO que lo introduzca correctamente.
     */
    public int pedirEntero(String etiqueta){
        System.out.println(etiqueta + ": ");
        return leerEntero();
    }

    /**
     * Saca un listado de todas las personas registradas.
     */
    public void mostrarListaPersonas(List<Persona> personas){
        System.out.println("\n=== LISTA DE PERSONAS ===");
        if (personas.isEmpty()){
            System.out.println("No se ha encontrado registros de personas registradas");
        }else{
            for (Persona persona : personas){
                System.out.println(persona);
            }
        }
    }

    /**
     * Este metodo lo hacemos para sacar por pantalla los mensajes de información
     */
    public void info(String msg) {

        System.out.println(msg);
    }

    /**
     * Este otro metodo es para mostrar los mensajes de errorr.
     */
    public void error(String msg) {

        System.err.println("ERROR: " + msg);
    }

    /**
     * Lee un número entero desde teclado y repite mientras no sea válido.
     */
    private int leerEntero() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Introduce un número entero válido: ");
            }
        }
    }
}
