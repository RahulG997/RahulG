package com.hexaware.MLP173.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class MenuRestTest {

	@Test
	public void testMenuList() throws AssertionError, URISyntaxException {
	Menu[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/menu")).getBody().as(Menu[].class);
	assertEquals(5, m.length);
	assertEquals(101, res[0].getFoodId());
	assertEquals("Dosa", res[0].getMenuName());
	assertEquals(80, res[0].getPrice(), 0.1);
	assertEquals(1001, res[0].getVendorId());
	}

    @Test
	public void testFoodDetails() throws AssertionError, URISyntaxException {
	Menu m = given().
                  accept(ContentType.JSON).
				  when().
                  get(CommonUtil.getURI("/api/menu/FoodDetails/101")).
				  getBody().as(Menu.class);
	assertEquals(101, m.getFoodId());
	assertEquals("Dosa", m.getMenuName());
	assertEquals(80, m.getPrice(), 0.1);
	assertEquals(1001, m.getVendorId());
	}

	@Test
	public void testMenuById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/menu/1010")).then().assertThat().statusCode(404);
	}
	
}
