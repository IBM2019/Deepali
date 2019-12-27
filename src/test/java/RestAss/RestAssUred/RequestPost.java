package RestAss.RestAssUred;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RequestPost {

	@Test
	public static void registrationSuccessfulAPI()
    {
		
		
		//Specify base URI
		  RestAssured.baseURI="http://localhost:8085/student";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  requestParams.put("id","101");
		  requestParams.put("firstName","Ashish");
		  requestParams.put("lastName","wag");
		  requestParams.put("email","Ashish@gmail.com");
		  requestParams.put("programme","Test manager");
		  
		  JSONArray courses= new JSONArray();
		  courses.add("Java");
		  courses.add("Selenium");
		  courses.add("API");
		  
		  requestParams.put("courses",courses);
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object;
		 Response response=httpRequest.request(Method.POST);
		    
		 // Response response=httpRequest.request(Method.POST);
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 201);
		  
		  //success code validation
		  String successCode=response.jsonPath().get("SuccessCode");
	//	  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		  
    }
	public static void getCall()
	{
		RestAssured.baseURI="http://localhost:8085/student";
	       //RequestObject
	        RequestSpecification httpsReq=RestAssured.given();
	        //Response Obj
	        Response resp=httpsReq.request(Method.GET,"/101");
	        
	        //Json into String
	       String resBodyOutput= resp.getBody().asString();
	       System.out.println("Response Body id"+resBodyOutput);
	}
	public static void deleteCall()
	{
		RestAssured.baseURI="http://localhost:8085/student";
	       //RequestObject
	        RequestSpecification httpsReq=RestAssured.given();
	        //Response Obj
	        Response resp=httpsReq.request(Method.DELETE,"/101");
	        
	        //Json into String
			  int statusCode=resp.getStatusCode();

	       String resBodyOutput= resp.getBody().asString();
	       System.out.println("Response Body id"+statusCode);
	}
}
