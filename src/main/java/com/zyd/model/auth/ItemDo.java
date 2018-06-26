package com.zyd.model.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.zyd.util.StringUtils;

@Alias("item")
@Table(name="sweet_auth_item")
public class ItemDo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final String ITEM_REQUESTTYPE_GET = "get";
  public static final String ITEM_REQUESTTYPE_PUT = "put";
  public static final String ITEM_REQUESTTYPE_POST = "post";
  public static final String ITEM_REQUESTTYPE_DELETE = "delete";
  @Id
  @OrderBy("DESC")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Long itemId;
  public String itemTab;
  public String itemDescription;
  public String itemUrl;
  public String itemRequestmethod;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  public Date itemCreatedon;
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  public Date itemModifiedon;
  @Transient
  public ArrayList<String> params;
  @Transient
  public String itemAllDesc;
  
  public Long getItemId()
  {
    return this.itemId;
  }
  
  public void setItemId(Long itemId)
  {
    this.itemId = itemId;
  }
  
  public String getItemTab()
  {
    return this.itemTab;
  }
  
  public void setItemTab(String itemTab)
  {
    this.itemTab = itemTab;
  }
  
  public void setItemDescription(String itemDescription)
  {
    this.itemDescription = itemDescription;
  }
  
  public String getItemUrl()
  {
    return this.itemUrl;
  }
  
  public void setItemUrl(String itemUrl)
  {
    this.itemUrl = itemUrl;
  }
  
  public Date getItemCreatedon()
  {
    return this.itemCreatedon;
  }
  
  public void setItemCreatedon(Date itemCreatedon)
  {
    this.itemCreatedon = itemCreatedon;
  }
  
  public Date getItemModifiedon()
  {
    return this.itemModifiedon;
  }
  
  public void setItemModifiedon(Date itemModifiedon)
  {
    this.itemModifiedon = itemModifiedon;
  }
  
  public String getItemRequestmethod()
  {
    return this.itemRequestmethod;
  }
  
  public void setItemRequestmethod(String itemRequestmethod)
  {
    this.itemRequestmethod = itemRequestmethod;
  }
  
  public String getItemAllDesc()
  {
    if ((StringUtils.hasText(this.itemDescription)) && (this.itemDescription.indexOf("{") > 0)) {
      return this.itemDescription.substring(0, this.itemDescription.indexOf("{"));
    }
    return this.itemDescription;
  }
  
  public String getItemDescription()
  {
    return this.itemDescription;
  }
  
  public List<String> getParams()
  {
    if (this.params == null)
    {
      this.params = new ArrayList();
      if ((StringUtils.hasText(this.itemDescription)) && (this.itemDescription.indexOf("{") > 0))
      {
        String paramStr = this.itemDescription.substring(this.itemDescription.indexOf("{") + 1, this.itemDescription.length() - 1);
        if (StringUtils.hasText(paramStr))
        {
          String[] paramArray = StringUtils.delimitedListToStringArray(paramStr, "}{");
          for (int i = 0; i < paramArray.length; i++)
          {
            String[] param = paramArray[i].split(":");
            this.params.add(param[0] + " " + (param.length > 1 ? param[1] : ""));
          }
        }
      }
    }
    return this.params;
  }
}


