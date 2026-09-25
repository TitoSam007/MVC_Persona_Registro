package datos;

import dominio.Registre;
import java.sql.*;
import java.util.*;
public class RegistreDAO {

        private static final String SQL_INSERT=
                "INSERT INTO registre (id_persona,`user`,`password`) values (?,?,?)";
        private static final String SQL_SELECT=
                "SELECT id_registre,id_persona, `user`,`password` FROM registre";
        private static final String SQL_UPDATE=
                "UPDATE registre SET 'user' = ? WHERE id_registre = ?";
        private static final String SQL_DELETE=
                "DELETE FROM registre WHERE id_registre = ?";

        private static final String SQL_JOIN =
                "select p.id_persona, p.nom, p.cognoms, r.user\n" +
                        "from persona as p\n" +
                        "inner join registre as r\n" +
                        "\ton p.id_persona = r.id_persona;";

        public int insertar(Registre registre) throws SQLException {

            try(
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_INSERT);
            ){
                sentencia.setInt(1,registre.getIdPersona());
                sentencia.setString(2, registre.getUser());
                sentencia.setString(3,registre.getPassword());

                return sentencia.executeUpdate();
            }
        }

        public List<Registre> seleccionar() throws SQLException {
            List<Registre> registres = new ArrayList<>();

            try(
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_SELECT);
                    ResultSet resultado = sentencia.executeQuery();
            ) {
                while (resultado.next()) {
                    Registre r = new Registre(resultado.getInt("id_registre"),
                                                resultado.getInt("id_persona"),
                                                resultado.getString("user"),
                                                resultado.getString("password"));
                    registres.add(r);
                }

            }
            return registres;
        }

        public List<String> listarUsuariosConPersona()throws SQLException {
            List<String> lista = new ArrayList<>();

            try(
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_JOIN);
                    ResultSet resultado = sentencia.executeQuery();
            ){
                while (resultado.next()) {
                    String linea = resultado.getString("nom") +
                            " " +  resultado.getString("cognoms") +
                            " " +  resultado.getString("user");
                    lista.add(linea);
                }
            }
            return lista;
        }

        public int actualizarUsuario(int idRegistre, String nuevoUser)throws SQLException {

            try(
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_UPDATE);
                    ){
                    sentencia.setString(1,nuevoUser);
                    sentencia.setInt(2, idRegistre);


                return sentencia.executeUpdate();
            }

        }

        public int eliminar(int idRegistre)throws SQLException{

            try(
                    Connection conexion = Conexion.getConnection();
                    PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE);
                    )
            {
                sentencia.setInt(1, idRegistre);

                return sentencia.executeUpdate();
            }
        }
}
