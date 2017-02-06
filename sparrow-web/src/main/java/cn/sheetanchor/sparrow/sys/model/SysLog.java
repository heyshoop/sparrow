package cn.sheetanchor.sparrow.sys.model;

import cn.sheetanchor.common.utils.IdGen;
import cn.sheetanchor.common.utils.StringUtils;
import cn.sheetanchor.common.utils.UserUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 日志表
 */
@Entity
@Table(name = "sys_log")
public class SysLog implements Serializable{
    private static final long serialVersionUID = 5118866556439600553L;
    private String id;
    private String type;
    private String title;
    private Date createDate;
    private String remoteAddr;
    private String userAgent;
    private String requestUri;
    private String method;
    private String params;
    private String exception;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "remote_addr")
    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    @Basic
    @Column(name = "user_agent")
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Basic
    @Column(name = "request_uri")
    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    @Basic
    @Column(name = "method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "params")
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Basic
    @Column(name = "exception")
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysLog sysLog = (SysLog) o;

        if (id != null ? !id.equals(sysLog.id) : sysLog.id != null) return false;
        if (type != null ? !type.equals(sysLog.type) : sysLog.type != null) return false;
        if (title != null ? !title.equals(sysLog.title) : sysLog.title != null) return false;
        if (createBy != null ? !createBy.equals(sysLog.createBy) : sysLog.createBy != null) return false;
        if (createDate != null ? !createDate.equals(sysLog.createDate) : sysLog.createDate != null) return false;
        if (remoteAddr != null ? !remoteAddr.equals(sysLog.remoteAddr) : sysLog.remoteAddr != null) return false;
        if (userAgent != null ? !userAgent.equals(sysLog.userAgent) : sysLog.userAgent != null) return false;
        if (requestUri != null ? !requestUri.equals(sysLog.requestUri) : sysLog.requestUri != null) return false;
        if (method != null ? !method.equals(sysLog.method) : sysLog.method != null) return false;
        if (params != null ? !params.equals(sysLog.params) : sysLog.params != null) return false;
        if (exception != null ? !exception.equals(sysLog.exception) : sysLog.exception != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (remoteAddr != null ? remoteAddr.hashCode() : 0);
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (requestUri != null ? requestUri.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + (exception != null ? exception.hashCode() : 0);
        return result;
    }

    // 日志类型（1：接入日志；2：错误日志）
    public static final String TYPE_ACCESS = "1";
    public static final String TYPE_EXCEPTION = "2";
    private SysUser updateBy;//更新人
    private SysUser createBy;

    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    public SysUser getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(SysUser updateBy) {
        this.updateBy = updateBy;
    }

    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    public SysUser getCreateBy() {
        return createBy;
    }

    public void setCreateBy(SysUser createBy) {
        this.createBy = createBy;
    }

    /**
     * 设置请求参数
     * @param paramMap
     */
    @Transient
    public void setParams(Map paramMap){
        if (paramMap == null){
            return;
        }
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> param : ((Map<String, String[]>)paramMap).entrySet()){
            params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            params.append(StringUtils.abbr(StringUtils.endsWithIgnoreCase(param.getKey(), "password") ? "" : paramValue, 100));
        }
        this.params = params.toString();
    }
    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;
    /**
     * 插入之前执行方法，需要手动调用
     */
    @Transient
    public void preInsert(){
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord){
            setId(IdGen.uuid());
        }
        SysUser user = UserUtils.getUser();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(user.getId())){
            this.updateBy = user;
            this.createBy = user;
        }
        this.createDate = new Date();
    }
}
