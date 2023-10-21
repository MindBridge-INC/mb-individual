package Registro;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class Teste {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();
        Processador processador = looca.getProcessador();
        DispositivosUsbGrupo dispositivosUsbGrupo = looca.getDispositivosUsbGrupo();


      String so = sistema.getSistemaOperacional();
      Double proces = processador.getUso();
      Integer dispoUSB = dispositivosUsbGrupo.getTotalDispositvosUsb();
      PCRegistro pcRegistro = new PCRegistro();
      pcRegistro.setUsoProcessador(proces);
      pcRegistro.setDispositivosUSB(dispoUSB);
      InsertBanco.cadastrarComputador(pcRegistro);

        System.out.println(so);
        System.out.println("Processo" + proces );
        System.out.println("Dispositivos USB" + dispoUSB);

    }
}
