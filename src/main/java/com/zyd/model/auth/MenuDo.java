 package com.zyd.model.auth;
 
 import com.zyd.util.StringUtils;
 import com.zyd.annotation.RelationTable;
 import java.io.Serializable;
 import java.util.Date;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.OrderBy;
 import javax.persistence.Table;
 import javax.persistence.Transient;
 import org.apache.ibatis.type.Alias;
 import org.springframework.format.annotation.DateTimeFormat;
 
 @Alias("menu")
 @Table(name="sweet_auth_menu")
 public class MenuDo
   implements Serializable
 {
   private static final long serialVersionUID = 1L;
   public static final Integer MENU_TYPE_FRAMEPAGE = Integer.valueOf(1);
   public static final Integer MENU_TYPE_INNERPAGE = Integer.valueOf(2);
   public static final Integer MENU_TYPE_ITEM = Integer.valueOf(3);
   public static final Integer MENU_AUTHLEVEL_SYSTEM = Integer.valueOf(1);
   public static final Integer MENU_AUTHLEVEL_ADMIN = Integer.valueOf(2);
   public static final Integer MENU_AUTHLEVEL_NORMAL = Integer.valueOf(3);
   @Id
   @OrderBy("DESC")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   public Long menuId;
   public String menuCode;
   public Long menuParentId;
   public String menuName;
   public Integer menuType;
   public Integer menuAuthLevel;
   public Boolean menuVisibility;
   public Integer menuSerialNo;
   public String menuIconclass;
   public Long menuItemId;
   public String menuHref;
   public Boolean menuStatus;
   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
   public Date menuCreatedon;
   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
   public Date menuModifiedon;
   @Transient
   public String itemURL;
   @RelationTable(fkCol="itemId", col="menuItemId", join="left")
   @Transient
   public ItemDo sweetAuthItem;
   
   public String getMenuCode()
   {
     return this.menuCode;
   }
   
   public void setMenuCode(String menuCode)
   {
     this.menuCode = menuCode;
   }
   
   public Long getMenuId()
   {
     return this.menuId;
   }
   
   public void setMenuId(Long menuId)
   {
     this.menuId = menuId;
   }
   
   public Long getMenuParentId()
   {
     return this.menuParentId;
   }
   
   public void setMenuParentId(Long menuParentId)
   {
     this.menuParentId = menuParentId;
   }
   
   public String getMenuName()
   {
     return this.menuName;
   }
   
   public void setMenuName(String menuName)
   {
     this.menuName = menuName;
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
   
   public void setItemURL(String itemURL)
   {
     this.itemURL = itemURL;
   }
   
   public String getMenuHref()
   {
     return this.menuHref;
   }
   
   public void setMenuHref(String menuHref)
   {
     this.menuHref = menuHref;
   }
   
   public ItemDo getSweetAuthItem()
   {
     return this.sweetAuthItem;
   }
   
   public void setSweetAuthItem(ItemDo sweetAuthItem)
   {
     this.sweetAuthItem = sweetAuthItem;
   }
   
   public String getMenuIconclass()
   {
     return this.menuIconclass;
   }
   
   public void setMenuIconclass(String menuIconClass)
   {
     this.menuIconclass = menuIconClass;
   }
   
   public String getItemURL()
   {
     if ((getSweetAuthItem() != null) && (!StringUtils.hasText(this.itemURL))) {
       return getSweetAuthItem().getItemUrl();
     }
     return this.itemURL;
   }
   
   public boolean equals(Object otherObject)
   {
     if (this == otherObject) {
       return true;
     }
     if (otherObject == null) {
       return false;
     }
     if (getClass() != otherObject.getClass()) {
       return false;
     }
     MenuDo other = (MenuDo)otherObject;
     if ((this.menuId == null) || (other.getMenuId() == null)) {
       return false;
     }
     return this.menuId.longValue() == other.getMenuId().longValue();
   }
 }

