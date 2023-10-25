import model.Recurso;
import model.Usuario;

class VerificadorSenha implements AutenticacaoService {
    private AutenticacaoService proximo;

    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
      if (!usuario.getSenha().equals(senha)) {
            return "Senha inválida";
        }
        return proximo != null ? proximo.autenticar(usuario, senha, recurso) : "Acesso concedido ao recurso " + recurso.getNome();
    }

    @Override
    public void setProximo(AutenticacaoService proximo) {
        this.proximo = proximo;
    }
}