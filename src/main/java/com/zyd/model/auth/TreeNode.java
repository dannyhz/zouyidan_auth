package com.zyd.model.auth;

import java.io.Serializable;
import java.util.ArrayList;

public class TreeNode
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private Integer level;
  private Boolean leaf = Boolean.TRUE;
  
  private Long parentId;
  private ArrayList<TreeNode> childrens = new ArrayList();
  private TreeNode parent;
  
  public TreeNode(Long id, String name) {
    setId(id);
    setName(name);
  }
  
  public TreeNode(Long id, String name, Boolean leaf) {
    setId(id);
    setName(name);
    setIsLeaf(leaf);
  }
  


  public void addChild(TreeNode child)
  {
    if ((child == null) || (child.getId().longValue() == this.id.longValue())) {
      return;
    }
    this.childrens.add(child);
    child.setParent(this);
    child.setParentId(this.id);
  }
  


  public void delChild(Long childId)
  {
    if ((childId == null) || (childId.longValue() == this.id.longValue())) {
      return;
    }
    for (TreeNode node : this.childrens) {
      if (node.getId().longValue() == childId.longValue()) {
        this.childrens.remove(node);
        node.setParent(null);
        node = null;
        break;
      }
      node.delChild(childId);
    }
  }
  



  public TreeNode getRoot()
  {
    if (getParent() == null) {
      return this;
    }
    return getParent().getRoot();
  }
  



  public TreeNode findChild(Long nodeId)
  {
    if (nodeId == null) {
      return null;
    }
    for (TreeNode node : this.childrens) {
      if (node.getId().longValue() == nodeId.longValue()) {
        return node;
      }
      TreeNode temp = node.findChild(nodeId);
      if (temp != null) {
        return temp;
      }
    }
    
    return null;
  }
  


  public void eachAllChild(TreeNode root, Callback callback)
  {
    callback.excute(root);
    for (TreeNode node : root.getChildrens()) {
      eachAllChild(node, callback);
    }
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }
  
  public Long getParentId() {
    return this.parentId;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public ArrayList<TreeNode> getChildrens() {
    return this.childrens;
  }
  
  public void setChildrens(ArrayList<TreeNode> childrens) {
    this.childrens = childrens;
  }
  
  public TreeNode getParent() {
    return this.parent;
  }
  
  public void setParent(TreeNode parent) {
    this.parent = parent;
  }
  
  public Integer getLevel() {
    return this.level;
  }
  
  public void setLevel(Integer level) {
    this.level = level;
  }
  
  public Boolean isLeaf() {
    return this.leaf;
  }
  
  public void setIsLeaf(Boolean leaf) {
    this.leaf = leaf;
  }
  
  public static abstract interface Callback
  {
    public abstract void excute(TreeNode paramTreeNode);
  }
}