package com.santhu;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserService")
public class UserService {
	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJson(){
		User user=new User();
		user.setId(1);
		user.setName("santhu");
		user.setProfession("IT");
		return Response.status(200).entity(user).build();
	}
	@PUT
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response readObject(User user){
		return Response.status(200).entity(user).build();
	}
}
