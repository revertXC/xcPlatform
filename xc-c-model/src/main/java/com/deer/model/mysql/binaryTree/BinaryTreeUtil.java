package com.deer.model.mysql.binaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 二叉树 工具
 */
public class BinaryTreeUtil {

    /**
     * 默认初始化
     * @param array        树值
     * @param rootPlace    根节点位置
     */
    public static void defaultInit(String array[], Integer rootPlace){
        String rootVal = null;
        try{
            rootVal = array[rootPlace];
        }catch (Exception e){
            System.out.println("根节点出现异常");
            e.printStackTrace();
        }
        NodeModel rootNode = new NodeModel();
        rootNode.setValue(rootVal);
        List<String> listNodeVal = Arrays.asList(array);
        //移除根节点
        listNodeVal.remove(rootPlace);
        //排序 升序 从小到大
        Collections.sort(listNodeVal);

    }

    private static void insertNode(NodeModel rootNode, List<String> data){
        if(data.size() <= 0){
            return;
        }
        Iterator<String> ite = data.iterator();
        while(ite.hasNext()){

            boolean flag = true;
            while (flag){

            }

        }
    }


    private static void aaa(NodeModel node, String val, Integer type){
        NodeModel newNode = new NodeModel();
        if(type == 0){ //左子树
            NodeModel cureentNode = node.getLeftNode();
            if(cureentNode.getValue() == null){
                cureentNode.setValue(val);
                return;
            }else{

            }
        }else{ //右子树

        }
    }

}
