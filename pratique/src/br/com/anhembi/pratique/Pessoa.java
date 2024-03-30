package br.com.anhembi.pratique;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pessoa implements Comparable <Pessoa>{
    private String nome;
    private int idade;
    private String telefone;
    private String email;
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public Pessoa (){

    }

    public Pessoa(String nome, int idade, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void CadastroUsuario(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite Um Nome: ");
        String nome = scan.next();

        System.out.println("Digite a Idade: ");
        int idade = scan.nextInt();

        System.out.println("Digite Um Telefone: ");
        String telefone = scan.next();

        System.out.println("Digite Um E-mail: ");
        String email = scan.next();

        //criando um objeto e adicionando na lista
        Pessoa pessoa = new Pessoa(nome, idade, telefone, email);
        listaPessoas.add(pessoa);

        System.out.println("Usuario Cadastrado Com Sucesso!");
    }

    public void ConsultaUsuario(){
        System.out.println("Usuarios Cadastrados:");
        System.out.println("********************************\n");
        Collections.sort(listaPessoas);

        for (Pessoa p : listaPessoas) {
            System.out.println(p.toString());
        }
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return nome.compareTo(outraPessoa.nome);
    }

    @Override
    public String toString() {
        return String.format("""
                Nome: %s
                Idade: %d
                Telefone %s
                E-mail: %s \n""", nome, idade, telefone, email);
    }
}

