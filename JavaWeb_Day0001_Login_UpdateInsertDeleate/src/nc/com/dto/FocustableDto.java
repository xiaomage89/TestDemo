package nc.com.dto;

import java.util.Date;

public class FocustableDto {
    /** ������ */
    private String createdBy ;
    /** ����ʱ�� */
    private Date createdTime ;
    /** ������ */
    private String updatedBy ;
    /** ����ʱ�� */
    private Date updatedTime ;
    /** ��עid */
    private String id ;
    /** �û�id */
    private String userid ;
    /** ��Ʒid */
    private String goodstableid ;
    /** ��עʱ�� */
    private Date focustime ;

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
    /** ��עid */
    public String getId(){
        return this.id;
    }
    /** ��עid */
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
    /** ��עʱ�� */
    public Date getFocustime(){
        return this.focustime;
    }
    /** ��עʱ�� */
    public void setFocustime(Date focustime){
        this.focustime = focustime;
    }
}
