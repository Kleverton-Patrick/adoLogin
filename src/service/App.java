package service;

import model.Recurso;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        runTest();
    }

    private static void runTest() {
        var usuario = new Usuario(1, "João", "joao@gmail.com", "123", "usuario");
        var adm = new Usuario(2, "Maria", "maria@gmail.com", "456", "adm");
        var cadastro = new Recurso("Cadastrar usuário", "adm", true);
        var consulta = new Recurso("Consultar usuário", "usuario", true);
        var excluir = new Recurso("Excluir usuário", "adm", false);
        var login = new Recurso("Logar", "usuario", false);
        //var service = new AutenticacaoService();

        AutenticacaoSenha verificadorSenha = new AutenticacaoSenha();
        AutenticacaoPerfil verificadorPerfil = new AutenticacaoPerfil();
        AutenticacaoRecurso verificadorRecurso = new AutenticacaoRecurso();

        verificadorSenha.setProximo(verificadorPerfil);
        verificadorPerfil.setProximo(verificadorRecurso);

        test(verificadorSenha, usuario, "123", cadastro, "Acesso negado ao recurso Cadastrar usuário");
        test(verificadorSenha, usuario, "123", consulta, "Acesso concedido ao recurso Consultar usuário");
        test(verificadorSenha, usuario, "123", excluir, "Acesso negado ao recurso Excluir usuário");
        test(verificadorSenha, usuario, "123", login, "Recurso Logar inativo");
        test(verificadorSenha, usuario, "456", cadastro, "Senha inválida");
        test(verificadorSenha, usuario, "456", consulta, "Senha inválida");
        test(verificadorSenha, usuario, "456", excluir, "Senha inválida");
        test(verificadorSenha, usuario, "456", login, "Senha inválida");
        test(verificadorSenha, adm, "123", cadastro, "Senha inválida");
        test(verificadorSenha, adm, "123", consulta, "Senha inválida");
        test(verificadorSenha, adm, "123", excluir, "Senha inválida");
        test(verificadorSenha, adm, "123", login, "Senha inválida");
        test(verificadorSenha, adm, "456", cadastro, "Acesso concedido ao recurso Cadastrar usuário");
        test(verificadorSenha, adm, "456", consulta, "Acesso negado ao recurso Consultar usuário");
        test(verificadorSenha, adm, "456", excluir, "Recurso Excluir usuário inativo");
        test(verificadorSenha, adm, "456", login, "Acesso negado ao recurso Logar");
    }

    private static void test(VerificadorAutenticacao verificador, Usuario usuario, String senha, Recurso recurso, String resultadoEsperado) {
        var resultado = verificador.autenticar(usuario, senha, recurso);
        if (resultado.equals(resultadoEsperado)) {
            System.out.println(String.format("V %s, %s, %s, %s", usuario.getPerfil(), senha, recurso.getNome(), resultado));
        } else {
            System.err.println(String.format("X %s, %s, %s, %s", usuario.getPerfil(), senha, recurso.getNome(), resultado));
        }
    }
}