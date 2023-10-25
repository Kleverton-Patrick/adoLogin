package service;

import model.Recurso;
import model.Usuario;

class VerificadorRecurso implements AutenticacaoService {

    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!recurso.isAtivo()) {
            return "Recurso " + recurso.getNome() + " inativo";
        }
        return "Acesso concedido ao recurso " + recurso.getNome();
    }

    @Override
    public void setProximo(AutenticacaoService proximo) {
        // Nenhum próximo manipulador, este é o último na cadeia.
    }
}