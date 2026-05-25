package br.com.fiap.entities;

public class Gerente extends Pessoa{

    private String departamento;

    public Gerente() {
    }

    public Gerente(String departamento) {
        this.departamento = departamento;
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
    public String toString() {
        return "\n\nInformações do Gerente" +
                "\n\nDepartamento: " + departamento
                + getCargo();
    }

    public String getCargo() {
        return "GERENTE";
    }
}
