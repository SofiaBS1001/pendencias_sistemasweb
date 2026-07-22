/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Musica;
import java.util.ArrayList;

/**
 *
 * @author 1071759
 */
public class MusicaControlador {

    
    private ArrayList<Musica> todasAsMusicas = new ArrayList<>();
    
    
    // Como sei que a música ja não existe?
    public boolean registrarMusica(String titulo, String compositor, String interprete, Double duracao) {
        Musica novaMusica = new Musica(titulo, compositor, interprete, duracao);
        this.todasAsMusicas.add(novaMusica);
        return true;
    }
    
    public ArrayList<Musica> listarTodas() {
        return this.todasAsMusicas;
    }
    // verifica se o id é válido
    public Musica buscarPorId(int id) {
        if (id >= 0 && id < this.todasAsMusicas.size()) {
            return this.todasAsMusicas.get(id);
        }
        return null;
    }
    
    public boolean editarMusica(int id, String titulo, String compositor, String interprete, Double duracao) {
        Musica musica = buscarPorId(id);
        if (musica != null) {
            musica.setTitulo(titulo);
            musica.setCompositor(compositor);
            musica.setInterprete(interprete);
            musica.setDuracao(duracao);
            retorn true
        }
        return false;
    }
    
    public boolen removerMusica(int id) {
        if (id >= 0 && id < this.todasAsMusicas.size()) {
            this.todasAsMusicas.remove(id);
            return true;
        }
        return false;
    }
}
