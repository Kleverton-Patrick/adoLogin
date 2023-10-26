package service;

import model.Recurso;
import model.Usuario;

class AutenticacaoPerfil extends VerificadorAutenticacao {

    @Override
    protected boolean verificar(Usuario usuario, String senha, Recurso recurso) {
        return usuario.getPerfil().equals(recurso.getPerfilNecessario());
    } 
}