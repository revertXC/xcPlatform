package com.deer.common.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.ZipInputStream;

public class DoMain {
    public static void main(String[] args) throws Exception {
        System.out.println("开始解压！");
        Long startTime = System.currentTimeMillis();
//        ZipUtil.unZip("test.zip","F:\\1");

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File("F:\\1\\test.zip")) );
        ZipUtil.unZipTwo("F:\\1", zipInputStream);

        Long endTime = System.currentTimeMillis();
        System.out.println("解压完毕,耗时;"+(endTime-startTime));
    }
}
