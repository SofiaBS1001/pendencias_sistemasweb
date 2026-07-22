/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.Scanner;

/**
 *
 * @author 1071759
 */
public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);
    private Musica[] todasAsMusicas = new Musica[10];
    private int quantidadeMusicas = 0;
    private Usuario[] todosOsPerfis = new Usuario[10];
    private int quantidadePerfis = 0;
    private Usuario usuarioLogado;

    public void rodar() {
        int op;

        do {
            if (usuarioLogado == null) {
                menuDeLogin();
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        criarNovoUsuario();
                        break;
                    case 2:
                        usuarioLogado = autenticar();
                        if (usuarioLogado != null) {
                            System.out.println("Bem-vindo(a), " + usuarioLogado.getNome() + "!");
                        } else {
                            System.out.println("Usuário ou senha inválidos.");
                        }
                        break;
                    case 3:
                        listarMusicas();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else {
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
                    case 6:
                        criarPlaylist();
                        break;
                    case 7:
                        listarPlaylists();
                        break;
                    case 8:
                        adicionarMusicaAPlaylist();
                        break;
                    case 9:
                        removerPlaylist();
                        break;
                    case 0:
                        usuarioLogado = null;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
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
        System.out.println("6 - Criar playlist");
        System.out.println("7 - Listar playlists");
        System.out.println("8 - Adicionar musica a playlist");
        System.out.println("9 - Remover playlist");
        System.out.println("0 - Deslogar");
    }

    private void menuDeLogin() {
        System.out.println("------ Menu de Login ------");
        System.out.println("1 - Criar novo usuário");
        System.out.println("2 - Autenticar");
        System.out.println("3 - Listar músicas");
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
        Musica musica = new Musica(titulo, compositor, interprete, duracao);
        adicionarMusica(musica);
    }

    private void adicionarMusica(Musica musica) {
        if (quantidadeMusicas == todasAsMusicas.length) {
            Musica[] novoArray = new Musica[todasAsMusicas.length + 10];
            for (int i = 0; i < todasAsMusicas.length; i++) {
                novoArray[i] = todasAsMusicas[i];
            }
            todasAsMusicas = novoArray;
        }

        todasAsMusicas[quantidadeMusicas++] = musica;
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
        if (quantidadeMusicas == 0) {
            System.out.println("Nenhuma música cadastrada.");
            return;
        }

        for (int i = 0; i < this.quantidadeMusicas; i++) {
            System.out.println("[" + i + "] " + this.todasAsMusicas[i].getTitulo() + "(intérprete: " + this.todasAsMusicas[i].getInterprete() + ")");
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
        System.out.println("Música removida com sucesso.");
    }

    private void criarPlaylist() {
        if (usuarioLogado == null) {
            System.out.println("É necessário autenticar-se antes.");
            return;
        }

        System.out.println("Nome da playlist:");
        String nome = sc.nextLine();
        System.out.println("Descrição da playlist:");
        String descricao = sc.nextLine();

        if (usuarioLogado.existePlaylist(nome)) {
            System.out.println("Já existe uma playlist com esse nome.");
            return;
        }

        Playlist novaPlaylist = new Playlist(usuarioLogado, nome, descricao);
        usuarioLogado.adicionarPlaylist(novaPlaylist);
        System.out.println("Playlist criada com sucesso.");
    }

    private void listarPlaylists() {
        if (usuarioLogado == null) {
            System.out.println("É necessário autenticar-se antes.");
            return;
        }

        if (usuarioLogado.getQuantidadePlaylists() == 0) {
            System.out.println("Nenhuma playlist cadastrada.");
            return;
        }

        for (int i = 0; i < usuarioLogado.getQuantidadePlaylists(); i++) {
            Playlist playlist = usuarioLogado.getPlaylists()[i];
            System.out.println("[" + i + "] " + playlist.getNome() + " - " + playlist.getDescricao() + " (" + playlist.getQuantidadeMusicas() + " músicas)");
        }
    }

    private void adicionarMusicaAPlaylist() {
        if (usuarioLogado == null) {
            System.out.println("É necessário autenticar-se antes.");
            return;
        }

        if (quantidadeMusicas == 0) {
            System.out.println("Nenhuma música cadastrada para adicionar.");
            return;
        }

        if (usuarioLogado.getQuantidadePlaylists() == 0) {
            System.out.println("Nenhuma playlist cadastrada para receber a música.");
            return;
        }

        listarMusicas();
        System.out.println("Informe o índice da música:");
        int indiceMusica = Integer.parseInt(sc.nextLine());

        listarPlaylists();
        System.out.println("Informe o índice da playlist:");
        int indicePlaylist = Integer.parseInt(sc.nextLine());

        if (indiceMusica < 0 || indiceMusica >= quantidadeMusicas) {
            System.out.println("Índice de música inválido.");
            return;
        }

        if (indicePlaylist < 0 || indicePlaylist >= usuarioLogado.getQuantidadePlaylists()) {
            System.out.println("Índice de playlist inválido.");
            return;
        }

        Playlist playlist = usuarioLogado.getPlaylists()[indicePlaylist];
        playlist.adicionarMusica(todasAsMusicas[indiceMusica]);
        System.out.println("Música adicionada à playlist com sucesso.");
    }

    private void removerPlaylist() {
        if (usuarioLogado == null) {
            System.out.println("É necessário autenticar-se antes.");
            return;
        }

        listarPlaylists();
        System.out.println("Informe o índice da playlist que você deseja remover:");
        int indice = Integer.parseInt(sc.nextLine());

        if (usuarioLogado.removerPlaylist(indice)) {
            System.out.println("Playlist removida com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void criarNovoUsuario() {
        System.out.println("Informe seu nome:");
        String nome = sc.nextLine();
        System.out.println("Informe seu cpf: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();

        for (int i = 0; i < quantidadePerfis; i++) {
            if (todosOsPerfis[i] != null && todosOsPerfis[i].getCpf().equals(cpf)) {
                System.out.println("Já existe um usuário cadastrado com esse cpf.");
                return;
            }
        }

        if (quantidadePerfis == todosOsPerfis.length) {
            Usuario[] novoArray = new Usuario[todosOsPerfis.length + 10];
            for (int i = 0; i < todosOsPerfis.length; i++) {
                novoArray[i] = todosOsPerfis[i];
            }
            todosOsPerfis = novoArray;
        }

        Usuario novo = new Usuario(cpf, nome, senha);
        todosOsPerfis[quantidadePerfis++] = novo;
        System.out.println("Usuário criado com sucesso.");
    }

    private Usuario autenticar() {
        System.out.println("Informe seu cpf: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();

        for (int i = 0; i < this.quantidadePerfis; i++) {
            if (this.todosOsPerfis[i] != null
                    && this.todosOsPerfis[i].getCpf().equals(cpf)
                    && this.todosOsPerfis[i].getSenha().equals(senha)) {
                return this.todosOsPerfis[i];
            }
        }
        return null;
    }
}
