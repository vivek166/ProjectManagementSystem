package com.synerzip.model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ProjectModel {

	
	@Id
	int projectId;
	String projectTitle;
	String technology_used;
	String decsription;
	String feature;

	
	public ProjectModel(int projectId, String projectTitle, String technology_used, String decsription,
			String feature) {
		super();
		this.projectId = projectId;
		this.projectTitle = projectTitle;
		this.technology_used = technology_used;
		this.decsription = decsription;
		this.feature = feature;
	}

	public ProjectModel() {
		
		
	}
	@Override
	public String toString() {
		return "ProjectModel [projectId=" + projectId + ", projectTitle=" + projectTitle + ", technology_used="
				+ technology_used + ", decsription=" + decsription + ", feature=" + feature + "]";
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getTechnology_used() {
		return technology_used;
	}

	public void setTechnology_used(String technology_used) {
		this.technology_used = technology_used;
	}

	public String getDecsription() {
		return decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
}
