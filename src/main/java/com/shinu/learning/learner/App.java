package com.shinu.learning.learner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		int[] test = {0 ,1 ,4, 5, 7, 8};
		System.out.println(test.length);
	}

	public static void ReadJSON() throws FileNotFoundException, ParseException {
		String path = "./Test.json";

		String pathname = Paths.get(path.toString()).toString();

		File inputFile = new File(pathname);

		FileReader reader = new FileReader(inputFile);

		JSONParser jsonParse = new JSONParser();
		JSONObject redirect = (JSONObject) jsonParse.parse(reader);

		String transactionIDJsonPath = "$.payment..transaction_info.id";
		String transactionID = JsonPath.read(redirect, transactionIDJsonPath);
	}
}
