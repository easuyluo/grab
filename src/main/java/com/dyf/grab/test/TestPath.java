package com.dyf.grab.test;

import java.io.File;
import java.io.IOException;

public class TestPath {
	public static void main(String[] args) throws IOException {
		//当前项目下路径
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(filePath);
 
        //当前项目下xml文件夹
        File file1 = new File("");
        String filePath1 = file1.getCanonicalPath()+File.separator+"xml\\";
        System.out.println(filePath1);
 
//        //获取类加载的根路径
//        File file3 = new File(this.getClass().getResource("/").getPath());
//        System.out.println(file3);
// 
//        //获取当前类的所在工程路径
//        File file4 = new File(this.getClass().getResource("").getPath());
//        System.out.println(file4);
 
        //获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
	}
}
