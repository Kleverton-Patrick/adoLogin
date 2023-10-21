package service;

public class AcessoConcedido extends AutenticacaoService{

    @Override
    public boolean aplicarValidacao() {
    
        return "Acesso concedido ao recurso " + recurso.getNome();
    }
}
