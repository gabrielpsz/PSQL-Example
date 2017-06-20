import controle.ControlePrincipal;
import modelo.Carro;
import modelo.Pessoa;

public class Principal {
	public static void main(String[] args) {
		ControlePrincipal ctrl = ControlePrincipal.getInstance();
		ctrl.salvaCarro();
		for (Carro c : ctrl.getCtrlCarro().getCarroDAO().buscarTodos()) {
			System.out.println(c.getPlaca());
		}
		ctrl.salvaPessoa();
		for (Pessoa p : ctrl.getCtrlPessoa().getPessoaDAO().buscarTodos()) {
			System.out.println(p.getNome());
		}
		for (String s : ctrl.getCtrlPessoa().getPessoaDAO().listaPessoaCarros()) {
			System.out.println(s);
		}
		
	}
}
