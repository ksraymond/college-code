/*
Keaton Raymond
CS 3060-002
Question:
    write your own version of a class template that will create a binary tree 
    that can hold values of any data type. 
    demonstrate the class with a driver program

NOTE:
    assignment didn't specify a specific type of binary tree or any specific methods other than holding data
    so, i implemented a very basic binary tree that holds data and prints a pre order traversal
*/

#include <iostream>
using namespace std;

template <class T>
class Node //class that holds data and reference to left and right node for each node in tree
{
    public:
        T data;
        Node* left;
        Node* right;

        Node(T data)
        {
            this->data = data;
            this->left = this->right = nullptr;
        }
};

template <class T>
class BinaryTree
{
    public:
        Node<T>* root; //special reference for the root of the tree so that you know where to start
        
        BinaryTree()
        {
            root = nullptr;
        }

        void addNode(T data)
        {
            Node<T>* newNode = new Node<T>(data);

            if (root == nullptr) //if the tree needs a root node
                root = newNode;
            else
            {
                Node<T>* focusNode = root; //denotes the node we are looking at currently
                Node<T>* parent; //denotes the parent of the node we are currently looking at

                while(true)
                {
                    parent = focusNode;

                    if (data < focusNode->data) //if less, go down the left path
                    {
                        focusNode = focusNode->left;
                        if (focusNode == nullptr) //when find the next open slot where this node fits, assign it and return from while loop
                        {
                            parent->left = newNode;
                            return;
                        }
                    }
                    else //if greater than, go down right path
                    {
                        focusNode = focusNode->right;
                        if(focusNode == nullptr)
                        {
                            parent->right = newNode;
                            return;
                        }
                    }
                }
            }
        }

        //recursive pre order traversal method to print the contents of the tree
        void traverseTree(Node<T>* focusNode)
        {
            if(focusNode != nullptr)
            {
                cout << focusNode->data << " ";
                traverseTree(focusNode->left);
                traverseTree(focusNode->right);
            }
        }
};

int main()
{
    //create test with integer data
    BinaryTree<int> intTree;
    intTree.addNode(5);
    intTree.addNode(3);
    intTree.addNode(15);
    intTree.addNode(74);
    intTree.addNode(32);
    intTree.addNode(66);
    intTree.addNode(1);

    //create test with double data
    BinaryTree<double> doubleTree;
    doubleTree.addNode(1.231);
    doubleTree.addNode(0.41);
    doubleTree.addNode(120.3141);
    doubleTree.addNode(12.1);
    doubleTree.addNode(14.12);
    doubleTree.addNode(112.0);
    doubleTree.addNode(97.5);

    //create test with char data
    BinaryTree<char> charTree;
    charTree.addNode('a');
    charTree.addNode('b');
    charTree.addNode('r');
    charTree.addNode('q');
    charTree.addNode('z');
    charTree.addNode('p');
    charTree.addNode('k');

    //print the traversals of each test tree
    cout << "Traversal of int tree\n";
    intTree.traverseTree(intTree.root);

    cout << "\nTraversal of double tree\n";
    doubleTree.traverseTree(doubleTree.root);

    cout << "\nTraversal of char tree\n";
    charTree.traverseTree(charTree.root);

    return 0;
}