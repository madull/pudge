package com.pudge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * 配置文件读写类
 * @author Aiuracraft
 *
 */
public class ConfigFile
{
	static Logger log  =  Logger.getLogger(ConfigFile. class );
	/** 
	 * 读取配置文件 
	 * LiChaofei 
	 * 2013-1-31 上午9:10:07 
	 * @return 
	 */  
	public static String getProperty(String configFile,String key,String defaultValue){  
		return new ConfigFile().loadProperty(configFile).getProperty(key, defaultValue);
	}  
	
	
	public Properties loadProperty(String configFile) {  
	    Properties prop=new Properties();  
	    try {  
	        InputStream is=this.getClass().getResourceAsStream("/"+configFile+".properties");  
	        prop.load(is);  
	        is.close();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    return prop;  
	}  
}