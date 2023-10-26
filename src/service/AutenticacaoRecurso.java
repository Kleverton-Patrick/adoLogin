package service;

import model.Recurso;
import model.Usuario;

class AutenticacaoRecurso extends VerificadorAutenticacao {
    
    @Override
    protected boolean verificar(Usuario usuario, String senha, Recurso recurso) {
        return recurso.isAtivo();
    }
}