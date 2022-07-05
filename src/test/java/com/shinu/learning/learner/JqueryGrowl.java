package com.shinu.learning.learner;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class JqueryGrowl {
	public static WebDriver insightDriver;
	public static WebElement insightEle;

	@DataProvider(name = "cartproviders", parallel = true)
	public Object[] cartProvider() throws Exception {
		return new String[] { "C++", "JAVA", "Python", "C#", "GoLang", "Elixer", "Julia", "Rust" };
	}

	@Test
	public void rabbitmqClient() throws Exception {
//		getScenarios();
		getTestCases();
//		JsonParsing json = new JsonParsing();
//		System.out.println("Starting RabgitMQ");
//		rabbitmq();
	}
	
	public void getScenarios() throws Exception{
		String path = "./Configuration/Test.json";
		String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(templateContent);
		int i = 0;
		while (true) {
			try {
				String cartname = JsonPath.parse(json.toString()).read("$.orders[" + i + "].carts").toString();
				String poid = JsonPath.parse(json.toString()).read("$.orders[" + i + "].poId").toString();
				String orderStatus = JsonPath.parse(json.toString()).read("$.orders[" + i + "].orderstatus").toString();
				i++;
				System.out.println(cartname + "  ==>  " + poid +" ["+orderStatus+"]");
				
				
			} catch (Exception e) {
				System.out.println("End of line");
				break;
			}
		}	
		System.out.println("\n\n====================================================\n\n");
		i=0;
		while (true) {
			try {
				String cartname = JsonPath.parse(json.toString()).read("$.orders[" + i + "].carts").toString();
				String poid = JsonPath.parse(json.toString()).read("$.orders[" + i + "].poId").toString();
				String orderStatus = JsonPath.parse(json.toString()).read("$.orders[" + i + "].orderstatus").toString();
				i++;
				System.out.println(cartname);
				
			} catch (Exception e) {
				System.out.println("End of line");
				break;
			}
		}	
		System.out.println("\n\n====================================================\n\n");
		i=0;
		while (true) {
			try {
				String cartname = JsonPath.parse(json.toString()).read("$.orders[" + i + "].carts").toString();
				String poid = JsonPath.parse(json.toString()).read("$.orders[" + i + "].poId").toString();
				String orderStatus = JsonPath.parse(json.toString()).read("$.orders[" + i + "].orderstatus").toString();
				i++;
				
				System.out.println(poid);
			} catch (Exception e) {
				System.out.println("End of line");
				break;
			}
		}	
		System.out.println("\n\n====================================================\n\n");
		i=0;
		while (true) {
			try {
				String cartname = JsonPath.parse(json.toString()).read("$.orders[" + i + "].carts").toString();
				String poid = JsonPath.parse(json.toString()).read("$.orders[" + i + "].poId").toString();
				String orderStatus = JsonPath.parse(json.toString()).read("$.orders[" + i + "].orderstatus").toString();
				i++;
				
				System.out.println(orderStatus);
			} catch (Exception e) {
				System.out.println("End of line");
				break;
			}
		}	
		System.out.println("\n\n====================================================\n\n");
	}
	
	public void getTestCases() throws Exception {
		String path = "./Configuration/Config.json";
		String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(templateContent);
		int i = 0;
		while (true) {
			try {
				String cartname = JsonPath.parse(json.toString()).read("$.cases[" + i + "].case_id").toString();
				String cartdesc = JsonPath.parse(json.toString()).read("$.cases[" + i + "].title").toString();
				i++;
				System.out.println(cartname + "  ==>  " + cartdesc);
			} catch (Exception e) {
				System.out.println("End of line");
				break;
			}
		}
	}

	// @Test(dataProvider = "cartproviders")
	public void display(String cases) {
		System.out.println("=====================");
		Long id = Thread.currentThread().getId();
		System.out.println("Displaying case: " + cases + " by id: " + id);
		System.out.println("#####################");
		System.out.println(cases + " Display ended: ");
		System.out.println("=====================");
	}

	public void parseJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String path = "./Configuration/Test.json";
			String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));
//			JSONParser parser = new JSONParser(); 
//			JSONObject json = (JSONObject) parser.parse(templateContent);

			List<EventChain> eventChain = Arrays.asList(mapper.readValue(templateContent, EventChain[].class));
			eventChain.forEach(event -> {
				System.out.println(event.toString());
			});

			List<EventChain> createdEvents = eventChain.stream()
					.filter(events -> events.getExpectedorderstatus().equalsIgnoreCase("CREATED"))
					.collect(Collectors.toList());
			createdEvents.forEach(events -> {
				System.out.println(events);
			});
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void rediscache() {
		try {
			RedisCache redis = new RedisCache();
			redis.setData();
		} catch (Exception ex) {
			System.out.println("Redis blocked");
		}
	}

	public void rabbitmq()
			throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException, InterruptedException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setUri("amqp://guest:guest@localhost");
		factory.setConnectionTimeout(300000);
		com.rabbitmq.client.Connection connection = factory.newConnection();
		com.rabbitmq.client.Channel channel = connection.createChannel();
//		channel.exchangeDeclare("testexchange1", BuiltinExchangeType.DIRECT);
//		channel.exchangeBind("my-queue", "testexchange1", "insight1");
		channel.queueDeclare("myqueue94", true, false, false, null);
//		channel.queueBind("myqueue94", "testexchange1", "insight1");
		int count = 0;
		while (count < 5) {
			String message = "Message number" + count;
			channel.basicPublish("testexchange1", "insight", null, message.getBytes());
			count++;
			System.out.println("Publish message : " + message);
			Thread.sleep(5000);
		}

	}

	public void getServiceTags() {
		try {
			List<String> serviceTags = new ArrayList<>();
			String path = "./Configuration/Test.json";
			String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));

			JSONParser parser = new JSONParser();
			JSONArray json = (JSONArray) parser.parse(templateContent);
			List<Object> tags = json.stream()
					.filter(tag -> JsonPath.parse(tag.toString()).read("$.tenant").toString().contains("gbr"))
					.collect(Collectors.toList());

			tags.forEach(tag -> serviceTags.add(JsonPath.parse(tag.toString()).read("$.servicename").toString()
					+ " ==> " + JsonPath.parse(tag.toString()).read("$.qa1").toString()));
			serviceTags.forEach(System.out::println);
			System.out.println(serviceTags);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void readDeliveryMode() {
		try {
			String path = "./Configuration/Test.json";
			String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));

			JSONParser parser = new JSONParser();
			JSONArray json = (JSONArray) parser.parse(templateContent);

			int count = 0;
			while (count < 8) {
				String sku = JsonPath.parse(json).read("$[" + count + "].sku");
				String[] delModes = toStringArray(JsonPath.parse(json).read("$[" + count + "]..common_code"));

				System.out.println(sku + " --> \n");
				for (String delMode : delModes) {
					System.out.println("'" + delMode + "',");

				}
				System.out.println("=============================================");
				count++;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String[] toStringArray(net.minidev.json.JSONArray jsonArray) {
		if (jsonArray == null)
			return null;

		String[] arr = new String[jsonArray.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = jsonArray.get(i).toString();
		}
		return arr;
	}

	public void readConfiguraton() {
		try {
			String path = "./Configuration/Test.json";
			String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));
			System.out.println(templateContent);

			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(templateContent);
			System.out.println(json);

		} catch (Exception ex) {

		}
	}

	public void manageInvneotry() {
		try {
			String sku = "SM-R800NZSABTUVIR";
			Map<String, Object> sku_settings = new HashMap<>();
			sku_settings.put("sku", sku);
			sku_settings.put("max_quantity_back_order", 0);
			sku_settings.put("max_quantity_managed", 10000);
			sku_settings.put("allow_back_order", false);
			sku_settings.put("allow_order", true);
			sku_settings.put("use_managed_quantity", true);

			Map<String, Object> data = new HashMap<>();
			data.put("sku", sku);
			data.put("sku_settings", sku_settings);

			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(data);
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(jsonObject);

			System.out.println(jsonArray.toString());

		} catch (Exception ex) {

		}
	}

	public void skusCreation() {
		List<String> skus = new ArrayList<>();
		skus.add("SM-G354JB8990");
		skus.add("SM-G3547HI899");
		JSONArray skuList = new JSONArray();
		for (String sku : skus) {
			skuList.add(sku);
		}
		System.out.println(skuList.toString());
	}

	public void JSONObjectCreator() {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			File testJson = new File("/Users/ecom-shinu.mathew/eclipse-workspace/learner/Test.json");
			Map<String, String> map;
			int loop = 0;

			while (true) {
				map = new HashMap<>();
				map.put("delivery_group_id", JsonPath.parse(testJson).read("$[" + loop + "].delivery_group_id"));
				map.put("delivery_sku", JsonPath.parse(testJson).read("$[" + loop + "].delivery_modes[0].common_code"));

				json.putAll(map);
				jsonArray.add(json);
				loop++;
			}
		} catch (Exception ex) {

		}

		System.out.println(jsonArray.toJSONString());
	}

	public void PostgresReader() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/insight_demo", "postgres",
					"");
			Statement statement = con.createStatement();

			ResultSet resultSet = statement
					.executeQuery("select TestRunID, config from Test_Run where testrunid='10299'");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("TestRunID") + "--->" + resultSet.getString("config"));
			}
		} catch (Exception ex) {

		}
	}

	public void JQGrowlTest() {
		try {
			ChromeOptions options = new ChromeOptions();

			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");

			System.setProperty("webdriver.chrome.driver",
					"/Users/ecom-shinu.mathew/Documents/Insight10/Drivers/Chrome" + "/chromedriver");

			// Launch Chrome
			insightDriver = new ChromeDriver(options);
			insightDriver.manage().window().maximize();

			// Implicit Wait
			insightDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			insightDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			insightDriver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

			insightDriver.get("https://qashop.samsung.com/uk/web/cart/?&addItem[]=SM-N960FZPDBTU");
			Thread.sleep(3000);

			displayGrowl();

			Thread.sleep(13000);

			insightDriver.quit();
		} catch (Exception ex) {

		}

	}

	public static void displayGrowl() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) insightDriver;

			js.executeScript("if (!window.jQuery) {"
					+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
					+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
					+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");

			Thread.sleep(5000);

			// Use jQuery to add jquery-growl to the page
			js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

			// js.executeScript("$.getScript('/Users/NaveenKhunteta/Documents/workspace/Test/src/testcases/jquery.growl.js')");

			// Use jQuery to add jquery-growl styles to the page
			js.executeScript("$('head').append('<link rel=\"stylesheet\" "
					+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
			Thread.sleep(5000);

			// jquery-growl w/ no frills
			js.executeScript("$.growl({ title: 'GET', message: '/' });");

			// jquery-growl w/ colorized output
			js.executeScript("$.growl.error({ title: 'ERROR', message: 'Some exception is coming' });");
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		} catch (Exception ex) {

		}
	}
}

@FunctionalInterface
interface JSExecutable {
	public void JSExecutor(WebElement ele);
}

@FunctionalInterface
interface JSExecutableVoid {
	public void JSExecutor();
}

class EventChain {
	private String eventname;
	private String expectedorderstatus;
	private Boolean mandatory;
	private String[] actions;

	@JsonProperty("eventname")
	public String getEventname() {
		return eventname;
	}

	@JsonProperty("eventname")
	public void setEventname(String value) {
		this.eventname = value;
	}

	@JsonProperty("expectedorderstatus")
	public String getExpectedorderstatus() {
		return expectedorderstatus;
	}

	@JsonProperty("expectedorderstatus")
	public void setExpectedorderstatus(String value) {
		this.expectedorderstatus = value;
	}

	@JsonProperty("mandatory")
	public boolean getMandatory() {
		return mandatory;
	}

	@JsonProperty("mandatory")
	public void setMandatory(boolean value) {
		this.mandatory = value;
	}

	@JsonProperty("actions")
	public String[] getActions() {
		return actions;
	}

	@JsonProperty("actions")
	public void setActions(String[] value) {
		this.actions = value;
	}

	@Override
	public String toString() {
		return "EventChain [eventname=" + eventname + ", expectedorderstatus=" + expectedorderstatus + ", mandatory="
				+ mandatory + ", actions=" + Arrays.toString(actions) + "]";
	}

}
