package Models;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.Assert;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GroceryModel {

    public String baseURL="http://localhost:3000/allGrocery";
    JSONObject request = new JSONObject();
    Response response;
    public void checkProduct(String name,int price,int stock){

        RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("name",name)
                .when()
                .get(baseURL)
                .then()
                .statusCode(200)

                .body("price[0]", equalTo(price))
                .body("stock[0]", equalTo(stock));
    }

    public void checkProductName(String name) {

        given()
                .contentType(ContentType.JSON)
                .queryParam("name",name)
                .when()
                .get(baseURL)
                .then()
                .statusCode(200);
    }

    public void postProduct(int id,String name,double price,int stock){

        request.put("id",id );
        request.put("name", name);
        request.put("price", price);
        request.put("stock", stock);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(request.toJSONString())
                .when()
                .post(baseURL)
                .then()
                .statusCode(201);
    }
}
