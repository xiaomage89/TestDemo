package nc.com.dto;

import java.util.Date;

public class CarttableDto {
    /** ������ */
    private String createdBy ;
    /** ����ʱ�� */
    private Date createdTime ;
    /** ������ */
    private String updatedBy ;
    /** ����ʱ�� */
    private Date updatedTime ;
    /** ���ﳵid */
    private String id ;
    /** �û�id */
    private String userid ;
    /** ��Ʒid */
    private String goodstableid ;
    /** �������� */
    private Integer shoppingnum ;

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
    /** ���ﳵid */
    public String getId(){
        return this.id;
    }
    /** ���ﳵid */
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
}
