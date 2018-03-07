package com.deer.common.utils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtil {


    /**
     * 解压 ZIp文件
     * @param fileName  文件名
     * @param descDir   目标路径
     */
    public static void unZip(String fileName, String descDir){
        String filePath = descDir+"\\"+fileName;
        System.out.println(filePath);
        boolean isEmptyFilePath = StringUtils.isEmpty(filePath);
        if(isEmptyFilePath || (!isEmptyFilePath && filePath.lastIndexOf(".zip") < 0)){
            System.out.println("com.deer.common.utils.ZipUtil.java -------Error 请传入需要解压的Zip文件");
            return;
        }

        try{
            File file = new File(filePath);
            ZipFile zipFile = new ZipFile(file, Charset.forName("UTF-8"));
            Enumeration<? extends ZipEntry> entries = zipFile.entries(); //获取ZIp下所有的文件
            while(entries.hasMoreElements()){
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String entrynName = entry.getName();
                file = new File(descDir+"\\"+entrynName);
                if(entry.isDirectory()){
                    if(!file.exists())
                        file.mkdirs();
                    continue;
                }
                file.createNewFile();
                InputStream in = zipFile.getInputStream(entry);
                FileOutputStream out = new FileOutputStream(file);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                    out.flush();
                }
                out.flush();
                out.close();
                in.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("解压完毕");

    }


    /**
     * 递归解压，文件一多容易栈溢出
     */




    public static void unZipTwo(String baseFilePath,ZipInputStream zipInputStream){
        try{
            // 获取 zip 的文件
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            if(zipEntry == null){
                return;
            }
            String entryName = zipEntry.getName();
            File file = new File(baseFilePath+"\\"+entryName);
            if(zipEntry.isDirectory()){
                file.mkdirs();
                unZipTwo(baseFilePath, zipInputStream);
            }else{
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = zipInputStream.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                    out.flush();
                }
                out.flush();
                out.close();
                unZipTwo(baseFilePath, zipInputStream);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
