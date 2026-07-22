/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.dominio;

/**
 * Representa uma playlist com controle manual das músicas usando um vetor puro.
 * A manipulação é feita por índice, permitindo adicionar, remover e consultar
 * as músicas sem depender de coleções como ArrayList.
 *
 * @author 1071759
 */
public class Playlist {

    private Usuario dono;
    private String nome;
    private String descricao;
    private Musica[] musicas;
    private int quantidadeMusicas;

    public Playlist() {
        this.musicas = new Musica[10];
        this.quantidadeMusicas = 0;
    }

    public Playlist(String nome, String descricao, Usuario dono) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.dono = dono;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Musica[] getMusicas() {
        Musica[] copia = new Musica[quantidadeMusicas];
        System.arraycopy(musicas, 0, copia, 0, quantidadeMusicas);
        return copia;
    }

    public void setMusicas(Musica[] musicas) {
        if (musicas == null) {
            this.musicas = new Musica[10];
            this.quantidadeMusicas = 0;
            return;
        }

        this.musicas = new Musica[musicas.length];
        this.quantidadeMusicas = 0;

        for (Musica musica : musicas) {
            adicionarMusica(musica);
        }
    }

    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    public void adicionarMusica(Musica musica) {
        if (musica == null) {
            return;
        }

        if (quantidadeMusicas == musicas.length) {
            aumentarCapacidade();
        }

        musicas[quantidadeMusicas] = musica;
        quantidadeMusicas++;
    }

    public void removerMusica(int indice) {
        if (indice < 0 || indice >= quantidadeMusicas) {
            return;
        }

        for (int i = indice; i < quantidadeMusicas - 1; i++) {
            musicas[i] = musicas[i + 1];
        }

        musicas[quantidadeMusicas - 1] = null;
        quantidadeMusicas--;
    }

    private void aumentarCapacidade() {
        Musica[] novoVetor = new Musica[musicas.length + 5];
        System.arraycopy(musicas, 0, novoVetor, 0, musicas.length);
        musicas = novoVetor;
    }
}
