/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.dominio;

/**
 *
 * @author 1071759
 */
public class Usuario {

    private String cpf;
    private String nome;
    private String senha;
    private Playlist[] playlists;
    private int quantidadePlaylists;

    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.playlists = new Playlist[10];
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public int getQuantidadePlaylists() {
        return quantidadePlaylists;
    }

    public void adicionarPlaylist(Playlist playlist) {
        if (quantidadePlaylists == playlists.length) {
            Playlist[] novoArray = new Playlist[playlists.length + 10];
            for (int i = 0; i < playlists.length; i++) {
                novoArray[i] = playlists[i];
            }
            playlists = novoArray;
        }

        playlists[quantidadePlaylists++] = playlist;
    }

    public boolean removerPlaylist(int indice) {
        if (indice < 0 || indice >= quantidadePlaylists) {
            return false;
        }

        for (int i = indice; i < quantidadePlaylists - 1; i++) {
            playlists[i] = playlists[i + 1];
        }

        playlists[quantidadePlaylists - 1] = null;
        quantidadePlaylists--;
        return true;
    }

    public boolean existePlaylist(String nome) {
        for (int i = 0; i < quantidadePlaylists; i++) {
            if (playlists[i] != null && playlists[i].getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
