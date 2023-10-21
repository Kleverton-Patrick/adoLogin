package service;

public class AcessoNegado extends AutenticacaoService{

    @Override
    public boolean aplicarValidacao() {

        String mensagem = "Acesso negado ao recurso " + recurso.getNome();

        return mensagem (!usuario.getPerfil().equals(recurso.getPerfilNecessario()));
    }

}
