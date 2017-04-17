package com.shuizd.yaco.validator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Person p = new Person();
		p.setId("1");
		p.setName("yaco");
		Groups g = new Groups();
		g.setNo("1232");
		p.setGroup(g);
		new Test().reflect(p);
//		MsgXmlValidator<Person> pp = new MsgXmlValidator<Person>();
//		pp.validate(p);
		
	}
	
	public void reflect(Object model){
		try{
			System.out.println(model.getClass());
			Field[] fs = model.getClass().getDeclaredFields();  
			for(Field field : fs){  
				String name = field.getName(); // 获取属性的名字
		        name = name.substring(0, 1).toUpperCase() + name.substring(1);
	            String type = field.getGenericType().toString(); // 获取属性的类型
	            if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
	                Method m = model.getClass().getMethod("get" + name);
	                String value = (String) m.invoke(model); // 调用getter方法获取属性值
	                System.out.println(value);
//	                if (value == null) {
//	                    m = model.getClass().getMethod("set"+name,String.class);
//	                    m.invoke(model, "");
//	                }
	            }else{
	            	Method method = model.getClass().getMethod("get" + name);
	                Object nextObj = method.invoke(model); 
	                Field[] fs2 = nextObj.getClass().getDeclaredFields();
	                for(Field f : fs2){  
	                	String names = f.getName(); // 获取属性的名字
	    		        names = names.substring(0, 1).toUpperCase() + names.substring(1);
	    	            String types = f.getGenericType().toString(); // 获取属性的类型
	    	            Method ms = nextObj.getClass().getMethod("get" + names);
		                String values = (String) ms.invoke(nextObj); // 调用getter方法获取属性值
		                System.out.println("###"+values);
	                }
	            }
	        } 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
