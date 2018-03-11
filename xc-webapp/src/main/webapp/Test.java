import com.deer.model.mysql.binaryTree.NodeModel;

public class Test {

    public static void main(String[] args) {
        aa();
    }

    public static void aa(){
        NodeModel nodeModel = new NodeModel();
        nodeModel.setValue("A");

        NodeModel left1 = new NodeModel();
        left1.setValue("B");

        NodeModel left2 = new NodeModel();
        left2.setValue("C");

        left1.setLeftNode(left2);

        nodeModel.setLeftNode(left1);

        insertNode(nodeModel,"D");

        NodeModel nodeModel2 = nodeModel;
        System.out.println();
    }


    private static void insertNode(NodeModel nodeModel, String val){
        NodeModel left = nodeModel.getLeftNode();
        if(left == null){
            NodeModel chaildLeftNode = new NodeModel();
            chaildLeftNode.setValue(val);
            nodeModel.setLeftNode(chaildLeftNode);
        }else{
            insertNode(left,val);
        }
    }


}
