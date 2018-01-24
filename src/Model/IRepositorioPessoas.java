package Model;

import java.util.ArrayList;
import java.util.List;

public interface IRepositorioPessoas {
	void adicionar(Pessoa u);
	void remover(Pessoa u);
	boolean existe(Pessoa u);
	Pessoa buscar(Pessoa u) throws PessoaNaoEncontradaException;
	Pessoa buscar(int id) throws PessoaNaoEncontradaException;
	Pessoa buscar(String email) throws PessoaNaoEncontradaException;
	void editar(Pessoa u) throws PessoaNaoEncontradaException;
	
}
