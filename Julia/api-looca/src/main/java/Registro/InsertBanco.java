package Registro;

import Conexao.Conexao;
import com.github.britooo.looca.api.util.Conversor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertBanco {
    public static boolean cadastrarComputador(PCRegistro pcRegistro) {
        String sql = "INSERT INTO registroMaquina (usoProcessador, dispositivosUSB) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setDouble(1, pcRegistro.getUsoProcessador());
            ps.setInt(2, pcRegistro.getDispositivosUSB());
            ps.execute();
        } catch (
                SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        return false;
    }

}
