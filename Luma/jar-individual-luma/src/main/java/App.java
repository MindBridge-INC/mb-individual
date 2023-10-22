import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.sql.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class App {

    public static final long TEMPO = (5000);
    static Timer timer = null;

    public static void main(String[] args) throws SQLException {

        RegistroMaquina registro = new RegistroMaquina();
        Looca looca = new Looca();
        Scanner leitor = new Scanner(System.in);

        // Instanciando objetos do Looca
        Sistema sistema = looca.getSistema();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Rede rede = looca.getRede();
        DiscoGrupo disco = looca.getGrupoDeDiscos();
        Temperatura temp = looca.getTemperatura();
        DispositivosUsbGrupo dispositivoUsb = looca.getDispositivosUsbGrupo();

        String sistemaOperacional = sistema.getSistemaOperacional();
        String fabricante = sistema.getFabricante();
        Long tempoAtividadeDias = (((sistema.getTempoDeAtividade()/60)/60)/24);
        String nomeHost = rede.getParametros().getHostName();

        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                @Override
                public void run() {
                    try {
                        Long memoriaUsada = memoria.getEmUso();
                        Double procUsado = processador.getUso();
                        /*Double temperatura = temp.getTemperatura();*/
                        Long tamanhoArmazenamento = disco.getTamanhoTotal();
                        Integer usbConectado = dispositivoUsb.getTotalDispositvosUsbConectados();

                        registro.setUsoRam(memoriaUsada);
                        registro.setUsoProcessador(procUsado);
                        /*registro.setTemperatura(temperatura);*/
                        registro.setUsoDisco(tamanhoArmazenamento);
                        registro.setDispositivosUSB(usbConectado);

                        RegistroDAO.registrarHardware(registro);

                        /*System.out.println("++++++++++++++++++++++++++++++++");
                        System.out.println("Uso da memória: " + Conversor.formatarBytes(memoriaUsada));
                        System.out.println("Uso do processador: %.2f %%".formatted(procUsado));
                        System.out.println("Temperatura do processador: " + temperatura);
                        System.out.println("Armazenamento total: " + Conversor.formatarBytes(tamanhoArmazenamento));
                        System.out.println("Dispositivos USB conectados: " + usbConectado);*/

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }

        Boolean painel = false;

        while (!painel) {
            System.out.println("Painel PayAttention");
            System.out.println("""
                        1 - Visualizar registros
                        2 - Visualizar informações do sistema
                        """);
            Integer opcao = leitor.nextInt();

            switch (opcao) {
                case 1 -> {
                    ResultSet rsClient = Conexao.getConexao().createStatement().executeQuery("SELECT * FROM registroMaquina");
                    while (rsClient.next()) {
                        System.out.print("id: " + rsClient.getString("idRegistroMaquina"));
                        System.out.print(" || usoRam: %.2f GB".formatted(rsClient.getFloat("usoRam")));
                        System.out.print(" || usoProcessador: %.2f %%".formatted(rsClient.getFloat("usoProcessador")));
                        System.out.print(" || tempProc: " + rsClient.getFloat("tempProc"));
                        System.out.print(" || totalDisco: %.2f GB".formatted(rsClient.getFloat("totalDisco")));
                        System.out.print(" || dispositivosUSB: " + rsClient.getInt("dispositivosUSB"));
                        System.out.println(" || dtHora: " + rsClient.getTimestamp("dtHora"));
                    }
                }
                case 2 -> {
                    System.out.println("Sistema operacional: " + sistemaOperacional);
                    System.out.println("Fabricante: " + fabricante);
                    System.out.println("Tempo de atividade do sistema: " + tempoAtividadeDias + " dias");
                    System.out.println("Nome do host: " + nomeHost);
                    System.out.println(" ");
                }

                default -> {
                    System.out.println("Opção inválida");
                }
            }
        }
    }
}