package nc.com.dto;

import java.io.FileInputStream;
import java.util.Date;

public class GoodstableDto {
	 /** ��ƷID */
    private String id ;
    /** ���� */
    private String goodstypeId ;
    /** ��Ʒ���� */
    private String goodname ;
    /** ԭ�� */
    private Double goodoldprice ;
    /** �ּ� */
    private Double goodnewprice ;
    /** ��� */
    private Integer goodstore ;
    /** ͼƬ */
    private String goodimg ;
    /** ������ */
    private String createdBy ;
    /** ����ʱ�� */
    private Date createdTime ;
    /** ������ */
    private String updatedBy ;
    /** ����ʱ�� */
    private Date updatedTime ;

    /** ��ƷID */
    public String getId(){
        return this.id;
    }
    /** ��ƷID */
    public void setId(String id){
        this.id = id;
    }
    /** ���� */
    public String getGoodstypeId(){
        return this.goodstypeId;
    }
    /** ���� */
    public void setGoodstypeId(String goodstypeId){
        this.goodstypeId = goodstypeId;
    }
    /** ��Ʒ���� */
    public String getGoodname(){
        return this.goodname;
    }
    /** ��Ʒ���� */
    public void setGoodname(String goodname){
        this.goodname = goodname;
    }
    /** ԭ�� */
    public Double getGoodoldprice(){
        return this.goodoldprice;
    }
    /** ԭ�� */
    public void setGoodoldprice(Double goodoldprice){
        this.goodoldprice = goodoldprice;
    }
    /** �ּ� */
    public Double getGoodnewprice(){
        return this.goodnewprice;
    }
    /** �ּ� */
    public void setGoodnewprice(Double goodnewprice){
        this.goodnewprice = goodnewprice;
    }
    /** ��� */
    public Integer getGoodstore(){
        return this.goodstore;
    }
    /** ��� */
    public void setGoodstore(Integer goodstore){
        this.goodstore = goodstore;
    }
    /** ͼƬ */
    public String getGoodimg(){
        return this.goodimg;
    }
    /** ͼƬ */
    public void setGoodimg(String goodimg){
        this.goodimg = goodimg;
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
