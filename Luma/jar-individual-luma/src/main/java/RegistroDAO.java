import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroDAO {
     public static boolean registrarHardware(RegistroMaquina registros) {
         String sql = "INSERT INTO registroMaquina (usoRam, usoProcessador, totalDisco, dispositivosUSB) VALUES (?, ?, ?, ?)";
         PreparedStatement ps = null;
         try {
             ps = Conexao.getConexao().prepareStatement(sql);
             ps.setDouble(1, registros.getUsoRam()/Math.pow(1024,3));
             ps.setDouble(2, registros.getUsoProcessador());
/*             ps.setDouble(3,registros.getTemperatura());*/
             ps.setDouble(3, registros.getUsoDisco()/Math.pow(1024,3));
             ps.setInt(4, registros.getDispositivosUSB());
             ps.execute();
        } catch (SQLException ex) {
             System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
         }
         return false;
     }
 }


