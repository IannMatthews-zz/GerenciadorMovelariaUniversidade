package interfaces;

import dados.Usuario;

public interface IRepositorioUsuarios {
	void adicionar(Usuario u);
	void remover(Usuario u);
	boolean existe(Usuario u);
	Usuario buscar(Usuario u);
	Usuario buscar(int id);
	Usuario buscar(String email);
}
