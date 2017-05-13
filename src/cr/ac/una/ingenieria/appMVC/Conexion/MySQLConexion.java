package cr.ac.una.ingenieria.appMVC.Conexion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class MySQLConexion {
    
    private Connection con;
    private String usuario;
    private String password;
    private String server;
    private String baseDatos;
    private String puerto;

    /**
     *
     * @param usuario
     * @param password
     * @param server
     * @param baseDatos
     * @param puerto
     */
    public MySQLConexion(String usuario, String password, String server,
            String baseDatos, String puerto) {
        this.usuario = usuario;
        this.password = password;
        this.server = server;
        this.baseDatos = baseDatos;
        this.puerto = puerto;
    }

    /**
     * conexion con la base de datos
     */
    public MySQLConexion() {
        String line;
        Integer con = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader("config.txt"));
            while ((line = in.readLine()) != null) {
                switch (con) {
                    case 0:
                        this.usuario = line;
                    case 1:
                        this.password = line;
                    case 2:
                        this.server = line;
                    case 3:
                        this.baseDatos = line;
                    case 4:
                        this.puerto = line;
                }
                con++;
            }
            in.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo de configuracion", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, "No se puede leer el archivo de configuracion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String stringConexion = "jdbc:MySql://" + server + ":" + puerto + "/" + baseDatos;
            con = DriverManager.getConnection(stringConexion, usuario, password);
            return con;
            
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
    }

    /**
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        con.close();
    }

    /**
     *
     * @return
     */
    public Connection getCon() {
        return con;
    }

    /**
     *
     * @param con
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getServer() {
        return server;
    }

    /**
     *
     * @param server
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     *
     * @return
     */
    public String getBaseDatos() {
        return baseDatos;
    }

    /**
     *
     * @param baseDatos
     */
    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    /**
     *
     * @return
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     *
     * @param puerto
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     *
     * @param @return
     */
    public CallableStatement prepareCall(String select_MAXPK_idFacturacion_from_Facturaci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
