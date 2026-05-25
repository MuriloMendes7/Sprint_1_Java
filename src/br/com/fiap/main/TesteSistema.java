package br.com.fiap.main;

import br.com.fiap.entities.Pessoa;
import br.com.fiap.entities.Gerente;
import br.com.fiap.entities.Colaborador;
import javax.swing.JOptionPane;

public class TesteSistema {

    public static String texto(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static int inteiro(String mensagem) {
        String valorDigitado = JOptionPane.showInputDialog(mensagem);
        return Integer.parseInt(valorDigitado);
    }

    public static boolean confirmarPresenca(String nomeParticipante) {
        int resposta = JOptionPane.showConfirmDialog(null,
                "O participante " + nomeParticipante + " entrou na chamada do Meet?",
                "Controle de Chamada - TOTVS",
                JOptionPane.YES_NO_OPTION);

        return resposta == JOptionPane.YES_OPTION;
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "=== CADASTRO DE PARTICIPANTES DA REUNIÃO ===");

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

        boolean presente = confirmarPresenca(participante.getNome());

        if (!presente) {
            System.out.println("========================================================================");
            System.out.println("[ALERTA] Reunião cancelada ou interrompida por ausência do participante.");
            System.out.println("========================================================================");
            JOptionPane.showMessageDialog(null, "Processo cancelado. O participante não estava presente.");
            return;
        }

        String diaAtual = texto("Digite o dia da semana atual da reunião (Ex: Sexta-feira):");

        // Texto bruto simulado da conversa da reunião
        String conversaBruta = "Bom dia a todos os presentes. Na nossa reunião de hoje com a equipe da TOTVS, " +
                "nós conseguimos alinhar perfeitamente que o prazo final do nosso entregável principal do " +
                "Challenge ficou definido para o próximo mês. É um cronograma apertado, então precisamos de foco total. " +
                "O Murilo Marques, que está aqui na chamada como nosso desenvolvedor, ficou oficialmente responsável " +
                "por subir toda a arquitetura estrutural do banco de dados local SQLite e validar as tabelas até a " +
                "próxima sexta-feira. Alguém tem alguma dúvida sobre a divisão das tarefas?";

        // --- IMPRESSÃO DOS RESULTADOS NO CONSOLE ---

        // 1. Dados do Participante Cadastrado
        System.out.println("========================================================================");
        System.out.println("[CADASTRO] Dados do Participante Identificado:");
        System.out.println("========================================================================");
        System.out.println(participante);
        System.out.println("========================================================================\n");

        // 2. Transcrição do Áudio Bruto
        System.out.println("========================================================================");
        System.out.println("[STATUS] Iniciando Transcrição da Reunião de Alinhamento (Meet/TOTVS)");
        System.out.println("========================================================================\n");
        System.out.println("\"" + conversaBruta + "\"\n");

        // 3. Relatório com Métodos de Negócio Dinâmicos
        System.out.println("========================================================================");
        System.out.println("[FILTRO] Relatório Estruturado da Reunião");
        System.out.println("========================================================================");
        System.out.println("Título do Evento: Alinhamento Sprint 2 - Challenge TOTVS");
        System.out.println("Data de Registro : 25/05/2026");

        if (participante.verificarDisponibilidade(diaAtual)) {
            System.out.println("Status da Agenda : PARTICIPANTE CONFIRMADO E DISPONÍVEL");
        } else {
            System.out.println("Status da Agenda : ATENÇÃO! Conflito de agenda identificado para este cargo às " + diaAtual + "s.");
        }

        System.out.println("\n[AÇÃO DETECTADA DINAMICAMENTE]");
        System.out.println("• Nome do Responsável: " + participante.getNome());
        System.out.println("• Papel no Sistema   : " + participante.getCargo());
        // Execução polimórfica do Método 4 (analisa o texto da conversa)
        System.out.println("• Tarefa Mapeada     : " + participante.gerarAcaoObrigatoria(conversaBruta));

        // 4. Campo de Palavras-Chave
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("[TAGS] Palavras-Chave Extraídas do Contexto");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("> TOTVS, Challenge, Cronograma, Banco de Dados, SQLite, Alinhamento");
        System.out.println("------------------------------------------------------------------------");

        JOptionPane.showMessageDialog(null, "Processo concluído! Verifique o console para ler o relatório.");
    }
}