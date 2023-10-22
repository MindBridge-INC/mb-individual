package CapturaDadosPC;
import DadosPC.DadosPC;
import DadosPC.DadosPCDAO;
import com.github.britooo.looca.api.core.Looca;
import java.util.Timer;
import java.util.TimerTask;
    public class CapturaDadosPC extends javax.swing.JFrame{
        public static final long TEMPO = (5000);
        static Timer timer = null;

        public void exibeMenu(){
            System.out.println("""
                    *------------------------------------------*
                    Escolha uma opção:
                    1 - Iniciar a captura de dados.
                    2 - Sair.
                    *------------------------------------------*
                    """);
        }
        public void capturaDadosPc() {
            DadosPC capturaDadosPC = new DadosPC();
            /*Inicio Looca para captura de dados*/
            Looca looca = new Looca();
            Long memoria = looca.getMemoria().getEmUso();
            Long frequenciaProcessador = looca.getProcessador().getFrequencia();
            Double usoProcessador = looca.getProcessador().getUso();
            Long tamanho = looca.getMemoria().getTotal();

            capturaDadosPC.setMemoriaEmUso(memoria);
            capturaDadosPC.setFrequenciaProcessador(frequenciaProcessador);
            capturaDadosPC.setUsoProcessador(usoProcessador);
            capturaDadosPC.setTamanho(tamanho);

            if (timer == null) {
                timer = new Timer();
                TimerTask tarefa = new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            DadosPCDAO.cadastrarComputador(capturaDadosPC);
                            System.out.println("\n*----------------------------------------------------------*");
                            System.out.println("Memória em uso: " + memoria);
                            System.out.println("Frequencia do processador: " + frequenciaProcessador);
                            System.out.println("Uso do processador: " + usoProcessador);
                            System.out.println("Tamanho memoria: " + tamanho);
                            System.out.println("*----------------------------------------------------------*");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
            }
        }
    }

