package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entidade.Jogo;

@ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private List<Jogo> lista;
	private String par = "";
	private String impar = "";
	private int[] pares;
	private int[] impares;
	private int[] numeros;
	private int qtdPar = 0;
	private int qtdImpar = 0;
	private int contadorPar = 0;
	private int contadorImpar = 0;
	
	public String salvar() {
		try {
			JogoDAO.salvar(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Jogo "+ jogo.getDescricao() +" salvo com sucesso "));
			jogo = new Jogo();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao salvar o jogo "+ jogo.getDescricao()));
		}
		
		return null;
	}
	public String editar(){
		try {
			JogoDAO.editar(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Jogo "+ jogo.getDescricao() +" editado com sucesso "));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao editar o jogo "+ jogo.getDescricao()));
		}
		return "listagem.xhtml";
	}
	
	public String deletar(){
		try {
			JogoDAO.excluir(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Jogo "+ jogo.getDescricao() +" deletado com sucesso "));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao apagar o jogo "+ jogo.getDescricao()));
		}
		return "listagem.xhtml";
	}
	
	
	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDAO.listar();
		}
		return lista;
	}
	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}
	
	public String veripar(int id, int tipo) {
		numeros = new int[10];
		numeros = JogoDAO.par(id);
		
		for (int i = 0; i < numeros.length; i++){
			   if (numeros[i] % 2 == 0) {
				   qtdPar++; 
			}else {
				qtdImpar++;
			}
		}
		
		pares = new int[qtdPar];
		impares = new int[qtdImpar];
		
		for (int i = 0; i < numeros.length; i++){
			   if (numeros[i] % 2 == 0) {
				   contadorPar++;
				   pares[contadorPar-1] = numeros[i];
			}else {
				contadorImpar++;
				impares[contadorImpar-1] = numeros[i];
			}
		}
		
		for (int i = 0; i < pares.length; i++){
			if (i != (pares.length)-1) {
				par += pares[i]+",";
			}else {
				par += pares[i];
			}
		}
		
		for (int i = 0; i < impares.length; i++){
			if (i != (impares.length)-1) {
				impar += impares[i]+",";
			}else {
				impar += impares[i];
			}
		}
		
		//1 - par ; 2 - impar
		if (tipo == 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Contagem feita.","Os números pares são: "+par));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Contagem feita.", "Os números ímpares são: "+impar));
		}
		
		return null; 
	}
		
	public String getPar() {
		return par;
	}
	public void setPar(String par) {
		this.par = par;
	}
	
}
