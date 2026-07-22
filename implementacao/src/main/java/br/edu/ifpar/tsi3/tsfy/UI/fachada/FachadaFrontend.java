/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.UI.fachada;

import br.edu.ifpar.tsi3.tsfy.controladores.MusicaControlador;
import br.edu.ifpar.tsi3.tsfy.controladores.PlaylistControlador;
import br.edu.ifpar.tsi3.tsfy.controladores.UsuarioControlador;
import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import br.edu.ifpar.tsi3.tsfy.dominio.Playlist;
import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 1071759
 */
public class FachadaFrontend {
    
    private MusicaControlador controladorDeMusica;
    private PlaylistControlador controladorDePlaylist;
    private UsuarioControlador controladorDeUsuario;
    
    public FachadaFrontend(){
        this.controladorDeMusica = new MusicaControlador();
        this.controladorDePlaylist = new PlaylistControlador();
        this.controladorDeUsuario = new UsuarioControlador();
    }

    public boolean registrarMusica(String titulo, String compositor, String interprete, Double duracao) {
        return this.controladorDeMusica.registrarMusica(titulo, compositor, interprete, duracao);
    }
    
    public ArrayList<Musica> listarTodasMusicas() {
        return this.controladorDeMusica.listarTodas();
    }
    
    public Musica buscarMusicaPorId(int id) {
        return this.controladorDeMusica.buscarPorId(id);
    }
    
    public boolean editarMusica(int id, String titulo, String compositor, String interprete, Double duracao) {
        return this.controladorDeMusica.editarMusica(id, titulo, compositor, interprete, duracao);
    }
    
    public boolean removerMusica(int id) {
        return this.controladorDeMusica.removerMusica(id);
    }
    
    public boolean criarNovoUsuario(String cpf, String nome, String senha) {
        return this.controladorDeUsuario.criarNovoUsuario(cpf, nome, senha);
    }
    
    public Usuario autenticar(String cpf, String senha) {
        return this.controladorDeUsuario.autenticar(cpf, senha);
    }
    
    public boolean criarPlaylist(Usuario dono, String nome, String descricao) {
        return this.controladorDePlaylist.criarPlaylist(dono, nome, descricao);
    }
    
    public Playlist[] getMinhasPlaylists() {
        return this.controladorDePlaylist.getMinhasPlaylists();
    }
    
}
