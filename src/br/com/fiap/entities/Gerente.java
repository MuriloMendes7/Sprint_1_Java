package br.com.fiap.entities;

public class Gerente extends Pessoa {

    private String departamento;

    public Gerente() {
    }

    public Gerente(int id, String nome, String email, String departamento) {
        super(id, nome, email);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String getCargo() {
        return "GERENTE DE PROJETOS";
    }

    @Override
    public boolean verificarDisponibilidade(String diaSemana) {
        return !diaSemana.equalsIgnoreCase("Sexta-feira");
    }

    public int calcularHorasDedicacao() {
        return 20;
    }

    // IMPLEMENTAÇÃO DO MÉTODO 4: Regra para o Gerente monitorar prazos
    @Override
    public String gerarAcaoObrigatoria(String textoConversa) {
        if (textoConversa.contains("prazo") || textoConversa.contains("cronograma")) {
            return "Cobrar entregáveis e garantir o cumprimento do cronograma mapeado.";
        }
        return "Alinhar metas gerais com o cliente.";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCargo: " + getCargo() +
                "\nDepartamento: " + departamento +
                "\nHoras Dedicadas ao Challenge: " + calcularHorasDedicacao() + "h semanais";
    }
}