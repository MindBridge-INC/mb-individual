package CapturaDados;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import com.github.britooo.looca.api.util.Conversor;
import infoHardware.infoHardware;
import infoHardware.infoHardwareDAO;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
    /**
     *
     * @author Matheus
     */
    public class Captura extends javax.swing.JFrame{
        public static final long TEMPO = (5000);
        static Timer timer = null;
        public void capturaDados() {
            JOptionPane.showMessageDialog(rootPane, "Iniciando a captura de dados em segundo plano...");
            infoHardware capturaPC = new infoHardware();
            /*Inicio Looca para captura de dados*/
            Looca looca = new Looca();
            Long sistema = looca.getSistema().getTempoDeAtividade();
            int dispositivoUsb = looca.getDispositivosUsbGrupo().getDispositivosUsbConectados().size();
            Long memoria = looca.getMemoria().getDisponivel();
            Double temperatura = looca.getTemperatura().getTemperatura();


            capturaPC.setTempoAtividade(sistema);
            capturaPC.setUsbConectados(dispositivoUsb);
            capturaPC.setMemDisponivel(memoria);
            capturaPC.setTemperatura(temperatura);

            if (timer == null) {
                timer = new Timer();
                TimerTask tarefa = new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            infoHardwareDAO.cadastrarComputador(capturaPC);
                            System.out.println("\n*----------------------------------------------------------*");
                            System.out.println("Tempo de atividade: " + sistema);
                            System.out.println("UBS's conectados: " + dispositivoUsb);
                            System.out.println("Memoria disponível: " + Conversor.formatarBytes(memoria));
                            System.out.println("Temperatura: " + temperatura);
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