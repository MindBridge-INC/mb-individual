package DadosPC;
import Conexao.Conexao;
import com.github.britooo.looca.api.util.Conversor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DadosPCDAO {
    public static boolean cadastrarComputador(DadosPC capturaDados) {
        String sql = "INSERT INTO CapturaDeDados (MemoriaEmUso, FrequenciaProcessador, UsoProcessador, TamanhoMemoria) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, Conversor.formatarBytes(capturaDados.getMemoriaEmUso()));
            ps.setString(2, Conversor.formatarBytes(capturaDados.getFrequenciaProcessador()));
            ps.setDouble(3, capturaDados.getUsoProcessador());
            ps.setString(4, (Conversor.formatarBytes(capturaDados.getTamanho())));
            ps.execute();
        } catch (
                SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        return false;
    }
}
