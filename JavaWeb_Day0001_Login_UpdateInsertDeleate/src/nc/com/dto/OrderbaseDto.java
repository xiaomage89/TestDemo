package nc.com.dto;

import java.util.Date;

public class OrderbaseDto {
	   /** ������ */
    private String createdBy ;
    /** ����ʱ�� */
    private Date createdTime ;
    /** ������ */
    private String updatedBy ;
    /** ����ʱ�� */
    private Date updatedTime ;
    /** ����id */
    private String id ;
    /** �û�id */
    private String userid ;
    /** ��Ʒid */
    private String goodstableid ;
    /** �������� */
    private Integer shoppingnum ;
    /** ������� */
    private Double amount ;
    /** ����״̬ */
    private Integer status ;
    /** �µ�ʱ�� */
    private String untitled2 ;

    /** ������ */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** ������ */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** ����ʱ�� */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** ����ʱ�� */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** ������ */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** ������ */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** ����ʱ�� */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** ����ʱ�� */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
    /** ����id */
    public String getId(){
        return this.id;
    }
    /** ����id */
    public void setId(String id){
        this.id = id;
    }
    /** �û�id */
    public String getUserid(){
        return this.userid;
    }
    /** �û�id */
    public void setUserid(String userid){
        this.userid = userid;
    }
    /** ��Ʒid */
    public String getGoodstableid(){
        return this.goodstableid;
    }
    /** ��Ʒid */
    public void setGoodstableid(String goodstableid){
        this.goodstableid = goodstableid;
    }
    /** �������� */
    public Integer getShoppingnum(){
        return this.shoppingnum;
    }
    /** �������� */
    public void setShoppingnum(Integer shoppingnum){
        this.shoppingnum = shoppingnum;
    }
    /** ������� */
    public Double getAmount(){
        return this.amount;
    }
    /** ������� */
    public void setAmount(Double amount){
        this.amount = amount;
    }
    /** ����״̬ */
    public Integer getStatus(){
        return this.status;
    }
    /** ����״̬ */
    public void setStatus(Integer status){
        this.status = status;
    }
    /** �µ�ʱ�� */
    public String getUntitled2(){
        return this.untitled2;
    }
    /** �µ�ʱ�� */
    public void setUntitled2(String untitled2){
        this.untitled2 = untitled2;
    }
}
