public class Maquina {

    /* O que tem em um computador?
    O que convém que seja monitorado?
    Responder essas perguntas ajuda muito a agilizar na construção de seu projeto!
    Vamos criar uma classe que tenha alguns recuros que queremos manipular.
    * */
    private String sisOp;
    private String tipoProcessador;
    private String arquiteturaProcessador;
    private Long frequenciaCpu;
    private Long memoriaTotal;
    private Integer discosTotais;

    //criando o construtor dessa classe

    public Maquina(String sisOp,
                   String tipoProcessador,
                   String arquiteturaProcessador,
                   Long frequenciaCpu,
                   Long memoriaTotal,
                   Integer discosTotais) {
        this.sisOp = sisOp;
        this.tipoProcessador = tipoProcessador;
        this.arquiteturaProcessador = arquiteturaProcessador;
        this.frequenciaCpu = frequenciaCpu;
        this.memoriaTotal = memoriaTotal;
        this.discosTotais = discosTotais;
    }

    //criando os getters e setters da classe máquina.
    public String getSisOp() {
        return sisOp;
    }

    public void setSisOp(String sisOp) {
        this.sisOp = sisOp;
    }

    public String getTipoProcessador() {
        return tipoProcessador;
    }

    public void setTipoProcessador(String tipoProcessador) {
        this.tipoProcessador = tipoProcessador;
    }

    public String getArquiteturaProcessador() {
        return arquiteturaProcessador;
    }

    public void setArquiteturaProcessador(String arquiteturaProcessador) {
        this.arquiteturaProcessador = arquiteturaProcessador;
    }

    public Long getFrequenciaCpu() {
        return frequenciaCpu;
    }

    public void setFrequenciaCpu(Long frequenciaCpu) {
        this.frequenciaCpu = frequenciaCpu;
    }

    public Long getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(Long memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public Integer getDiscosTotais() {
        return discosTotais;
    }

    public void setDiscosTotais(Integer discosTotais) {
        this.discosTotais = discosTotais;
    }
}
