package controller;

import model.exceptions.ReglaNegocioException;
import service.PersonaService;
import view.ConsolaView;

public class PersonaController {

    private final ConsolaView view;

    private final PersonaService personaService;

    public PersonaController(ConsolaView view, PersonaService personaService) {

        this.view = view;
        this.personaService = personaService;
    }

    public void run(){
        int option;
        do {
            option = view.menu();
            try{
                /*
                switch (option) {
                    case 1 -> crear();
                    case 2 -> listar();
                    case 3 -> actualizar();
                    case 4 -> borrar();
                    case 5 -> verPorId();
                    case 0 -> view.info("¡Hasta luego!");
                    default -> view.error("Opción inválida, inténtalo de nuevo.");

                 */

            }catch(ReglaNegocioException e){
                view.error("Atención!" + e.getMessage());
            }catch(RuntimeException e){
                view.error("Atención" + e.getMessage());
            }

        }while(option != 0);
    }

    private void crear(){
        String nombre = view.pedir("Nombre");
        String apellido = view.pedir("Apellido");
        String email = view.pedir("Email");
        int edad = view.pedirEntero("Edad");
    }

    private void listar(){view.mostrarListaPersonas(personaService.listar());}

}
