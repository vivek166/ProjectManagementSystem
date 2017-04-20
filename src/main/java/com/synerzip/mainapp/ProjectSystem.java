package com.synerzip.mainapp;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Query;
import org.hibernate.Session;
import com.synerzip.hibernate.HibernateUtils;
import com.synerzip.model.Project;

@Path("/project")
public class ProjectSystem {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getAllProject() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from com.synerzip.model.Project");
			List<Project> projects = query.list();
			System.out.println("hello");
			for(Project p :projects){
				System.out.println(p);
			}
			return projects;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public String getProject(@PathParam("projectId") long projectId) {
		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Project s = (Project) session.get(Project.class, projectId);
			tx.commit();
			return s.toString();
		} catch (Exception e) {
			return "record not found";
		} finally {
			session.close();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addProject(Project project) {

		Session session = HibernateUtils.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.save(project);
			tx.commit();
			return "data saved";
		} catch (Exception e) {
			return "something went wrong";
		} finally {
			session.close();
		}
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public String deleteProject(@PathParam("projectId") long projectId) {

		Session session = HibernateUtils.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try{
		String hql = "DELETE FROM Project "  + "WHERE project_id = "+projectId+"";
		Query query = session.createQuery(hql);
		query.executeUpdate();  
		}catch(Exception e){
			return "something went wrong";
		}finally{
			session.close();
		}
		return "record deleted";
	}
}
