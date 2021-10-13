package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateError;

import dao.DAO;

@Entity 
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100)
	private String nome;
	
	private String cpf;
	private String dataNascimento;
	private String rua;
	private String cidade;
	private String cep;
	private String estado;
	private String email;
	private String telefone;
	private String observacao;

	

	public Integer getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public String getCpf() {
		return cpf;
	}



	public String getDataNascimento() {
		return dataNascimento;
	}



	public String getRua() {
		return rua;
	}



	public String getCidade() {
		return cidade;
	}



	public String getCep() {
		return cep;
	}



	public String getEstado() {
		return estado;
	}



	public String getEmail() {
		return email;
	}



	public String getTelefone() {
		return telefone;
	}



	public String getObservacao() {
		return observacao;
	}


	
	

	public void setId(Integer id) {
		this.id = id;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public Pessoa() {

	}
	
	



	public Pessoa(Integer id, String nome, String cpf, String dataNascimento, String rua, String cidade, String cep,
			String estado, String email, String telefone, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.email = email;
		this.telefone = telefone;
		this.observacao = observacao;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

	public static void inserir(Pessoa p) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			EntityManager entityManager = DAO.getEntityManager();
			
			entityManager.getTransaction().begin();			
			entityManager.persist(p);			
			entityManager.getTransaction().commit();
			
			
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastro efetuado", "Com Sucesso!!");
			context.addMessage(null, mensagem);
			
					

			
		}catch(HibernateError ex) {
			ex.printStackTrace();			
		}
	}
	
	
	/*Busca por id
	 * 
	 * */
	public static Pessoa lerPorId(int id) {
		EntityManager entityManager = DAO.getEntityManager();
		Pessoa p = entityManager.find(Pessoa.class, id);
		
		//utilizar o remove(id) para remover um registro do banco de dados
		
		return p;
	}
	
	/**
	 * Retorna lista de pessoas
	 * */
	public static List<Pessoa> ler(){
		
		EntityManager entityManager = DAO.getEntityManager();
		
		String jpql = "SELECT obj from Pessoa obj";
		TypedQuery<Pessoa> query = entityManager.createQuery(jpql, Pessoa.class);
		
		try {
			
			return query.getResultList();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	/***
	 * Atualização dos dados cadastrais
	 * 
	 */
	
	public static void atualizar(int id, String nome, String cpf, String dataNascimento, String rua, String cidade, String cep,String estado, String email, String telefone, String observacao) {
		
		EntityManager entityManager = DAO.getEntityManager();
		
		Pessoa p = entityManager.find(Pessoa.class, id);
		
		entityManager.getTransaction().begin();
		
			p.setNome(nome);
			p.setCpf(cpf);
			p.setDataNascimento(dataNascimento);
			p.setRua(rua);
			p.setCidade(cidade);
			p.setCep(cep);
			p.setEstado(estado);
			p.setEmail(email);
			p.setTelefone(telefone);
			p.setObservacao(observacao);
			
		entityManager.getTransaction().commit();	
		entityManager.close();
		
	}


	

}
