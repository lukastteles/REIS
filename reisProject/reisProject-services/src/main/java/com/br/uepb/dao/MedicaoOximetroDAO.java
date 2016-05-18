package com.br.uepb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.PacienteDomain;

import conexaoBD.HibernateUtil;

public class MedicaoOximetroDAO {

	private Session sessaoAtual;
	
	public void salvaMedicaoOximetro(MedicaoOximetroDomain medicao){
		SessaoAtual().beginTransaction();
		if(ehNovoUsuario(medicao)){
			SessaoAtual().save(medicao);
		}
		else{
			SessaoAtual().update(medicao);
		}
		SessaoAtual().getTransaction().commit();
		SessaoAtual().close();
	}
	public void excluiPerfil(MedicaoOximetroDomain medicao){
		SessaoAtual().delete(medicao);
		SessaoAtual().close();
	}
	
	public MedicaoOximetroDomain obtemMedicaoOximetro(int idOximetro){
		MedicaoOximetroDomain medicao = (MedicaoOximetroDomain)SessaoAtual().get(MedicaoOximetroDomain.class, idOximetro);
		SessaoAtual().close();
		return medicao;
	}	
	
	public MedicaoOximetroDomain obtemUltimaMedicao(String login){
		
		
		String comando = "SELECT mo FROM medicao_oximetroDomain mo " + 
				"inner join login l " +
				"inner join paciente p " + 
				"where p.id = l.paciente_id and mo.paciente_id = p_id and l_login = :login " +
				"order by mo.data_hora desc " +
				"limit 1";
		SQLQuery query = SessaoAtual().createSQLQuery(comando);
		query.addEntity(MedicaoOximetroDomain.class);
		query.setParameter("login", login);
		
		MedicaoOximetroDomain medicao = (MedicaoOximetroDomain)query.list().get(0);
		
		return medicao;
	}
	
	public MedicaoOximetroDomain obtemUltimaMedicao(int idPaciente){
		String comando = "select mo.* from Medicao_oximetro mo " +
						"where mo.paciente_id = :idPaciente " +
						"order by dataHora desc " +
						"limit 1";
		SQLQuery query = SessaoAtual().createSQLQuery(comando);
		query.setParameter("idPaciente", idPaciente);
		query.addEntity(MedicaoOximetroDomain.class);
		MedicaoOximetroDomain medicao = (MedicaoOximetroDomain) query.uniqueResult();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoOximetroDomain> listaMedicoes(){
		
		List<MedicaoOximetroDomain> medicao = 
				(List<MedicaoOximetroDomain>)SessaoAtual().createQuery("from MedicaoOximetroDomain").list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicaoOximetroDomain> listaMedicoesDoPaciente(int idPaciente){
		List<MedicaoOximetroDomain> medicao =
				(List<MedicaoOximetroDomain>)SessaoAtual().createQuery(
						"from MedicaoOximetroDomain where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return medicao;
	}
	
	@SuppressWarnings("unchecked")
	public MedicaoOximetroDomain listaUltimaMedicaoDoPaciente(int idPaciente){
		List<MedicaoOximetroDomain> listamedicoes =
				(List<MedicaoOximetroDomain>)SessaoAtual().createQuery(
						"from MedicaoOximetroDomain order by data where  paciente.id =" + idPaciente).list();
		
		SessaoAtual().close();
		return listamedicoes.get(0);
	}
	
	private Session SessaoAtual(){
		if (sessaoAtual == null || !sessaoAtual.isOpen()){
			sessaoAtual = HibernateUtil.getSessionFactory().openSession();
		}
		return sessaoAtual;
	}
	
	private boolean ehNovoUsuario(MedicaoOximetroDomain medicao){
		if(medicao.getId() > 0){
			return false;
		}
		else{
			return true;
		}
	}
	
}
