/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;

public class PlaylistControlador {
    private Playlist minhasPlaylists[] = new Playlist[10];
    private int limitadorPlaylist = 0;
    
    public boolean criarPlaylist(Usuario dono, String nome, String descricao) {
        if (validarPlaylist(nome)) {
            return false;
        }
        Playlist novaPlaylist = new Playlist(dono, nome, descricao);
        this.registrarPlaylist(novaPlaylist);
        return true;
    }
    
    private void registrarPlaylist(Playlist novaPlaylist) {
        if (this.minhasPlaylists.length == this.limitadorPlaylist) {
            Playlist playlists[] = new Playlist[this.limitadorPlaylist + 10];
            for (int i = 0; i < this.minhasPlaylists.length; i++) {
                playlists[i] = this.minhasPlaylists[i];
            }
            this.minhasPlaylists = playlists;
        }
        this.minhasPlaylists[limitadorPlaylist++] = novaPlaylist;
    }
    
    private boolean validarPlaylist(String nome) {
        for (int i = 0; i < this.limitadorPlaylist; i++) {
            if (this.minhasPlaylists[i] != null && this.minhasPlaylists[i].getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public Playlist[] getMinhasPlaylists() {
        return this.minhasPlaylists;
    }
}
