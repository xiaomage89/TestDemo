package nc.com.dto;

import java.io.FileInputStream;
import java.util.Date;

public class GoodstableDto {
	 /** 商品ID */
    private String id ;
    /** 类型 */
    private String goodstypeId ;
    /** 商品名称 */
    private String goodname ;
    /** 原价 */
    private Double goodoldprice ;
    /** 现价 */
    private Double goodnewprice ;
    /** 库存 */
    private Integer goodstore ;
    /** 图片 */
    private String goodimg ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 商品ID */
    public String getId(){
        return this.id;
    }
    /** 商品ID */
    public void setId(String id){
        this.id = id;
    }
    /** 类型 */
    public String getGoodstypeId(){
        return this.goodstypeId;
    }
    /** 类型 */
    public void setGoodstypeId(String goodstypeId){
        this.goodstypeId = goodstypeId;
    }
    /** 商品名称 */
    public String getGoodname(){
        return this.goodname;
    }
    /** 商品名称 */
    public void setGoodname(String goodname){
        this.goodname = goodname;
    }
    /** 原价 */
    public Double getGoodoldprice(){
        return this.goodoldprice;
    }
    /** 原价 */
    public void setGoodoldprice(Double goodoldprice){
        this.goodoldprice = goodoldprice;
    }
    /** 现价 */
    public Double getGoodnewprice(){
        return this.goodnewprice;
    }
    /** 现价 */
    public void setGoodnewprice(Double goodnewprice){
        this.goodnewprice = goodnewprice;
    }
    /** 库存 */
    public Integer getGoodstore(){
        return this.goodstore;
    }
    /** 库存 */
    public void setGoodstore(Integer goodstore){
        this.goodstore = goodstore;
    }
    /** 图片 */
    public String getGoodimg(){
        return this.goodimg;
    }
    /** 图片 */
    public void setGoodimg(String goodimg){
        this.goodimg = goodimg;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}
