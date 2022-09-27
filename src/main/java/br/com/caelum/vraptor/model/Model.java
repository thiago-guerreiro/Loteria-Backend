package br.com.caelum.vraptor.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
//@Audited(withModifiedFlag=true)
public abstract class Model {

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	protected Date created;
	
	@Column(updatable=true)
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	protected Date updated;

	@Column
	protected boolean ativo = true;
	
	@Column
	protected String motivoInativacao;
	
	@PrePersist
    protected void onCreate() {
    updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    updated = new Date();
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public String getCreatedFormated() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(getCreated());
	}

	public String getCreatedDateFormated() {
		return new SimpleDateFormat("dd/MM/yyyy").format(getCreated());
	}
	
	public String getCreatedTimeFormated() {
		return new SimpleDateFormat("HH:mm").format(getCreated());
	}

	public String getUpdatedFormated() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(getUpdated());
	}

	public String getUpdatedDateFormated() {
		return new SimpleDateFormat("dd/MM/yyyy").format(getUpdated());
	}
	
	public String getUpdatedTimeFormated() {
		return new SimpleDateFormat("HH:mm").format(getUpdated());
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getMotivoInativacao() {
		return motivoInativacao;
	}

	public void setMotivoInativacao(String motivoInativacao) {
		this.motivoInativacao = motivoInativacao;
	}
	
}
