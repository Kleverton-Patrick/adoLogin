package service;

import model.Recurso;
import model.Usuario;

interface AutenticacaoService {

    String autenticar(Usuario usuario, String senha, Recurso recurso);
}
abstract class VerificadorAutenticacao implements AutenticacaoService {
    private VerificadorAutenticacao proximo;

    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (verificar(usuario, senha, recurso) && proximo != null) {
            return proximo.autenticar(usuario, senha, recurso);
        }
        return tratamentoErro(usuario, senha, recurso);
    }

    protected abstract boolean verificar(Usuario usuario, String senha, Recurso recurso);

    protected String tratamentoErro(Usuario usuario, String senha, Recurso recurso) {
        return "Acesso negado ao recurso " + recurso.getNome();
    }

    public void setProximo(VerificadorAutenticacao proximo) {
        this.proximo = proximo;
    }
}