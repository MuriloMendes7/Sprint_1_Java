package br.com.fiap.entities;

public class Colaborador extends Pessoa {

    private String areaAtuacao;

    public Colaborador() {
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
    public String getCargo() {
        return "COLABORADOR / DESENVOLVEDOR";
    }

    @Override
    public boolean verificarDisponibilidade(String diaSemana) {
        return true;
    }

    public int calcularHorasDedicacao() {
        return 40;
    }

    // IMPLEMENTAÇÃO DO MÉTODO 4: Regra para verificar se o colaborador foi citado
    @Override
    public String gerarAcaoObrigatoria(String textoConversa) {
        if (textoConversa.contains(this.nome) || textoConversa.contains("Murilo")) {
            return "Desenvolver a arquitetura do banco de dados local SQLite conforme delegado.";
        }
        return "Executar tarefas técnicas pendentes no backlog.";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCargo: " + getCargo() +
                "\nÁrea de Atuação: " + areaAtuacao +
                "\nHoras Dedicadas ao Challenge: " + calcularHorasDedicacao() + "h semanais";
    }
}