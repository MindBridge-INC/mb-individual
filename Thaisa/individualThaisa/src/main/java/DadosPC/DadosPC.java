package DadosPC;
public class DadosPC {
    private Long MemoriaEmUso;
    private Long FrequenciaProcessador;
    private Double UsoProcessador;
    private Long Tamanho;

    public Long getMemoriaEmUso() {
        return MemoriaEmUso;
    }

    public void setMemoriaEmUso(Long memoriaEmUso) {
        MemoriaEmUso = memoriaEmUso;
    }

    public Long getFrequenciaProcessador() {
        return FrequenciaProcessador;
    }

    public void setFrequenciaProcessador(Long frequenciaProcessador) {
        FrequenciaProcessador = frequenciaProcessador;
    }

    public Double getUsoProcessador() {
        return UsoProcessador;
    }

    public void setUsoProcessador(Double usoProcessador) {
        UsoProcessador = usoProcessador;
    }

    public Long getTamanho() {
        return Tamanho;
    }

    public void setTamanho(Long tamanho) {
        Tamanho = tamanho;
    }
}
