package service;

public class RecursoInativo extends AutenticacaoService{

    @Override
    public boolean aplicarValidacao() {

        String mensagem = "Recurso " + recurso.getNome() + " inativo";

        return mensagem (!recurso.isAtivo());
    }
    
}
