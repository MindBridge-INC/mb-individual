public class RegistroMaquina {

    private Long usoRam;
    private Double usoProcessador;
    private Long usoDisco;
    private Integer dispositivosUSB;
    private Double Temperatura;

    public Long getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(Long usoRam) {
        this.usoRam = usoRam;
    }

    public Double getUsoProcessador() {
        return usoProcessador;
    }

    public void setUsoProcessador(Double usoProcessador) {
        this.usoProcessador = usoProcessador;
    }

    public Long getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Long usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Integer getDispositivosUSB() {
        return dispositivosUSB;
    }

    public void setDispositivosUSB(Integer dispositivosUSB) {
        this.dispositivosUSB = dispositivosUSB;
    }

    public Double getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(Double temperatura) {
        Temperatura = temperatura;
    }
}
