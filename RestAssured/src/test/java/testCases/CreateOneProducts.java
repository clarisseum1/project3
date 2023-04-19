package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;//no static=interface

import static io.restassured.RestAssured.*;//static=package and class

import java.io.File;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class CreateOneProducts {

	String baseURI = "https://techfios.com/api-prod/api/product";
	String filePath = "src\\main\\java\\data\\CreatePayload.json";
	HashMap<String, String> createPayLoad;
	String firstProductId;
	String readOneProductId;

	public Map<String, String> createPayLoadMap() {
		createPayLoad = new HashMap<String, String>();
		createPayLoad.put("name", "Amazing Pillow 2.0");
		createPayLoad.put("price", "299");
		createPayLoad.put("description", "The best pillow for amazing programmers.");
		createPayLoad.put("category_id", "2");
		createPayLoad.put("created", "2018-06-01 00:35:07");

		return createPayLoad;
	
	}

	@Test(priority = 1)
	public void createOneProducts() {
		/*
		 * given: all input
		 * details(baseURI,Headers,Authorization,payload/body,QueryParameters)
		 * When:submit api requests(HTTP method,Endpoint/resource) then: validate
		 * response(status code Headers, responseTime, payload/body)
		 * 
		 * 03.CreateOneProducts HTTP method: Post
		 * baseURI=https://techfios.com/api-prod/api/product
		 * endPoint/resource=/create.php Header/s: content-type=application/json;
		 * charset=UTF-8 Authorization: basic auth= username,password statusCod=201
		 * 
		 * Payload/Body:
		 * 
		 * { "name" : "Amazing Pillow 2.0", "price" : "299", "description" :
		 * "The best pillow for amazing programmers.", "category_id" : "2", "created" :
		 * "2018-06-01 00:35:07"
		 * 
		 * } 01.createoneProduct
		 * validate(statusCode=201,header(content-type=application/json;
		 * charset=UTF-8,responseTime),reponseBody)
		 * 
		 * 
		 */
		Response response = given().baseUri(baseURI).header("content-type", "application/json; charset=UTF-8").auth()
				.preemptive().basic("demotechfios.com", "abc123")
				// .body(new File(filePath))
				.body(createPayLoadMap()).

				when().post("/create.php ").then().extract().response();

		int responseCode = response.getStatusCode();
		System.out.println("Response code:" + responseCode);

		Assert.assertEquals(responseCode, 201);
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("response time:" + responseTime);
		if (responseTime <= 2000) {
			System.out.println("response time within range");

		} else {
			System.out.println("response time out of range!!");

		}

		String responseheader = response.getHeader("content-type");
		System.out.println("Response Hearder:" + responseheader);
		Assert.assertEquals(responseheader, "application/json; charset=UTF-8");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body:" + responseBody);

		JsonPath jp = new JsonPath(responseBody);
		String ProductMessage = jp.getString("message");
		System.out.println("first product message:" + ProductMessage);
		Assert.assertEquals(ProductMessage, "Product was created.");

	}

@Test(priority=2)
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
	  when()
	           .get("/read.php ").
	  then()
	         .extract().response();
		int responseCode =response.getStatusCode();
		System.out.println("Response code:" + responseCode);
	    Assert.assertEquals(responseCode, 200);
	  
	  
	  String responseBody= response.getBody().asString();
	  
	  
	  JsonPath jp =new JsonPath(responseBody);
	  firstProductId =jp.getString("records[0].id");
	  System.out.println("first product id:" +firstProductId );
	  
	  if (firstProductId!=null) {
		  System.out.println("response body containsfirstproduct ID.");
		  }
		  else {
			  System.out.println("response body does not contains firstproduct ID.");
		  }
		  }
@Test(priority=3)
public void readOneProduct() {
	
			readOneProductId=firstProductId;
			
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
			    .queryParam("id", readOneProductId).
			    
		  when()
		     .get("/read_one.php ").
		  then()
		     .extract().response();
			
			int responseCode =response.getStatusCode();
			System.out.println("Response code:" + responseCode);

		    Assert.assertEquals(responseCode, 200);
		    
		  
		 String responseheader=response.getHeader("content-type");
		  System.out.println("Response Hearder:"+responseheader );
		  Assert.assertEquals(responseheader,"application/json");
		  
		  String responseBody= response.getBody().asString();
		  System.out.println("Response Body:" + responseBody);
		  
		  JsonPath jp =new JsonPath(responseBody);
		  String ProductName =jp.getString("name");
		  System.out.println("first product name:" +ProductName );
		//  Assert.assertEquals(ProductName , "Created by AHMED ALI.");
		  
		  String ProductDescription =jp.getString("description");
		  System.out.println("first product description:" +ProductDescription );
		 // Assert.assertEquals(ProductDescription,"Created by AHMED ALI.");
		  
		  String ProductPrice =jp.getString("price");
		  System.out.println("first product price:" + ProductPrice  );
		 // Assert.assertEquals(ProductPrice ,"199");
		  
		  }
		  
	  


		

	}


