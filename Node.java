import java.util.ArrayList;
import java.util.List;

public class Node<Tree> {

    private Tree data = null;

    private List<Node<Tree>> children = new ArrayList<>();

    private Node<Tree> parent = null;

    public Node(Tree data) {
        this.data = data;
    }

    public Node<Tree> addChild(Node<Tree> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<Tree>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public List<Node<Tree>> getChildren() {
        return children;
    }

    public Tree getData() {
        return data;
    }

    public void setData(Tree data) {
        this.data = data;
    }

    private void setParent(Node<Tree> parent) {
        this.parent = parent;
    }

    public Node<Tree> getParent() {
        return parent;
    }


    private static Node<String> createTree() {

        Node<String> root = new Node<>("CompilationUnit");

        Node<String> nodeNatP = root.addChild(new Node<String>("NatP"));
        Node<String> nodeNatS = root.addChild(new Node<String>("NatS"));

        // NatP Sub Tree
        Node<String> nodeNatP_KVP1 = nodeNatP.addChild(new Node<String>("Key Value Pair 1"));
        Node<String> nodeNatP_KVP1_key = nodeNatP_KVP1.addChild(new Node<String>("url"));
        Node<String> nodeNatP_KVP1_value = nodeNatP_KVP1.addChild(new Node<String>("localhost:4222"));

        Node<String> nodeNatP_KVP2 = nodeNatP.addChild(new Node<String>("Key Value Pair 2"));
        Node<String> nodeNatP_KVP2_key = nodeNatP_KVP2.addChild(new Node<String>("topic"));
        Node<String> nodeNatP_KVP2_value = nodeNatP_KVP2.addChild(new Node<String>("sample topic"));

        Node<String> nodeNatP_KVP3 = nodeNatP.addChild(new Node<String>("Key Value Pair 3"));
        Node<String> nodeNatP_KVP3_key = nodeNatP_KVP3.addChild(new Node<String>("message"));
        Node<String> nodeNatP_KVP3_value = nodeNatP_KVP3.addChild(new Node<String>("sample message"));

        // NatS Sub Tree
        Node<String> nodeNatS_KVP1 = nodeNatS.addChild(new Node<String>("Key Value Pair 1"));
        Node<String> nodeNatS_KVP1_key = nodeNatS_KVP1.addChild(new Node<String>("url"));
        Node<String> nodeNatS_KVP1_value = nodeNatS_KVP1.addChild(new Node<String>("localhost:4222"));

        Node<String> nodeNatS_KVP2 = nodeNatS.addChild(new Node<String>("Key Value Pair 2"));
        Node<String> nodeNatS_KVP2_key = nodeNatS_KVP2.addChild(new Node<String>("topic"));
        Node<String> nodeNatS_KVP2_value = nodeNatS_KVP2.addChild(new Node<String>("sample topic"));

        return root;

    }


    private static <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

    public static void main(String[] args) {
        Node<String> root = createTree();
        printTree(root, " ");
    }
}


