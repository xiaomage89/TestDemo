package nc.com.dto;


import java.util.Date;

public class GoodstypeDto {

    private Integer id ;
    /** �������� */
    private String typename ;
    /** ������ */
    private String createdBy ;
    /** ����ʱ�� */
    private Date createdTime ;
    /** ������ */
    private String updatedBy ;
    /** ����ʱ�� */
    private Date updatedTime ;

    /** ��ƷID */
    public Integer getId(){
        return this.id;
    }
    /** ��ƷID */
    public void setId(Integer id){
        this.id = id;
    }
    /** �������� */
    public String getTypename(){
        return this.typename;
    }
    /** �������� */
    public void setTypename(String typename){
        this.typename = typename;
    }
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
}
