package service;

public class SenhaInvalida extends AutenticacaoService{
    
    @Override
    public boolean aplicarValidacao() {

        String mensagem = "Senha inválida";

        return mensagem (!usuario.getSenha().equals(senha));
    }
}
