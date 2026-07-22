/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.dominio;

/**
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
    }

    public Playlist(Usuario dono, String nome, String descricao) {
        this();
        this.dono = dono;
        this.nome = nome;
        this.descricao = descricao;
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
        return musicas;
    }

    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    public void adicionarMusica(Musica musica) {
        if (quantidadeMusicas == musicas.length) {
            Musica[] novoArray = new Musica[musicas.length + 10];
            for (int i = 0; i < musicas.length; i++) {
                novoArray[i] = musicas[i];
            }
            musicas = novoArray;
        }

        musicas[quantidadeMusicas++] = musica;
    }

    public boolean removerMusica(int indice) {
        if (indice < 0 || indice >= quantidadeMusicas) {
            return false;
        }

        for (int i = indice; i < quantidadeMusicas - 1; i++) {
            musicas[i] = musicas[i + 1];
        }

        musicas[quantidadeMusicas - 1] = null;
        quantidadeMusicas--;
        return true;
    }
}
