package RestAss.RestAssUred;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GetMethod 
{
  	@Test
    public void getWeatherDetails()
    {
       RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
       //RequestObject
        RequestSpecification httpsReq=RestAssured.given();
        //Response Obj
        Response resp=httpsReq.request(Method.GET,"/Mumbai");
        //Json into String
        
       String resBodyOutput= resp.getBody().asString();
       System.out.println("Response Body id"+resBodyOutput);

       String contentType=resp.contentType();
        System.out.println("Content type-" +contentType);
        resp.getHeaders();
     long timing  = resp.getTime();
     System.out.println("Time is:  "+ timing);
     System.out.println("HTML Path-" +resp.htmlPath());
Headers allHead=resp.headers();
for(Header forHeader:allHead)
{
	System.out.println(forHeader.getName() +" == "+forHeader.getValue());
}
 

JsonPath pathJsn=resp.jsonPath();
System.out.println("Json Path City Name is: "+ pathJsn.get("City"));

       int code=resp.getStatusCode();
       System.out.println("Status code is: " +code);
       Assert.assertEquals(200, code);
       
      String statusLine= resp.getStatusLine().toString();
      System.out.println("Status Line: "+statusLine);
    }
    
}
