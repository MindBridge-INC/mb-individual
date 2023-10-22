package infoHardware;
import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class infoHardwareDAO {
    public static boolean cadastrarComputador(infoHardware capturaPC) {
        String sql = "INSERT INTO infoHardware (TempoAtividade, UsbConectados, MemDisponivel, Temperatura) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setLong(1, capturaPC.getTempoAtividade());
            ps.setObject(2, capturaPC.getUsbConectados());
            ps.setLong(3, capturaPC.getMemDisponivel());
            ps.setDouble(4,capturaPC.getTemperatura());
            ps.execute();
        } catch (
                SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        return false;
    }
}
