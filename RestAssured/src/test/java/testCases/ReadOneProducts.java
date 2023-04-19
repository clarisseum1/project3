package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;//no static=interface

import static io.restassured.RestAssured.*;//static=package and class

import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

class ReadOneProduct {
String baseURI="https://techfios.com/api-prod/api/product";
	@Test
	public void readOneProduct() {
		/*
		 * given: all input details(baseURI,Headers,Authorization,payload/body,QueryParameters)
		 * When:submit api requests(HTTP method,Endpoint/resource)
		 * then: validate response(status code Headers, responseTime, payload/body)
		 * 
		02.ReadOneProducts
           HTTP method: Get
            baseURI=https://techfios.com/api-prod/api/product
            endPoint/resource=/read_one.php
            Header/s:
            content-type=application/json
            QueryParam:
            id=6866
            Authorization:
            basic auth= username,password
            statusCod=200
	*/	
		Response response =
		given()
		    .baseUri(baseURI)
		    .header("content-type","application/json")
		    .auth().preemptive().basic("demotechfios.com","abc123")
		    .queryParam("id", "7001").
		    
	  when()
	       .get("/read_one.php ").
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
	  Assert.assertEquals(responseheader,"application/json");
	  
	  String responseBody= response.getBody().asString();
	  System.out.println("Response Body:" + responseBody);
	  
	  JsonPath jp =new JsonPath(responseBody);
	  String ProductName =jp.getString("name");
	  System.out.println("first product name:" +ProductName );
	  Assert.assertEquals(ProductName , "Created by AHMED ALI.");
	  
	  String ProductDescription =jp.getString("description");
	  System.out.println("first product description:" +ProductDescription );
	  Assert.assertEquals(ProductDescription,"Created by AHMED ALI.");
	  
	  String ProductPrice =jp.getString("price");
	  System.out.println("first product price:" + ProductPrice  );
	  Assert.assertEquals(ProductPrice ,"199");
	  
	  }
	  
	}

