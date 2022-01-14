package nc.com.dto;

import java.util.Date;

public class OrderbaseDto {
	   /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;
    /** 订单id */
    private String id ;
    /** 用户id */
    private String userid ;
    /** 商品id */
    private String goodstableid ;
    /** 购买数量 */
    private Integer shoppingnum ;
    /** 订单金额 */
    private Double amount ;
    /** 订单状态 */
    private Integer status ;
    /** 下单时间 */
    private String untitled2 ;

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
    /** 订单id */
    public String getId(){
        return this.id;
    }
    /** 订单id */
    public void setId(String id){
        this.id = id;
    }
    /** 用户id */
    public String getUserid(){
        return this.userid;
    }
    /** 用户id */
    public void setUserid(String userid){
        this.userid = userid;
    }
    /** 商品id */
    public String getGoodstableid(){
        return this.goodstableid;
    }
    /** 商品id */
    public void setGoodstableid(String goodstableid){
        this.goodstableid = goodstableid;
    }
    /** 购买数量 */
    public Integer getShoppingnum(){
        return this.shoppingnum;
    }
    /** 购买数量 */
    public void setShoppingnum(Integer shoppingnum){
        this.shoppingnum = shoppingnum;
    }
    /** 订单金额 */
    public Double getAmount(){
        return this.amount;
    }
    /** 订单金额 */
    public void setAmount(Double amount){
        this.amount = amount;
    }
    /** 订单状态 */
    public Integer getStatus(){
        return this.status;
    }
    /** 订单状态 */
    public void setStatus(Integer status){
        this.status = status;
    }
    /** 下单时间 */
    public String getUntitled2(){
        return this.untitled2;
    }
    /** 下单时间 */
    public void setUntitled2(String untitled2){
        this.untitled2 = untitled2;
    }
}
