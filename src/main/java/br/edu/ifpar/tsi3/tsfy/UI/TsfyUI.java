/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1071759
 */
public class TsfyUI {

    private final Scanner sc = new Scanner(System.in);
    public ArrayList<Musica> todasAsMusicas = new ArrayList<>();
    private Playlist minhasPlaylists[] = new Playlist[10];
    
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
    
    public void menu(){
        //Favoritar Musica
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
        Musica musica = new Musica(titulo, compositor, interprete, duracao);
        todasAsMusicas.add(musica);
    }

    private void editarMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        for (int i = 0; i < this.todasAsMusicas.size(); i++){
            System.out.println("[" + i + "] " + this.todasAsMusicas.get(i).getTitulo() + "(intérprete: " + this.todasAsMusicas.get(i).getInterprete() + ")");
        }
        
        System.out.println("Informe qual é o ID da música que você deseja editar: ");
        int id = Integer.parseInt(sc.nextLine());
        
        System.out.println("Qual é o título da musica?");
        String titulo = sc.nextLine();
        this.todasAsMusicas.get(id).setTitulo(titulo);
        System.out.println("Qual é o compositor da musica?");
        String compositor = sc.nextLine();
        this.todasAsMusicas.get(id).setCompositor(compositor);
        System.out.println("Qual é o interprete da musica?");
        String interprete = sc.nextLine();
        this.todasAsMusicas.get(id).setInterprete(interprete);
        System.out.println("Qual é a duracao da musica?");
        Double duracao = Double.parseDouble(sc.nextLine());
        this.todasAsMusicas.get(id).setDuracao(duracao);
        
        System.out.println("Musica editada com sucesso.");
    }

    private void listarMusicas() {
        for (Musica musica: this.todasAsMusicas) {
            System.out.println(musica.getTitulo() + "(intérprete: " + musica.getInterprete() + ")");
        }
                
    }

    private void buscarMusicaPorID() {
        System.out.println("Informe qual é o ID da música que você deseja buscar: ");
        int id = Integer.parseInt(sc.nextLine());
        
        System.out.println("Título: " + this.todasAsMusicas.get(id).getTitulo());
        System.out.println("Compositor: " + this.todasAsMusicas.get(id).getCompositor());
        System.out.println("Interprete: " + this.todasAsMusicas.get(id).getInterprete());
        System.out.println("Duracao: " + this.todasAsMusicas.get(id).getDuracao());
    }

    private void removerMusica() {
        System.out.println("Esta é meu banco de dados de músicas: ");
        for (int i = 0; i < this.todasAsMusicas.size(); i++){
            System.out.println("[" + i + "] " + this.todasAsMusicas.get(i).getTitulo() + "(intérprete: " + this.todasAsMusicas.get(i).getInterprete() + ")");
        }
        
        System.out.println("Informe qual é o ID da música que você deseja remover: ");
        int id = Integer.parseInt(sc.nextLine());
        
        this.todasAsMusicas.remove(id);
    }
    
    
}
