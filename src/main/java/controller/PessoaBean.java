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
	
	
	public void setCpf(String cpf) {
		p.setCpf(cpf);
	}



	public void setDataNascimento(String dataNascimento) {
		p.setDataNascimento(dataNascimento);
	}



	public void setRua(String rua) {
		p.setRua(rua);
	}



	public void setCidade(String cidade) {
		p.setCidade(cidade);
	}



	public void setCep(String cep) {
		p.setCep(cep);
		
	}



	public void setEstado(String estado) {
		p.setEstado(estado);
	}
	
	
	public String getCpf() {
		return p.getCpf();
	}



	public String getDataNascimento() {
		return p.getDataNascimento();
	}



	public String getRua() {
		return p.getRua();
	}



	public String getCidade() {
		return p.getCidade();
	}



	public String getCep() {
		return p.getCep();
	}



	public String getEstado() {
		return p.getEstado();
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
		
			Pessoa.atualizar(getId(), getNome(), getCpf(), getDataNascimento(), getRua(), getCidade(), getCep(), getEstado(),getEmail(), getTelefone(), getObservacao());
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

}
