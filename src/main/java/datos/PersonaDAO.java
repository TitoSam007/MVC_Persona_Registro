package datos;

import datos.Conexion;
import dominio.Persona;
import java.util.*;
import java.sql.*;


public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_Persona, nom, cognoms, email, edat FROM persona";

    private static final String SQL_INSERT = "INSERT INTO persona (nom,cognoms,email,edat) VALUES (?,?,?,?)";

    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_Persona = ?";

    private static final String SQL_DELETE_MAYOR = "DELETE FROM persona WHERE edat > 15";

    private static final String SQL_UPDATE_ADD_S ="UPDATE persona SET nom = CONCAT(nom, 's')  WHERE edat >= 20";

    private static final String SQL_UPDATE_USER_DATES = "UPDATE persona SET nom = ?, cognoms = ?, email = ?, edat = ? WHERE id_Persona = ?";


    public List<Persona> seleccionar() throws SQLException {
        List<Persona> personas = new ArrayList<>();

        try (
                Connection conexion = Conexion.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(SQL_SELECT);
                ResultSet resultado = sentencia.executeQuery();
        ) {
            while (resultado.next()) {
                Persona persona = new Persona(
                        resultado.getString("nom"),
                        resultado.getString("cognoms"),
                        resultado.getString("email"),
                        resultado.getInt("edat")
                );

            }
            return personas;
        }

    }
        public int insertar (Persona persona) throws SQLException {

            try (
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_INSERT);
            ) {
                sentencia.setString(1, persona.getNom());
                sentencia.setString(2, persona.getCognom());
                sentencia.setString(3, persona.getEmail());
                sentencia.setInt(4, persona.getEdat());


                return sentencia.executeUpdate();
            }
        }

        public int eliminar(int id_Persona) throws SQLException {

            try (
                Connection conexion = Conexion.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE);
            )
            {
                sentencia.setInt(1, id_Persona);

                return sentencia.executeUpdate();
            }

        }

        public int eliminarMayorDeQuince () throws SQLException {

            try(
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE_MAYOR);
                    )
            {
                return sentencia.executeUpdate();
            }
        }

        public int actualizarNombreAgregandoLaS() throws SQLException{

        try(
                Connection conexion = Conexion.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_ADD_S);
                ){
                return  sentencia.executeUpdate();
        }
        }

        public int actualizarConParametrosDelUsuario(int id_Persona, String nom, String cognom, String email, int edat) throws SQLException{

        try(
                Connection conexion = Conexion.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE_USER_DATES);
                ){
            sentencia.setString(1, nom);
            sentencia.setString(2, cognom);
            sentencia.setString(3, email);
            sentencia.setInt(4, edat);
            sentencia.setInt(5, id_Persona);

            return sentencia.executeUpdate();
        }
    }
}

