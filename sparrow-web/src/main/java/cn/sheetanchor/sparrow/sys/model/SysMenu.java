package cn.sheetanchor.sparrow.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 菜单表
 */
@Entity
@Table(name = "sys_menu")
public class SysMenu implements Serializable{
    private static final long serialVersionUID = 6163615719734466294L;
    private String id;
    private String parentId;
    private String parentIds;
    private String name;
    private int sort;
    private String href;
    private String target;
    private String icon;
    private String isShow;
    private String permission;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String delFlag;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "parent_ids")
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sort")
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "href")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Basic
    @Column(name = "target")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "is_show")
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "del_flag")
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysMenu sysMenu = (SysMenu) o;

        if (sort != sysMenu.sort) return false;
        if (id != null ? !id.equals(sysMenu.id) : sysMenu.id != null) return false;
        if (parentId != null ? !parentId.equals(sysMenu.parentId) : sysMenu.parentId != null) return false;
        if (parentIds != null ? !parentIds.equals(sysMenu.parentIds) : sysMenu.parentIds != null) return false;
        if (name != null ? !name.equals(sysMenu.name) : sysMenu.name != null) return false;
        if (href != null ? !href.equals(sysMenu.href) : sysMenu.href != null) return false;
        if (target != null ? !target.equals(sysMenu.target) : sysMenu.target != null) return false;
        if (icon != null ? !icon.equals(sysMenu.icon) : sysMenu.icon != null) return false;
        if (isShow != null ? !isShow.equals(sysMenu.isShow) : sysMenu.isShow != null) return false;
        if (permission != null ? !permission.equals(sysMenu.permission) : sysMenu.permission != null) return false;
        if (createBy != null ? !createBy.equals(sysMenu.createBy) : sysMenu.createBy != null) return false;
        if (createDate != null ? !createDate.equals(sysMenu.createDate) : sysMenu.createDate != null) return false;
        if (updateBy != null ? !updateBy.equals(sysMenu.updateBy) : sysMenu.updateBy != null) return false;
        if (updateDate != null ? !updateDate.equals(sysMenu.updateDate) : sysMenu.updateDate != null) return false;
        if (remarks != null ? !remarks.equals(sysMenu.remarks) : sysMenu.remarks != null) return false;
        if (delFlag != null ? !delFlag.equals(sysMenu.delFlag) : sysMenu.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (parentIds != null ? parentIds.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + (href != null ? href.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
