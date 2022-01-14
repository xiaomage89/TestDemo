package nc.com.dto;

import java.util.Date;

public class NoticetableDto {
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;
    /** 公告id */
    private String id ;
    /** 表题 */
    private String ntitle ;
    /** 内容 */
    private String ncontent ;

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
    /** 公告id */
    public String getId(){
        return this.id;
    }
    /** 公告id */
    public void setId(String id){
        this.id = id;
    }
    /** 表题 */
    public String getNtitle(){
        return this.ntitle;
    }
    /** 表题 */
    public void setNtitle(String ntitle){
        this.ntitle = ntitle;
    }
    /** 内容 */
    public String getNcontent(){
        return this.ncontent;
    }
    /** 内容 */
    public void setNcontent(String ncontent){
        this.ncontent = ncontent;
    }
}
