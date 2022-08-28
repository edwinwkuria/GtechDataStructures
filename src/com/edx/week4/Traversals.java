package com.edx.week4;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> items = new ArrayList<T>();

        if(root == null)
        {
            return items;
        }

        if(root.getLeft() == null && root.getRight() == null)
        {
            items.add(root.getData());
            return items;
        }
        items.add(root.getData());
        if(root.getLeft() != null)
        {
            items.addAll(preorder(root.getLeft()));
        }
        if(root.getRight() != null)
        {
            items.addAll(preorder(root.getRight()));
        }
        return items;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> items = new ArrayList<T>();

        if(root == null)
        {
            return items;
        }
        if(root.getLeft() == null && root.getRight() == null)
        {
            if(root.getData() != null)
            {
                items.add(root.getData());
                return items;
            }
        }

        if(root.getLeft() != null)
        {
            items.addAll(inorder(root.getLeft()));
        }

        if(root.getData() != null)
        {
            items.add(root.getData());
        }


        if(root.getRight() != null)
        {
            items.addAll(inorder(root.getRight()));
        }
        return items;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> items = new ArrayList<T>();

        if(root == null)
        {
            return items;
        }

        if(root.getLeft() == null && root.getRight() == null)
        {
            items.add(root.getData());
            return items;
        }

        if(root.getLeft() != null)
        {
            items.addAll(postorder(root.getLeft()));
        }

        if(root.getRight() != null)
        {
            items.addAll(postorder(root.getRight()));
        }

        if(root.getData() != null) {
            items.add(root.getData());
        }

        return items;

    }


}