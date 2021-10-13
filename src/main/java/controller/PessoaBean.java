package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Pessoa;

@ManagedBean
@ViewScoped 
public class PessoaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pessoa p = new Pessoa();
	
	public List<Pessoa> pessoasList;

	public Integer getId() {
		return p.getId();
	}

	public void Integer(Integer id) {
		p.setId(id);
	}

	public String getNome() {
		return p.getNome();
	}

	public void setNome(String nome) {
		p.setNome(nome);
	}

	public Integer getIdade() {
		return p.getIdade();
	}

	public void setIdade(Integer idade) {
		p.setIdade(idade);
	}

	public String getEmail() {
		return p.getEmail();
	}

	public void setEmail(String email) {
		p.setEmail(email);
	}

	public String getTelefone() {
		return p.getTelefone();
	}

	public void setTelefone(String telefone) {
		p.setTelefone(telefone);
	}

	public String getObservacao() {
		return p.getObservacao();
	}

	public void setObservacao(String observacao) {
		p.setObservacao(observacao);
	}
	
	
	
	/*Metodo responsável por chamar a classe pessoa que fará o insert do objeto.
	 * 
	 * 
	 * */
	public void salvar() {
		
		try {
			
			Pessoa.inserir(p);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	public Pessoa consultarPorId(int id) {
		try {
			p = Pessoa.lerPorId(id);
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return p;
	}
	
	
	public List<Pessoa> getPessoaList(){
		
		pessoasList = new ArrayList<>();
		pessoasList = (ArrayList<Pessoa>) Pessoa.ler();
		
		return pessoasList;
	
	}
	
	
	public void atualizar() {
		
		try {
			
			Pessoa.atualizar(getId(), getNome(), getIdade(), getEmail(), getTelefone(), getObservacao());
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
