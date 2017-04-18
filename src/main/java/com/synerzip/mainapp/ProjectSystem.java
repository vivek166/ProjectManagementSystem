package com.synerzip.mainapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.synerzip.hibernate.HibernateConnection;
import com.synerzip.model.ProjectModel;

@Path("/record")
public class ProjectSystem {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{projectId}")
	public String getRecord(@PathParam("projectId") int projectId) {
		Session session = HibernateConnection.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			ProjectModel s = (ProjectModel) session.get(ProjectModel.class, projectId);
			tx.commit();
			System.out.println(s);
			return s.toString();
		} catch (Exception e) {
			return "record not found";
		} finally {
			session.close();
		}
	}
}
