package cn.sheetanchor.sparrow.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 多级字典表
 */
@Entity
@Table(name = "sys_mdict")
public class SysMdict implements Serializable{
    private static final long serialVersionUID = 6125288943016800677L;
    private String id;
    private String parentId;
    private String parentIds;
    private String name;
    private int sort;
    private String description;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        SysMdict sysMdict = (SysMdict) o;

        if (sort != sysMdict.sort) return false;
        if (id != null ? !id.equals(sysMdict.id) : sysMdict.id != null) return false;
        if (parentId != null ? !parentId.equals(sysMdict.parentId) : sysMdict.parentId != null) return false;
        if (parentIds != null ? !parentIds.equals(sysMdict.parentIds) : sysMdict.parentIds != null) return false;
        if (name != null ? !name.equals(sysMdict.name) : sysMdict.name != null) return false;
        if (description != null ? !description.equals(sysMdict.description) : sysMdict.description != null)
            return false;
        if (createBy != null ? !createBy.equals(sysMdict.createBy) : sysMdict.createBy != null) return false;
        if (createDate != null ? !createDate.equals(sysMdict.createDate) : sysMdict.createDate != null) return false;
        if (updateBy != null ? !updateBy.equals(sysMdict.updateBy) : sysMdict.updateBy != null) return false;
        if (updateDate != null ? !updateDate.equals(sysMdict.updateDate) : sysMdict.updateDate != null) return false;
        if (remarks != null ? !remarks.equals(sysMdict.remarks) : sysMdict.remarks != null) return false;
        if (delFlag != null ? !delFlag.equals(sysMdict.delFlag) : sysMdict.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (parentIds != null ? parentIds.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
