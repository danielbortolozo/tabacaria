/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConnectionFactory {
    public Statement stmt; //prepara e realiza ma pesquisa no banco
    public ResultSet rs;
    public Connection conn;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/sysauto";
    private String usuario = "postgres";
    private String senha = "rocca23";
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/roupa", "postgres", "rocca23");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    
//    public void conectar() {
//
//        try {
//            System.setProperty("jdbc.Drivers", driver);
//            conn = DriverManager.getConnection(caminho, usuario, senha);
//            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao Conectar!\nErro: " + ex.getMessage());
//        }
//    }
    
    
    
    public void executaSQL(String sql) {
        try {
            stmt = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro no método executaSQL!\n Erro:" + ex.getMessage());
        }
    }
    
    
    
    
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }
}
