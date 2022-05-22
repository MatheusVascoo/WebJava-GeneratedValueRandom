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
		return null;
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
	
}
