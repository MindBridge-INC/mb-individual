package Capturas;

import Conexao.Conexao;
import com.github.britooo.looca.api.util.Conversor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CapturasDAO {
    public static Boolean cadastarMaquina(Registros registros){
        String sql = "INSERT INTO registros (usoCpu, usoMemoria, usoDiscos) VALUES(?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setDouble(1, registros.getUsoCpu());
            ps.setString(2, Conversor.formatarBytes(registros.getUsoMemoria()));
            ps.setString(3, Conversor.formatarBytes(registros.getUsoDisco()));

            ps.execute();
        } catch (
                SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        return  false;
    }
}
