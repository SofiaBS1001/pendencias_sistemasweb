/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.dominio;

/**
 * Representa um usuário com um conjunto de playlists gerenciado por vetor puro.
 * A manipulação é feita com controle explícito da quantidade de playlists,
 * facilitando operações de inclusão e remoção por índice.
 *
 * @author 1071759
 */
public class Usuario {

    private String cpf;
    private String nome;
    private Playlist[] playlists;
    private int quantidadePlaylists;

    public Usuario() {
        this.playlists = new Playlist[10];
        this.quantidadePlaylists = 0;
    }

    public Playlist[] getPlaylists() {
        Playlist[] copia = new Playlist[quantidadePlaylists];
        System.arraycopy(playlists, 0, copia, 0, quantidadePlaylists);
        return copia;
    }

    public void setPlaylists(Playlist[] playlists) {
        if (playlists == null) {
            this.playlists = new Playlist[10];
            this.quantidadePlaylists = 0;
            return;
        }

        this.playlists = new Playlist[playlists.length];
        this.quantidadePlaylists = 0;

        for (Playlist playlist : playlists) {
            adicionarPlaylist(playlist);
        }
    }

    public int getQuantidadePlaylists() {
        return quantidadePlaylists;
    }

    public void adicionarPlaylist(Playlist playlist) {
        if (playlist == null) {
            return;
        }

        if (quantidadePlaylists == playlists.length) {
            aumentarCapacidade();
        }

        playlists[quantidadePlaylists] = playlist;
        quantidadePlaylists++;
    }

    public void removerPlaylist(int indice) {
        if (indice < 0 || indice >= quantidadePlaylists) {
            return;
        }

        for (int i = indice; i < quantidadePlaylists - 1; i++) {
            playlists[i] = playlists[i + 1];
        }

        playlists[quantidadePlaylists - 1] = null;
        quantidadePlaylists--;
    }

    private void aumentarCapacidade() {
        Playlist[] novoVetor = new Playlist[playlists.length + 5];
        System.arraycopy(playlists, 0, novoVetor, 0, playlists.length);
        playlists = novoVetor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
