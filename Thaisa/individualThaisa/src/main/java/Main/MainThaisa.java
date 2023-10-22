package Main;
import CapturaDadosPC.CapturaDadosPC;
import javax.swing.*;


public class MainThaisa {
    public static void main(String[] args) {
        Integer opcao = null;
        String entrada;
        CapturaDadosPC capturaDadosPC = new CapturaDadosPC();
        entrada = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                "1 - Iniciar a captura de dados.\n" +
                "2 - Sair.",opcao);
        if (entrada.equals("1"))
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Iniciando a captura de dados em segundo plano...");
        capturaDadosPC.exibeMenu();
        do {
            switch (entrada){
                case "1":
                    capturaDadosPC.capturaDadosPc();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while (entrada != "2");
    }
}
