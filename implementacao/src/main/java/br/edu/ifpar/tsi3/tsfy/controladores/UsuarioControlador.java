/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpar.tsi3.tsfy.controladores;

import br.edu.ifpar.tsi3.tsfy.dominio.Usuario;
import java.util.ArrayList;

public class UsuarioControlador {
    //lista de perfis no controlador
    private ArrayList<Usuario> todosOsPerfis = new ArrayList<>();
    
    public boolean criarNovoUsuario(String cpf, String nome, String senha) {
        Usuario novo = new Usuario(cpf, nome, senha);
        this.todosOsPerfis.add(novo);
        return true;
    }
    
    public Usuario autenticar(String cpf, String senha) {
        for (Usuario usuario : this.todosOsPerfis) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}
