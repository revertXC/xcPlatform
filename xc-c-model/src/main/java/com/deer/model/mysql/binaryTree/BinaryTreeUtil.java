package com.deer.model.mysql.binaryTree;

import javax.xml.soap.Node;
import java.util.*;

/**
 * 二叉树 工具
 */
public class BinaryTreeUtil {

    public static void main(String[] args) {
//        String array[] = {"2","6","10","15","1","3","3","4"};
//        String array[] ={"9","8","7","6","10","20","18","17"};

        int rootPlace = 0;

//        String array[] = {"10","30","36","40","50","66","80","86","99","100","100","120","185","165","190"};

        String array[] = {"A", "B", "C", "D"};

        NodeModel nodeModel = getCaseNodeModel(array, rootPlace);
    }

    public static NodeModel getCaseNodeModel(String array[], int rootPlace){
        List<String> list = Arrays.asList(array);
        NodeModel rootNode = new NodeModel();
        rootNode.setValue(list.get(rootPlace));
        Map<String, List<String>> map = getDataGroup(list,rootPlace);
        List<String> listMin = map.get("min");
        List<String> listMax = map.get("max");

        Iterator<String> iteMin = listMin.iterator();
        while(iteMin.hasNext()){
            insertLeftNode(rootNode,iteMin.next(), iteMin.hasNext() ? iteMin.next() : null);
        }

        boolean flag = true;
        Iterator<String> iteMan = listMax.iterator();
        while(iteMan.hasNext()){
            if(flag)
                flag = initInsertRightNode(rootNode,iteMan.next(), iteMan.hasNext() ? iteMan.next() : null, flag);
            else
                insertLeftNode(rootNode.getRightNode(),iteMan.next(), iteMan.hasNext() ? iteMan.next() : null);
        }
        return rootNode;
    }


    /**
     * 插左子树 中的左节点在插左节点中的右节点
     * @param nodeModel
     * @param bigVal
     * @param littleVal
     */
    private static void insertLeftNode(NodeModel nodeModel, String bigVal, String littleVal){
        NodeModel leftNode = nodeModel.getLeftNode();
        if(leftNode == null){
            leftNode = new NodeModel();
            if(littleVal != null){
                leftNode.setValue(littleVal);
                NodeModel leftNodeRightNode = new NodeModel();
                leftNodeRightNode.setValue(bigVal);
                leftNode.setRightNode(leftNodeRightNode);
            }else{
                leftNode.setValue(bigVal);
            }
            nodeModel.setLeftNode(leftNode);
        }else{
            insertLeftNode(nodeModel.getLeftNode(),bigVal,littleVal);
        }
    }

    /**
     * 初始化添加 右子树 右节点
     * @param nodeModel
     * @param bigVal
     * @param littleVal
     * @param flag
     * @return
     */
    private static boolean initInsertRightNode(NodeModel nodeModel, String bigVal, String littleVal, boolean flag){
        if(flag){
            flag = false;
            NodeModel rightNode = nodeModel.getRightNode();
            if(rightNode == null){
                rightNode = new NodeModel();
                if(littleVal != null){
                    rightNode.setValue(littleVal);
                    NodeModel rightNodeRightNode = new NodeModel();
                    rightNodeRightNode.setValue(bigVal);
                    rightNode.setRightNode(rightNodeRightNode);
                }else{
                    rightNode.setValue(bigVal);
                }
                nodeModel.setRightNode(rightNode);
            }
        }
        return flag;
    }

    /**
     *  大于等于根值 存放 listMax 小于根值 存放listMin
     * @param list
     * @param rootPlace
     * @return
     */
    private static Map<String, List<String>> getDataGroup(List<String> list, int rootPlace){
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        List<String> listMin = new LinkedList<String>();
        List<String> listMax = new LinkedList<String>();
        // 从小到大排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.hashCode() >= o2.hashCode())
                    return 1;
                else
                    return -1;
            }
        });
        String rootVal = list.get(rootPlace);
        for(int i=list.size()-1  ; i>=0 ; i--){
            if(i == rootPlace)
                continue;
            String currentVal = list.get(i);
            if(currentVal.hashCode() >= rootVal.hashCode())
                listMax.add(currentVal);
            else
                listMin.add(currentVal);
        }

        map.put("min",listMin);
        map.put("max",listMax);
        return map;
    }


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
        /**
         * java.lang.UnsupportedOperationException是不支持功能异常，常常出现在使用Arrays.asList()后调用add，
         * remove这些method时。这是由于：Arrays.asList() 返回java.util.Arrays$ArrayList，
         * 而不是ArrayList。Arrays$ArrayList和ArrayList都是继承AbstractList，remove，add等
         * method在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
         * ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override
         * remove(int)，add(int)等，所以throw UnsupportedOperationException。 解决方法是使用Iterator，或者转换为ArrayList。
         */
        List<String> asList = Arrays.asList(array);
        List<String> listNodeVal = new ArrayList<String>();
        listNodeVal.addAll(asList);
        //移除根节点
        listNodeVal.remove((int)rootPlace);
        //排序 升序 从小到大
        Collections.sort(listNodeVal);

        for(String val : listNodeVal){
            inserLeftNode(rootNode,val);
        }
        System.out.println();
    }


    private static void insert(NodeModel nodeModel, String val){
        //获取当前 节点的Val
        String currentNodeVal = nodeModel.getValue();
        if(currentNodeVal.hashCode() >= val.hashCode()){
            inserLeftNode(nodeModel,val);
        }else{
            inserRightNode(nodeModel,val);
        }
    }

    /**
     * 添加到左节点
     * @param nodeModel
     * @param val
     */
    private static void inserLeftNode(NodeModel nodeModel, String val){
        NodeModel right = nodeModel.getRightNode();
        NodeModel left = nodeModel.getLeftNode();
        String currentNodeVal = nodeModel.getValue();
        //如果  当前节点值 小于 插入的值 则往左子树添加
        if(currentNodeVal.hashCode() >= val.hashCode()){
            //如果子节点为空 优先满足左节点
            if(left == null){
                NodeModel chaildLeftNode = new NodeModel();
                chaildLeftNode.setValue(val);
                nodeModel.setLeftNode(chaildLeftNode);
            }else if(left != null && right == null){ /*如果左子树 左节点有值 插入又节点*/
                NodeModel chaildRightNode = new NodeModel();
                chaildRightNode.setValue(val);
                nodeModel.setRightNode(chaildRightNode);
            }else{
                inserLeftNode(left,val);
            }
        }else{
            //如果子节点为空 优先满足左节点
            if(right == null){
                NodeModel chaildRightNode = new NodeModel();
                chaildRightNode.setValue(val);
                nodeModel.setRightNode(chaildRightNode);
            }else if(right != null && left == null){ /*如果左子树 左节点有值 插入又节点*/
                NodeModel chaildLeftNode = new NodeModel();
                chaildLeftNode.setValue(val);
                nodeModel.setLeftNode(chaildLeftNode);
            }else{
                inserLeftNode(right,val);
            }
        }

    }

    /**
     * 添加到 右节点
     * @param nodeModel
     * @param val
     */
    private static void inserRightNode(NodeModel nodeModel, String val){
        NodeModel right = nodeModel.getRightNode();
        if(right == null){
            NodeModel chaildRightNode = new NodeModel();
            chaildRightNode.setValue(val);
            nodeModel.setRightNode(chaildRightNode);
        }else{
            inserRightNode(right,val);
        }
    }


}
