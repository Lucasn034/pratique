package br.com.anhembi.pratique;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Evento evento = new Evento();
        Pessoa pessoa = new Pessoa();

        //Eventos Registrados:
        Evento campeonatoFutebol = new Evento("Futebol Amistoso", "Parque Vila-Lobos", "30/03/2024", "14:00", "Sports", "Futebol Amistoso para Arrecadar Alimentos que Serão Destinados a Familias que Foram Afetadas pela Chuva", "Ativo");
        evento.getListaEventos().add(campeonatoFutebol);

        Evento trioEletrico = new Evento("Trio Elétrico", "Avenida Paulista", "24/02/2024", "10:00", "Shows", "Venha Fazer Parte do Nosso Bloco de Carnaval", "Encerrado");
        evento.getListaEventos().add(trioEletrico);

        Evento festaDaFruta = new Evento("Festa Do Sorvete", "Água Branca", "15/05/2024", "9:00", "Festa", "Experimente os Mais Diversos Sabores", "Em Preparação");
        evento.getListaEventos().add(festaDaFruta);

        //Pessoas Cadastradas:
        Pessoa lucas = new Pessoa("Lucas", 28, "(11) 9 3322-3322", "lucas@email.com");
        pessoa.getListaPessoas().add(lucas);

        Pessoa joao = new Pessoa("João", 36, "(12) 9 2244-2244", "joao@email.com");
        pessoa.getListaPessoas().add(joao);

        Pessoa maria = new Pessoa("Maria", 26, "(11) 9 5522-5522", "maria@email.com");
        pessoa.getListaPessoas().add(maria);

        //Eventos Preferidos:
        Evento eventoPreferido1 = trioEletrico;
        evento.getListaEventosParticipando().add(eventoPreferido1);

        Scanner scan = new Scanner(System.in);
        int opcaoMenu = 5;

        while (opcaoMenu != 0) {

            System.out.println("""
                    ********************************
                    Bem-Vindo Ao Sistema De Entregas\n
                    Selecione Uma Das Opções Abaixo\n
                    1- Cadastro & Consulta - Usuario
                    ________________________________
                    2- Cadastro & Consulta - Eventos
                    ________________________________
                    3- Seus Eventos Ativos
                    ________________________________
                    0- Sair Do Sistema
                    ********************************
                    """);

            opcaoMenu = scan.nextInt();

            if (opcaoMenu == 1) {
                System.out.println("\nMenu Usuário");
                System.out.println("********************************");
                System.out.println("\nDigite 1 Cadastro, 2 Consulta, 0 Voltar");

                int menuUsuario = scan.nextInt();

                while (menuUsuario != 0) {

                    if (menuUsuario == 1) {
                        pessoa.CadastroUsuario();
                        System.out.println("Digite 1 Cadastro, 2 Consulta, 0 Voltar");
                        menuUsuario = scan.nextInt();

                    } else if (menuUsuario == 2) {
                        pessoa.ConsultaUsuario();
                        System.out.println("Digite 1 Cadastro, 2 Consulta, 0 Voltar");
                        menuUsuario = scan.nextInt();

                    } else {
                        System.out.println("Opção Inválida!");
                        System.out.println("Digite 1 Cadastro, 2 Consulta, 0 Voltar");
                        menuUsuario = scan.nextInt();
                    }
                }

            } else if (opcaoMenu == 2) {
                System.out.println("\nMenu Eventos");
                System.out.println("********************************");
                System.out.println("\nDigite 1 Cadastro, 2 Consulta, 3 Inscrição, 0 Voltar");

                int menuEventos = scan.nextInt();

                while (menuEventos != 0) {

                    if (menuEventos == 1) {
                        evento.CadastroEvento();
                        System.out.println("\nDigite 1 Cadastro, 2 Consulta, 3 Inscrição, 0 Voltar");
                        menuEventos = scan.nextInt();

                    } else if (menuEventos == 2) {
                        evento.ConsultaEvento();
                        System.out.println("\nDigite 1 Cadastro, 2 Consulta, 3 Inscrição, 0 Voltar");
                        menuEventos = scan.nextInt();

                    } else if (menuEventos == 3) {
                        evento.CadastroEventoPreferido();
                        System.out.println("\nDigite 1 Cadastro, 2 Consulta, 3 Inscrição, 0 Voltar");
                        menuEventos = scan.nextInt();

                    } else {
                        System.out.println("Opção Inválida!");
                        System.out.println("\nDigite 1 Cadastro, 2 Consulta, 3 Inscrição, 0 Voltar");
                        menuEventos = scan.nextInt();
                    }
                }

            } else if (opcaoMenu == 3) {
                System.out.println("Seus Eventos Ativos");
                System.out.println("********************************");
                evento.ConsultarEventoPreferido();

                System.out.println("Digite 1 Para Cancelar Um Evento Ou 0 Para Sair");
                int menuEventosParticipando = scan.nextInt();

                while (menuEventosParticipando != 0) {
                    if (menuEventosParticipando == 1) {
                        evento.CancelarEventoPreferido();

                        System.out.println("Digite 1 Para Cancelar Um Evento Ou 0 Para Sair");
                        menuEventosParticipando = scan.nextInt();

                    } else {
                        System.out.println("Opção Inválida");
                        System.out.println("Digite 1 Para Cancelar Um Evento Ou 0 Para Sair");
                        menuEventosParticipando = scan.nextInt();
                    }
                }

            } else if (opcaoMenu == 0) {
                System.out.println("Obrigado por Utilizar o Sistema, até a proxima :)!");

            } else {
                System.out.println("Opção Inválida\n");
            }
        }
    }
}






