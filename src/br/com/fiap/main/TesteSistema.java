package br.com.fiap.main;

import br.com.fiap.entities.Pessoa;
import br.com.fiap.entities.Gerente;
import br.com.fiap.entities.Colaborador;
import javax.swing.JOptionPane;

public class TesteSistema {

    // Método estático que abre uma caixa de diálogo e retorna o texto digitado
    public static String texto(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    // Método estático que abre uma caixa de diálogo, converte e retorna um número inteiro
    public static int inteiro(String mensagem) {
        String valorDigitado = JOptionPane.showInputDialog(mensagem);
        return Integer.parseInt(valorDigitado);
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "=== CADASTRO DE PARTICIPANTES DA REUNIÃO ===");

        // Pede os dados utilizando as caixas de entrada gráficas do JOptionPane
        int id = inteiro("Digite o ID do participante:");
        String nome = texto("Digite o Nome do participante:");
        String email = texto("Digite o Email do participante:");

        String tipo = texto("Esta pessoa é (G)erente ou (C)olaboradora?").toUpperCase();

        Pessoa participante = null;

        if (tipo.equals("G")) {
            String departamento = texto("Digite o Departamento do Gerente:");
            participante = new Gerente(id, nome, email, departamento);
        } else if (tipo.equals("C")) {
            String areaAtuacao = texto("Digite a Área de Atuação do Colaborador:");
            participante = new Colaborador(id, nome, email, areaAtuacao);
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida! O sistema fechará.");
            return;
        }

        // --- IMPRESSÃO DOS RESULTADOS NO CONSOLE ---

        // 1. Informações da Pessoa Cadastrada (Polimorfismo puxando o toString correto)
        System.out.println("========================================================================");
        System.out.println("[CADASTRO] Dados do Participante Identificado:");
        System.out.println("========================================================================");
        System.out.println(participante);
        System.out.println("========================================================================\n");

        // 2. Transcrição do Áudio Bruto (A conversa completa)
        System.out.println("========================================================================");
        System.out.println("[STATUS] Iniciando Transcrição da Reunião de Alinhamento (Meet/TOTVS)");
        System.out.println("========================================================================\n");

        System.out.println("\"Bom dia a todos os presentes. Na nossa reunião de hoje com a equipe da TOTVS, " +
                "nós conseguimos alinhar perfeitamente que o prazo final do nosso entregável principal do " +
                "Challenge ficou definido para o próximo mês. É um cronograma apertado, então precisamos de foco total. " +
                "O Murilo Marques, que está aqui na chamada como nosso desenvolvedor, ficou oficialmente responsável " +
                "por subir toda a arquitetura estrutural do banco de dados local SQLite e validar as tabelas até a " +
                "próxima sexta-feira. Alguém tem alguma dúvida sobre a divisão das tarefas?\"\n");

        // 3. Filtro Estruturado e Palavras-Chave abaixo
        System.out.println("========================================================================");
        System.out.println("[FILTRO] Relatório Estruturado da Reunião");
        System.out.println("========================================================================");
        System.out.println("Título do Evento: Alinhamento Sprint 2 - Challenge TOTVS");
        System.out.println("Data de Registro : 25/05/2026\n");

        System.out.println("[AÇÃO DETECTADA]");
        System.out.println("• Nome do Responsável: " + participante.getNome());
        System.out.println("• Papel no Sistema   : " + participante.getCargo());
        System.out.println("• Tarefa Mapeada     : Modelar e subir a arquitetura do banco de dados local.");

        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("[TAGS] Palavras-Chave Extraídas do Contexto");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("> TOTVS, Challenge, Cronograma, Banco de Dados, SQLite, Alinhamento");
        System.out.println("------------------------------------------------------------------------");

        // Avisa na interface gráfica também que o processo terminou
        JOptionPane.showMessageDialog(null, "Processo concluído! Verifique o console para ver o relatório completo.");
    }
}