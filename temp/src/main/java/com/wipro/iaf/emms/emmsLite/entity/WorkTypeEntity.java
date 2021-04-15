package com.wipro.iaf.emms.emmsLite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "elite_work_type", schema= "emms_lite")
@Component
public class WorkTypeEntity {

	@Id
	@Column(name = "wrktyp_id")
	private Long wrkTypId;
	@Column(name = "wrktyp")
	private String wrkTyp;
	@Column(name = "wrktyp_desc")
	private String wrkTypDesc;


	public Long getWrkTypId() {
		return wrkTypId;
	}
	public void setWrkTypId(Long wrkTypId) {
		this.wrkTypId = wrkTypId;
	}
	public String getWrkTyp() {
		return wrkTyp;
	}
	public void setWrkTyp(String wrkTyp) {
		this.wrkTyp = wrkTyp;
	}
	public String getWrkTypDesc() {
		return wrkTypDesc;
	}
	public void setWrkTypDesc(String wrkTypDesc) {
		this.wrkTypDesc = wrkTypDesc;
	}
	@Override
	public String toString() {
		return "WorkTypeEntity [wrkTypId=" + wrkTypId + ", wrkTyp=" + wrkTyp
				+ ", wrkTypDesc=" + wrkTypDesc + "]";
	}


}
