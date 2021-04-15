package com.wipro.iaf.emms.emmsLite.entity;
/**
 * @author Shivam
 * Date:: 05 April 2021
 * Description::Entity to Generate and maintain running ID records across various modules
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "elite_workorder_tb", schema= "emms_lite")
@Component
public class WorkOrderEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long workorder_id;
	@Column
	private String asset_num;
	private String wo_desc;
	private String pm;
	private String wo_status;
	private String wo_num;
	private String work_type;
	private String serial_num;
	private String closure_date;
	private String cm_item;
	private String cm_desc;
	private String det_id;
	private String pm_desc;
	private String closed_by;

	public Long getWorkorder_id() {
		return workorder_id;
	}
	public void setWorkorder_id(Long workorder_id) {
		this.workorder_id = workorder_id;
	}
	public String getAsset_num() {
		return asset_num;
	}
	public void setAsset_num(String asset_num) {
		this.asset_num = asset_num;
	}
	public String getWo_desc() {
		return wo_desc;
	}
	public void setWo_desc(String wo_desc) {
		this.wo_desc = wo_desc;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public String getWo_status() {
		return wo_status;
	}
	public void setWo_status(String wo_status) {
		this.wo_status = wo_status;
	}
	public String getWo_num() {
		return wo_num;
	}
	public void setWo_num(String wo_num) {
		this.wo_num = wo_num;
	}
	public String getWork_type() {
		return work_type;
	}
	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public String getClosure_date() {
		return closure_date;
	}
	public void setClosure_date(String closure_date) {
		this.closure_date = closure_date;
	}
	public String getCm_item() {
		return cm_item;
	}
	public void setCm_item(String cm_item) {
		this.cm_item = cm_item;
	}
	public String getCm_desc() {
		return cm_desc;
	}
	public void setCm_desc(String cm_desc) {
		this.cm_desc = cm_desc;
	}
	public String getDet_id() {
		return det_id;
	}
	public void setDet_id(String det_id) {
		this.det_id = det_id;
	}
	public String getPm_desc() {
		return pm_desc;
	}
	public void setPm_desc(String pm_desc) {
		this.pm_desc = pm_desc;
	}
	public String getClosed_by() {
		return closed_by;
	}
	public void setClosed_by(String closed_by) {
		this.closed_by = closed_by;
	}
	@Override
	public String toString() {
		return "WorkOrderEntity [workorder_id=" + workorder_id + ", asset_num="
				+ asset_num + ", wo_desc=" + wo_desc + ", pm=" + pm
				+ ", wo_status=" + wo_status + ", wo_num=" + wo_num
				+ ", work_type=" + work_type + ", serial_num=" + serial_num
				+ ", closure_date=" + closure_date + ", cm_item=" + cm_item
				+ ", cm_desc=" + cm_desc + ", det_id=" + det_id + ", pm_desc="
				+ pm_desc + ", closed_by=" + closed_by + "]";
	}


}
