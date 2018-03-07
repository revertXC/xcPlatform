package com.deer.mapper.utils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行完 mybatis generator之后再执行
 * 将generator 自动生成的代码 转化成本系统架构
 */
public class SecondExecGenerator {

//    private static String baseEntityClass = "com.deer.common.base.BaseEntity";
    private static String baseEntityClass = "com.deer.shiro.base.BaseEntityShiro";
    private static String entityPath = "D:/xiecong/git/xcPlatform/xc-shiro/src/main/" +
                                        "java/com/deer/shiro/model/Permission.java";
    public static void main(String[] args) {
//        ChangeEntity();
    }

    /**
     * 更改自动生成的model类
     */
    public static void ChangeEntity(){
        List<String> fieldNames = new ArrayList<String>();
        List<String> methodNames = new ArrayList<String>();
        try{
            Class clazz = Class.forName(baseEntityClass);
            Field fs[] = clazz.getDeclaredFields();
            Method ms[] = clazz.getDeclaredMethods();
            for(Field f : fs){
                fieldNames.add(f.getName());
            }
            for(Method m : ms){
                methodNames.add(m.getName());
            }
            File file = new File(entityPath);
            ChangeEntity2(file,fieldNames,methodNames,clazz.getSimpleName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 更改自动生成的model类
     */
    public static void ChangeEntity2(File file,List<String> fieldNames,List<String> methodNames, String extendsName){

        try{

            if(file.isDirectory()){//是个文件夹
                File fs[] = file.listFiles();
                for(File f : fs){
                    ChangeEntity2(f,fieldNames,methodNames,extendsName);
                }
            }else{ //不是文件夹
                StringBuffer newContent = new StringBuffer();
                BufferedReader br = new BufferedReader(new FileReader(file));
                String currentContent = null;
                boolean flagBegin = false;
                while( (currentContent = br.readLine()) != null ){
                    boolean flagCheck = true;
                    if(flagBegin){
                        for(String fieldName : fieldNames){
                            if(currentContent.indexOf("this") < 0 && currentContent.indexOf("return") < 0 && currentContent.indexOf(")") < 0 && currentContent.indexOf(fieldName) >= 0){ //如果当前行有该字段
                                flagCheck = false;
                                break;
                            }
                        }

                        if(flagCheck){
                            for(String methodName : methodNames){
                                if(currentContent.indexOf(methodName) >= 0){ //如果当前行有方法
                                    boolean flagMethod = true;
                                    flagCheck = false;
                                    while(flagMethod){
                                        String aa = br.readLine();
                                        if(aa.indexOf("}") >= 0 ){
                                            flagMethod = false;
                                        }
                                    }
                                    break;
                                }
                            }
                            if(flagCheck) {
                                if(!currentContent.equals(""))
                                    newContent.append(currentContent).append(System.getProperty("line.separator"));
                            }
                        } /* END if(flagCheck)*/

                    } /*END if(flagBegin)*/
                    else{

                        if(currentContent.indexOf("public class") >= 0){
                            String className = file.getName().substring(0,file.getName().indexOf("."));
                            currentContent = currentContent.replaceFirst(className ,className+" extends "+extendsName);
                            currentContent = "import "+baseEntityClass+";"+System.getProperty("line.separator")+System.getProperty("line.separator")+currentContent;
                            flagBegin = true;
                        }
                        newContent.append(currentContent).append(System.getProperty("line.separator"));
                    }

                }

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(newContent.toString());
                bufferedWriter.flush();
                bufferedWriter.close();
                newContent.setLength(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
