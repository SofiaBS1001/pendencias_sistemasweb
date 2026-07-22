/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import java.util.Scanner;

/**
 *
 * @author 1071759
 */
public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);
    private Musica[] todasAsMusicas = new Musica[10];
    private int quantidadeMusicas = 0;
    private Playlist[] minhasPlaylists = new Playlist[10];
    private int quantidadePlaylists = 0;

    public void rodar() {

        int op;

        do {
            menu();
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    criarMusica();
                    break;
                case 2:
                    editarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorID();
                    break;
                case 5:
                    removerMusica();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (op != 0);

    }

    public void menu() {
        System.out.println("------ Menu de Operacoes ------");
        System.out.println("1 - Criar musica");
        System.out.println("2 - Editar musica");
        System.out.println("3 - Listar musicas");
        System.out.println("4 - Buscar musica");
        System.out.println("5 - Remover musica");
        System.out.println("0 - Sair");
    }

    private void criarMusica() {
        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());

        if (quantidadeMusicas == todasAsMusicas.length) {
            aumentarCapacidadeMusicas();
        }

        Musica musica = new Musica(titulo, compositor, interprete, duracao);
        todasAsMusicas[quantidadeMusicas] = musica;
        quantidadeMusicas++;
    }

    private void editarMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        for (int i = 0; i < this.quantidadeMusicas; i++) {
            System.out.println("[" + i + "] " + this.todasAsMusicas[i].getTitulo() + "(intérprete: " + this.todasAsMusicas[i].getInterprete() + ")");
        }

        System.out.println("Informe qual é o ID da música que você deseja editar: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 0 || id >= quantidadeMusicas) {
            System.out.println("ID inválido.");
            return;
        }

        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        this.todasAsMusicas[id].setTitulo(titulo);
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        this.todasAsMusicas[id].setCompositor(compositor);
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        this.todasAsMusicas[id].setInterprete(interprete);
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());
        this.todasAsMusicas[id].setDuracao(duracao);

        System.out.println("Musica editada com sucesso.");
    }

    private void listarMusicas() {
        for (int i = 0; i < this.quantidadeMusicas; i++) {
            System.out.println(this.todasAsMusicas[i].getTitulo() + "(intérprete: " + this.todasAsMusicas[i].getInterprete() + ")");
        }
    }

    private void buscarMusicaPorID() {
        System.out.println("Informe qual é o ID da música que você deseja buscar: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 0 || id >= quantidadeMusicas) {
            System.out.println("ID inválido.");
            return;
        }

        System.out.println("Título: " + this.todasAsMusicas[id].getTitulo());
        System.out.println("Compositor: " + this.todasAsMusicas[id].getCompositor());
        System.out.println("Interprete: " + this.todasAsMusicas[id].getInterprete());
        System.out.println("Duracao: " + this.todasAsMusicas[id].getDuracao());
    }

    private void removerMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        for (int i = 0; i < this.quantidadeMusicas; i++) {
            System.out.println("[" + i + "] " + this.todasAsMusicas[i].getTitulo() + "(intérprete: " + this.todasAsMusicas[i].getInterprete() + ")");
        }

        System.out.println("Informe qual é o ID da música que você deseja remover: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 0 || id >= quantidadeMusicas) {
            System.out.println("ID inválido.");
            return;
        }

        for (int i = id; i < quantidadeMusicas - 1; i++) {
            todasAsMusicas[i] = todasAsMusicas[i + 1];
        }

        todasAsMusicas[quantidadeMusicas - 1] = null;
        quantidadeMusicas--;
    }

    private void aumentarCapacidadeMusicas() {
        Musica[] novoVetor = new Musica[todasAsMusicas.length + 5];
        System.arraycopy(todasAsMusicas, 0, novoVetor, 0, todasAsMusicas.length);
        todasAsMusicas = novoVetor;
    }
}
