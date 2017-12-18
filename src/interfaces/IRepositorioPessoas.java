package interfaces;

import dados.Pessoa;

public interface IRepositorioPessoas {
	void adicionar(Pessoa u);
	void remover(Pessoa u);
	boolean existe(Pessoa u);
	Pessoa buscar(Pessoa u);
	Pessoa buscar(int id);
	Pessoa buscar(String email);
}
