/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.UI.fachada.FachadaFrontend;
import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);
    private final FachadaFrontend fachada = new FachadaFrontend();
    private Usuario usuarioLogado = null;
    
    public void rodar() {
        int op;
        
        do {
            menuDeLogin();
            op = Integer.parseInt(sc.nextLine());
            
            switch (op) {
                case 1:
                    criarNovoUsuario();
                    break;
                case 2:
                    autenticar();
                    break;
                case 0:
                    System.out.println("Encerrando o programa... Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (usuarioLogado == null);
        
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
                case 0:
                    System.out.println("Efetuando logout de " + usuarioLogado.getNome() + "...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            
        } while (op != 0);
    }
    
    public void menuDeLogin() {
        System.out.println("\n====== TSFY - ENTRAR ======");
        System.out.println("1 - Criar novo usuário");
        System.out.println("2 - Fazer Login");
        System.out.println("0 - Sair do programa");
        System.out.print("Escolha uma opção: ");
    }

    public void menu(){
        System.out.println("\n====== MENU PRINCIPAL (Sessão: " + usuarioLogado.getNome() + ") ======");
        System.out.println("1 - Criar música");
        System.out.println("2 - Editar música");
        System.out.println("3 - Listar músicas");
        System.out.println("4 - Buscar música por ID");
        System.out.println("5 - Remover música");
        System.out.println("0 - Sair (Logout)");
        System.out.print("Escolha uma opção: ");
    }

    private void criarNovoUsuario() {
        System.out.println("\n--- Novo Cadastro ---");
        System.out.println("Informe seu nome:");
        String nome = sc.nextLine();
        System.out.println("Informe seu CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();
        
        boolean sucesso = this.fachada.criarNovoUsuario(cpf, nome, senha);
        if (sucesso) {
            System.out.println("Usuário registrado com sucesso! Use a opção de Login para entrar.");
        } else {
            System.out.println("Erro ao registrar usuário.");
        }
    }

    private void autenticar() {
        System.out.println("\n--- Acessar Conta ---");
        System.out.println("Informe seu CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = sc.nextLine();
        
        Usuario usuario = this.fachada.autenticar(cpf, senha);
        if (usuario != null) {
            this.usuarioLogado = usuario;
            System.out.println("Login bem-sucedido! Bem-vindo(a) ao Tsfy.");
        } else {
            System.out.println("Erro: CPF ou senha incorretos.");
        }
    }

    private void criarMusica() {
        System.out.println("\n--- Cadastrar Nova Música ---");
        System.out.println("Qual é o título da música?");
        String titulo = sc.nextLine();
        System.out.println("Qual é o compositor da música?");
        String compositor = sc.nextLine();
        System.out.println("Qual é o intérprete da música?");
        String interprete = sc.nextLine();
        System.out.println("Qual é a duração da música?");
        Double duracao = Double.parseDouble(sc.nextLine());
        
        boolean sucesso = this.fachada.registrarMusica(titulo, compositor, interprete, duracao);
        if (sucesso){
            System.out.println("Música adicionada com sucesso ao banco de dados.");
        } else {
            System.out.println("Erro ao registrar música.");
        }
    }

    private void editarMusica() {
        System.out.println("\n--- Editar Música ---");
        ArrayList<Musica> musicas = this.fachada.listarTodasMusicas();
        
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música cadastrada para editar.");
            return;
        }
        
        for (int i = 0; i < musicas.size(); i++){
            System.out.println("[" + i + "] " + musicas.get(i).getTitulo() + " (Intérprete: " + musicas.get(i).getInterprete() + ")");
        }
        
        System.out.println("Informe o ID da música que deseja editar: ");
        int id = Integer.parseInt(sc.nextLine());
        
        Musica musica = this.fachada.buscarMusicaPorId(id);
        if (musica == null) {
            System.out.println("Música não encontrada.");
            return;
        }
        
        System.out.println("Qual é o novo título?");
        String titulo = sc.nextLine();
        System.out.println("Qual é o novo compositor?");
        String compositor = sc.nextLine();
        System.out.println("Qual é o novo intérprete?");
        String interprete = sc.nextLine();
        System.out.println("Qual é a nova duração?");
        Double duracao = Double.parseDouble(sc.nextLine());
        
        boolean sucesso = this.fachada.editarMusica(id, titulo, compositor, interprete, duracao);
        if (sucesso) {
            System.out.println("Música editada com sucesso via Fachada.");
        } else {
            System.out.println("Erro ao salvar alterações da música.");
        }
    }

    private void listarMusicas() {
        System.out.println("\n--- Catálogo de Músicas ---");
        ArrayList<Musica> musicas = this.fachada.listarTodasMusicas();
        
        if (musicas.isEmpty()) {
            System.out.println("O catálogo está vazio.");
            return;
        }
        
        for (Musica musica : musicas) {
            System.out.println("- " + musica.getTitulo() + " [Artista: " + musica.getInterprete() + " | Duração: " + musica.getDuracao() + " min]");
        }
    }

    private void buscarMusicaPorID() {
        System.out.println("\n--- Buscar Música ---");
        System.out.println("Informe o ID da música que deseja visualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        
        Musica musica = this.fachada.buscarMusicaPorId(id);
        if (musica != null) {
            System.out.println("\n[MÚSICA ENCONTRADA]");
            System.out.println("Título: " + musica.getTitulo());
            System.out.println("Compositor: " + musica.getCompositor());
            System.out.println("Intérprete: " + musica.getInterprete());
            System.out.println("Duração: " + musica.getDuracao() + " minutos");
        } else {
            System.out.println("Música com o ID " + id + " não foi localizada.");
        }
    }

    private void removerMusica() {
        System.out.println("\n--- Remover Música ---");
        ArrayList<Musica> musicas = this.fachada.listarTodasMusicas();
        
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música disponível para remoção.");
            return;
        }
        
        for (int i = 0; i < musicas.size(); i++){
            System.out.println("[" + i + "] " + musicas.get(i).getTitulo());
        }
        
        System.out.println("Informe o ID da música que você deseja excluir: ");
        int id = Integer.parseInt(sc.nextLine());
        
        boolean sucesso = this.fachada.removerMusica(id);
        if (sucesso) {
            System.out.println("Música excluída com sucesso.");
        } else {
            System.out.println("Não foi possível remover. Verifique se o ID está correto.");
        }
    }
}