package com.movieb.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NewlecSessionFactoryBuilder {

	static String src = "com/movieb/web/dao/mybatis/config.xml";
	static SqlSessionFactory ssf = null;
	
	static{
		InputStream is = null;		
		try {
			is = Resources.getResourceAsStream(src);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ssf = new SqlSessionFactoryBuilder().build(is);		
	}
		
	public static SqlSessionFactory getSqlsessionFactory(){
		return ssf;
	}
}
