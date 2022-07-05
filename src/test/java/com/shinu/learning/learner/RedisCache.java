package com.shinu.learning.learner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisCache {

	private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;
    
    private static JedisPool pool = null;
    
    public RedisCache() {       
        pool = new JedisPool(redisHost, redisPort);
    }
    
    public void setData() throws IOException {
    	String key = "GBRDD174450814";
    	String value = getValue("./Configuration/Test.json");
    	
    	Jedis jedis = pool.getResource();
    	jedis.set(key, value);
    	
    	System.out.println(jedis.get(key));
    }
    
    private String getValue(String pathloca) throws IOException {
    	String path = pathloca;
		String templateContent = new String(Files.readAllBytes(Paths.get(path.toString())));
		return templateContent;
    }
}
