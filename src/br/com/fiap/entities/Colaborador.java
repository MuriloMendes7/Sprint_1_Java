package br.com.fiap.entities;

public class Colaborador extends Pessoa{

    private String areaAtuacao;

    public Colaborador() {
    }

    public Colaborador(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public Colaborador(int id, String nome, String email, String areaAtuacao) {
        super(id, nome, email);
        this.areaAtuacao = areaAtuacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public String toString() {
        return "\n\nColaborador" +
                "\n\nÁrea de atuação: " + areaAtuacao + getCargo();
    }

    public String getCargo() {
        
        return "COLABORADOR";
    };
}
