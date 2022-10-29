package com.hasanali.datastructures;

public class BinarySearchTree {

    NodeBinary root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertWithRecursive(int key) {
        root = insertRec(root,key);
    }

    public NodeBinary insertRec(NodeBinary root, int data) {
        if(root == null) {
            root = new NodeBinary(data);
            return root;
        } else {
            if(data < root.data) {
                root.left = insertRec(root.left, data);
            } else if(data > root.data) {
                root.right = insertRec(root.right, data);
            }
            return root;
        }
    }

    public void insertWithLoop(int data) {
        NodeBinary newNode = new NodeBinary(data);

        if(root == null) {
            root = newNode;
            return;
        } else {
            NodeBinary current = root;
            NodeBinary parent = null;

            while(true) {
                parent = current;
                if(data < current.data) {
                    current = current.left;
                    if(current == null) {
                        parent.left =newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void preorder() {
        preorder(root);
    }
    public void preorder(NodeBinary root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder() {
        inorder(root);
    }
    public void inorder(NodeBinary node) {
        if(root == null) {
            System.out.println("a�a� bo�");
            return;
        } else {
            if(node.left != null) {
                inorder(node.left);
            }
            System.out.println(node.data + " ");
            if(node.right != null) {
                inorder(node.right);
            }
        }
    }

    public void postorder() {
        postorder(root);
    }
    public void postorder(NodeBinary node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data + " ");
    }

    // arama
    public void search(int key) {
        search(root,key);
    }
    private boolean search(NodeBinary root, int data) {
        if(root == null) {
            return false;
        } else if(root.data == data) {
            return true;
        } else if (root.data > data) {
            return search(root.left,data);
        }
        return search(root.right,data);
    }

    // min deger
    public int minValue(NodeBinary root) {
        if(root == null) {
            return -1;
        } else {
            int minv = root.data;
            while(root.left != null) {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }
    }

    // max deger
    public int maxValue(NodeBinary root) {
        if(root == null) {
            return -1;
        } else {
            int maxv = root.data;
            while(root.right != null) {
                maxv = root.right.data;
                root = root.right;
            }
            return maxv;
        }
    }

    public NodeBinary deleteRec(NodeBinary node,int key) {
        if(root == null) {
            return root;
        }
        if(key < root.data) {
            root.left = deleteRec(root.left,key);
        } else if(key >	root.data) {
            root.right = deleteRec(root.right,key);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRec(root.right,root.data);
        }
        return root;
    }
}

class NodeBinary {
    int data;
    NodeBinary left;
    NodeBinary right;
    public NodeBinary(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}