package com.nexsoft.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;

public class DataProviderAbsen {
	
	@DataProvider (parallel = false) //difalse
	public Object[][] getNexSoftData() throws Exception{
		ExtUtils ext = new CSVUtils(getPathOfTheFile("data_absen.csv"),true);
		return ext.parseData();
		
	}
	
	
	String getPathOfTheFile(String fileName) throws Exception {
        String path;
        try {
            path = getClass().getClassLoader().getResource(fileName).getPath();
        } catch (NullPointerException e) {
            throw new Exception("External TestNG dataprovider file not found");
        }
        return path;
    }
  
}
