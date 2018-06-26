 package com.zyd.model.auth;
 
 import com.zyd.model.auth.MenuDo;
 import com.zyd.model.auth.TreeNode;
 import com.zyd.util.CollectionUtils;
 import java.util.Date;
 import java.util.List;
 import org.springframework.beans.BeanUtils;
 
 public class MenuNode
   extends TreeNode
 {
   private static final long serialVersionUID = 1L;
   public Integer menuType;
   public Integer menuAuthLevel;
   public Boolean menuVisibility;
   public Integer menuSerialNo;
   public Long menuItemId;
   public String menuIconclass;
   public String menuHref;
   public Boolean menuStatus;
   public Date menuCreatedon;
   public Date menuModifiedon;
   public String itemURL;
   public String menuCode;
   
   public MenuNode(Long id, String name)
   {
     super(id, name);
   }
   
   public MenuNode(Long id, String name, Boolean leaf)
   {
     super(id, name, leaf);
   }
   
   public static MenuNode genMenuNode(List<MenuDo> menulist, MenuDo menu, int level)
   {
     if ((menu == null) || (CollectionUtils.isEmpty(menulist))) {
       return null;
     }
     MenuNode node = new MenuNode(menu.getMenuId(), menu.getMenuName());
     BeanUtils.copyProperties(menu, node);
     node.setLevel(Integer.valueOf(level++));
     if (level > 100) {
       throw new RuntimeException("base.treelevel.toodeep");
     }
     if (menu.getMenuId() == null) {
       node.setId(Long.valueOf(2L));
     }
     for (MenuDo menuDo : menulist) {
       if ((menuDo.getMenuParentId() != null) && (node.getId().longValue() == menuDo.getMenuParentId().longValue()))
       {
         MenuNode childNode = genMenuNode(menulist, menuDo, level);
         if (childNode != null) {
           node.addChild(childNode);
         }
       }
     }
     return node;
   }
   
   public String getMenuCode()
   {
     return this.menuCode;
   }
   
   public void setMenuCode(String menuCode)
   {
     this.menuCode = menuCode;
   }
   
   public Integer getMenuType()
   {
     return this.menuType;
   }
   
   public void setMenuType(Integer menuType)
   {
     this.menuType = menuType;
   }
   
   public Integer getMenuAuthLevel()
   {
     return this.menuAuthLevel;
   }
   
   public void setMenuAuthLevel(Integer menuAuthLevel)
   {
     this.menuAuthLevel = menuAuthLevel;
   }
   
   public Boolean getMenuVisibility()
   {
     return this.menuVisibility;
   }
   
   public void setMenuVisibility(Boolean menuVisibility)
   {
     this.menuVisibility = menuVisibility;
   }
   
   public Integer getMenuSerialNo()
   {
     return this.menuSerialNo;
   }
   
   public void setMenuSerialNo(Integer menuSerialNo)
   {
     this.menuSerialNo = menuSerialNo;
   }
   
   public Long getMenuItemId()
   {
     return this.menuItemId;
   }
   
   public void setMenuItemId(Long menuItemId)
   {
     this.menuItemId = menuItemId;
   }
   
   public String getMenuHref()
   {
     return this.menuHref;
   }
   
   public void setMenuHref(String menuHref)
   {
     this.menuHref = menuHref;
   }
   
   public Boolean getMenuStatus()
   {
     return this.menuStatus;
   }
   
   public void setMenuStatus(Boolean menuStatus)
   {
     this.menuStatus = menuStatus;
   }
   
   public Date getMenuCreatedon()
   {
     return this.menuCreatedon;
   }
   
   public void setMenuCreatedon(Date menuCreatedon)
   {
     this.menuCreatedon = menuCreatedon;
   }
   
   public Date getMenuModifiedon()
   {
     return this.menuModifiedon;
   }
   
   public void setMenuModifiedon(Date menuModifiedon)
   {
     this.menuModifiedon = menuModifiedon;
   }
   
   public String getItemURL()
   {
     return this.itemURL;
   }
   
   public void setItemURL(String itemURL)
   {
     this.itemURL = itemURL;
   }
   
   public String getMenuIconclass()
   {
     return this.menuIconclass;
   }
   
   public void setMenuIconclass(String menuIconClass)
   {
     this.menuIconclass = menuIconClass;
   }
 }


