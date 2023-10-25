package service;

import model.Recurso;
import model.Usuario;

interface AutenticacaoService {

    String autenticar(Usuario usuario, String senha, Recurso recurso);

    void setProximo(AutenticacaoService proximo);

}
