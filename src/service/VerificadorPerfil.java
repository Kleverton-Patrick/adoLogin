import model.Recurso;
import model.Usuario;

class VerificadorPerfil implements AutenticacaoService {
    private AutenticacaoService proximo;

    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!usuario.getPerfil().equals(recurso.getPerfilNecessario())) {
            return "Acesso negado ao recurso " + recurso.getNome();
        }
        return proximo != null ? proximo.autenticar(usuario, senha, recurso) : "Acesso concedido ao recurso " + recurso.getNome();
    }

    @Override
    public void setProximo(AutenticacaoService proximo) {
        this.proximo = proximo;
    }
}