package com.w2a.rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {


		Date d= new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenshotName);
		System.out.println(d);
		System.out.println(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\");

	}

}
