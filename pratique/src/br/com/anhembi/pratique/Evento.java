package br.com.anhembi.pratique;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Evento implements Comparable <Evento>{
    private String tituloEvento;
    private String endereco;
    private String data;
    private String horario;
    private String categoria;
    private String descricao;
    private String status;
    private ArrayList<Evento> listaEventos = new ArrayList<>();
    private ArrayList<Evento> listaEventosParticipando = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public Evento(){
    }

    public Evento(String tituloEvento, String endereco, String data, String horario, String categoria, String descricao, String status) {
        this.tituloEvento = tituloEvento;
        this.endereco = endereco;
        this.data = data;
        this.horario = horario;
        this.categoria = categoria;
        this.descricao = descricao;
        this.status = status;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public ArrayList<Evento> getListaEventosParticipando() {
        return listaEventosParticipando;
    }

    public void CadastroEvento(){
        System.out.println("Digite o Nome Do Evento: ");
        String tituloEvento = scan.next();

        System.out.println("Digite o Endereço Do Evento: ");
        String endereco = scan.next();

        System.out.println("Digite o Horário Do Evento: ");
        String horario = scan.next();

        System.out.println("Digite a Data Do Evento: ");
        String data = scan.next();

        System.out.println("Digite a Categoria Do Evento: ");
        String categoria = scan.next();

        System.out.println("Digite Uma Descrição Do Evento: ");
        String descricao = scan.next();

        System.out.println("Digite o Status Do Evento: ");
        String status = scan.next();

        //criando um objeto do tipo evento e adicionando na lista
        Evento evento = new Evento(tituloEvento, endereco, horario, data, categoria, descricao, status);
        listaEventos.add(evento);
    }

    public void ConsultaEvento(){
        System.out.println("Eventos Disponiveis: ");
        System.out.println("********************************\n");
        Collections.sort(listaEventos);

        for (Evento e : listaEventos) {
            System.out.println("Número Do Evento: " + listaEventos.indexOf(e));
            System.out.println(e.toString());
        }

    }

    public void CadastroEventoPreferido(){
        System.out.println("Eventos Disponiveis: ");
        System.out.println("********************************\n");
        Collections.sort(listaEventos);

        for (Evento e : listaEventos) {
            System.out.println("Numero Do Evento: " + listaEventos.indexOf(e));
            System.out.println(e.toString());
        }


        System.out.println("Digite o Número Do Evento Que Você Quer Adicionar: ");
        int numeroEventoAdicionar = scan.nextInt();

        listaEventosParticipando.add(listaEventos.get(numeroEventoAdicionar));
        listaEventos.remove(numeroEventoAdicionar);

        System.out.println("Você Se Inscreveu Ao Evento " + numeroEventoAdicionar + " Com Sucesso\n");

        System.out.println("Seus Eventos Ativos : ");

        Collections.sort(listaEventosParticipando);
        for (Evento e : listaEventosParticipando) {
            System.out.println("Numero Do Evento: " + listaEventosParticipando.indexOf(e));
            System.out.println(e.toString());
        }
    }

    public void CancelarEventoPreferido(){

        if (listaEventosParticipando.size() > 0) {
            System.out.println("Digite o Número Do Evento Que Deseja Cancelar: ");

            int numeroEventoCancelar = scan.nextInt();
            listaEventosParticipando.remove(listaEventosParticipando.get(numeroEventoCancelar));
            System.out.println("O Evento " + numeroEventoCancelar + " Foi removido Com Sucesso!\n");

        } else {
            System.out.println("Você Não Esta Participando De Nenhum Evento!");
        }
    }

    public void ConsultarEventoPreferido(){
        Collections.sort(listaEventosParticipando);

        for (Evento e : listaEventosParticipando) {
            System.out.println("Numero Do Evento: " + listaEventosParticipando.indexOf(e));
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString() {
        return String.format("""
                    Nome: %s
                    Endereço: %s
                    Data: %s
                    Horário: %s
                    Categoria: %s
                    Descrição: %s
                    Status: %s
                    """, tituloEvento, endereco, data, horario, categoria, descricao, status);
    }

    @Override
    public int compareTo(Evento outroEvento) {
        return status.compareTo(outroEvento.status);
    }
}
