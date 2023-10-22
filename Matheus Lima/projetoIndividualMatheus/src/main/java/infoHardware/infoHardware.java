package infoHardware;

public class infoHardware {
    private Long TempoAtividade;
    private int UsbConectados;
    private Long MemDisponivel;
    private Double Temperatura;

    public Long getTempoAtividade() {
        return TempoAtividade;
    }

    public void setTempoAtividade(Long tempoAtividade) {
        TempoAtividade = tempoAtividade;
    }

    public Integer getUsbConectados() {
        return UsbConectados;
    }

    public void setUsbConectados(int usbConectados) {
        UsbConectados = usbConectados;
    }

    public Long getMemDisponivel() {
        return MemDisponivel;
    }

    public void setMemDisponivel(Long memDisponivel) {
        MemDisponivel = memDisponivel;
    }

    public Double getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(Double temperatura) {
        Temperatura = temperatura;
    }

}
