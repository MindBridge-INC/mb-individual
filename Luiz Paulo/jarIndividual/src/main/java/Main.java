import Capturas.CapturasDAO;
import Capturas.Registros;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static final long TEMPO = (5000);
    static Timer timer = null;
    public static void main(String[] args) {

        /* Passo a passo para utilizar o looca API:
    1° O looca disponibiliza os recursos do computador como se fossem "classes" centro de cada objeto
    2° Para acessar os dados mais especificos do looca, primeiro deve-se criar as instancias desses objeto
            Processador processador = looca.getProcessador;
    com isso, estamos dizendo para o programa que o objeto processador está recendo os atributos vindos do
    getProcessador.
    3° Agora precisamos dizer para o programa, qual atributo queremos dentro do recurso processador.
            processador.getFabricante();
        **Atenção!! É preciso importar o recurso antes de utilizá-lo. Aoerte o tab após escrever o objeto ou
         aperte a lampada vermelha e realize a importação.]

        * */
        //instancia do looca
        Looca looca = new Looca();
        //instancia da maquina Lembre-se do construtor!
        /*
         quais atributos pertencem a máquina?
         */

        //instancia do objeto Processador
        Processador processador = looca.getProcessador();
        //instancia do objeto Memoria
        Memoria memoria = looca.getMemoria();
        //instancia do objeto GrupoDiscos
        DiscoGrupo discoGrupo = looca.getGrupoDeDiscos();
        //instancia do objeto Sistema
        Sistema sistema = looca.getSistema();

        sistema.getSistemaOperacional();
        processador.getFabricante();
        processador.getMicroarquitetura();
        processador.getFrequencia();
        memoria.getTotal();
        discoGrupo.getQuantidadeDeDiscos();
        Disco disco = discoGrupo.getDiscos().get(0);


        Maquina maquina = new Maquina(sistema.getSistemaOperacional(),
                processador.getFabricante(),
                processador.getMicroarquitetura(),
                processador.getFrequencia(),
                memoria.getTotal(),
                discoGrupo.getQuantidadeDeDiscos()
        );

        //Craindo a instancia da classe de registros.
        /* porque não passar os registros no construtor, como na classe máquina?
        porque esses registros são dinamicos, mudam sempre
         */

        Registros registros = new Registros();

        Double usoCpu = processador.getUso();
        Long usoMemoria = memoria.getEmUso();
        Long usoDisco = disco.getTamanho();

        registros.setUsoCpu(usoCpu);
        registros.setUsoMemoria(usoMemoria);
        registros.setUsoDisco(usoDisco);

       if(timer == null){
           timer = new Timer();
           TimerTask tarefa = new TimerTask() {
               @Override
               public void run() {
                   try{
                       CapturasDAO.cadastarMaquina(registros);
                       System.out.println();
                       System.out.println("Uso processador: " + processador.getUso());
                       System.out.println("Memória RAM em uso: " + Conversor.formatarBytes(usoMemoria));
                       System.out.println("Quantidade de discos: " + Conversor.formatarBytes(usoDisco));
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
           };
           timer.scheduleAtFixedRate(tarefa, TEMPO,TEMPO);
       }
    }

}
