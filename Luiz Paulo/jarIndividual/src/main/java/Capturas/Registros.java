package Capturas;

public class Registros {
    /* Na classe máquina mapeamos o que o computador possui, ótimo!
    Agora devemos ter uma classe que represente os registros dinamicos desses recursos, afinal,
    é o foco desse projeto.
     */

    private Double usoCpu;
    private Long usoMemoria;
    private Long usoDisco;

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Long getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Long usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Long getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Long usoDisco) {
        this.usoDisco = usoDisco;
    }
}
