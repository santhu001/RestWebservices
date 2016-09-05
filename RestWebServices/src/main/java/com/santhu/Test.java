package com.santhu;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class Test {
public static void main(String[] args) {
Client client=ClientBuilder.newClient();
String URI="http://localhost:8080/RestWebServices/rest";
User user1=new User();
user1.setId(1);
user1.setName("santhu");
user1.setProfession("IT");

WebTarget webTarget =client.target(URI);
//put request
System.out.println("---------- Put Request");
WebTarget putReq=webTarget.path("UserService/insert");
Invocation.Builder invocationBuilder =  putReq.request(MediaType.APPLICATION_JSON);
Response res=invocationBuilder.put(Entity.entity(user1, MediaType.APPLICATION_JSON));
System.out.println(res.readEntity(User.class));
//getReq
WebTarget getReq=webTarget.path("UserService/user");
Invocation.Builder invocationBuilder1 =  getReq.request(MediaType.APPLICATION_JSON);
Response res1=invocationBuilder1.get();
System.out.println("---------- Get Request");
System.out.println(res1.readEntity(User.class));
}

}
