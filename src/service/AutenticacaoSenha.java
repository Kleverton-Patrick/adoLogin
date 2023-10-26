package service;

import model.Recurso;
import model.Usuario;

class AutenticacaoSenha extends VerificadorAutenticacao {
    
    @Override
    protected boolean verificar(Usuario usuario, String senha, Recurso recurso) {
        return usuario.getSenha().equals(senha);
    }
}