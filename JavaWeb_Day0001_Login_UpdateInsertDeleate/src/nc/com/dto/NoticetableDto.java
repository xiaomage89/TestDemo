package nc.com.dto;

import java.util.Date;

public class NoticetableDto {
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
    /** ���� */
    private String ntitle ;
    /** ���� */
    private String ncontent ;

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
    /** ���� */
    public String getNtitle(){
        return this.ntitle;
    }
    /** ���� */
    public void setNtitle(String ntitle){
        this.ntitle = ntitle;
    }
    /** ���� */
    public String getNcontent(){
        return this.ncontent;
    }
    /** ���� */
    public void setNcontent(String ncontent){
        this.ncontent = ncontent;
    }
}
