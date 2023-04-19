package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;//no static=interface

import static io.restassured.RestAssured.*;//static=package and class

import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

class ReadAllProducts {
String baseURI="https://techfios.com/api-prod/api/product";
	@Test
	public void readAllProducts() {
		/*
		 * given: all input details(baseURI,Headers,Authorization,payload/body,QueryParameters)
		 * When:submit api requests(HTTP method,Endpoint/resource)
		 * then: validate response(status code Headers, responseTime, payload/body)
		 * 
		 * 01.ReadAllProducts
		 * baseURI=https://techfios.com/api-prod/api/product
		 * endPoint/resource=/read.php 
		 * HTTP method: Get
		 * Header/s:
		 * content-type=application/json; charset=UTF-8 
		 * Authorization:
		 * basic auth=username,password
		 * statusCod=200
		 * 
		 */
		
		Response response =
		given()
		    .baseUri(baseURI)
		    .header("content-type","application/json; charset=UTF-8")
		    .auth().preemptive().basic("demotechfios.com","abc123").
	  when().get("/read.php ").
	  then()
	  .extract().response();
		int responseCode =response.getStatusCode();
		System.out.println("Response code:" + responseCode);

	  Assert.assertEquals(responseCode, 200);
	  long responseTime= response.getTimeIn(TimeUnit.MILLISECONDS);
	  System.out.println("response time:" + responseTime);
	  if (responseTime<=2000) {
		  System.out.println("response time within range");
		  
	  }
	  else {
		  System.out.println("response time out of range!!");
		  
	  }
	  String responseheader=response.getHeader("content-type");
	  System.out.println("Response Hearder:"+responseheader );
	  
	  Assert.assertEquals(responseheader,"application/json; charset=UTF-8");
	  String responseBody= response.getBody().asString();
	  System.out.println("Response Body:" + responseBody);
	  
	  JsonPath jp =new JsonPath(responseBody);
	  String firstProductId =jp.getString("records[0].id");
	  System.out.println("first product id:" +firstProductId );
	  
	  if (firstProductId!=null) {
		  System.out.println("response body containsfirstproduct ID.");
		  }
		  else {
			  System.out.println("response body does not contains firstproduct ID.");
		  }
	  }
	  
	}

