package cn.sheetanchor.sparrow.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 字典表
 */
@Entity
@Table(name = "sys_dict")
public class SysDict implements Serializable{
    private static final long serialVersionUID = -6832018174913296411L;
    private String id;
    private String value;
    private String label;
    private String type;
    private String description;
    private int sort;
    private String parentId;
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
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

        SysDict sysDict = (SysDict) o;

        if (sort != sysDict.sort) return false;
        if (id != null ? !id.equals(sysDict.id) : sysDict.id != null) return false;
        if (value != null ? !value.equals(sysDict.value) : sysDict.value != null) return false;
        if (label != null ? !label.equals(sysDict.label) : sysDict.label != null) return false;
        if (type != null ? !type.equals(sysDict.type) : sysDict.type != null) return false;
        if (description != null ? !description.equals(sysDict.description) : sysDict.description != null) return false;
        if (parentId != null ? !parentId.equals(sysDict.parentId) : sysDict.parentId != null) return false;
        if (createBy != null ? !createBy.equals(sysDict.createBy) : sysDict.createBy != null) return false;
        if (createDate != null ? !createDate.equals(sysDict.createDate) : sysDict.createDate != null) return false;
        if (updateBy != null ? !updateBy.equals(sysDict.updateBy) : sysDict.updateBy != null) return false;
        if (updateDate != null ? !updateDate.equals(sysDict.updateDate) : sysDict.updateDate != null) return false;
        if (remarks != null ? !remarks.equals(sysDict.remarks) : sysDict.remarks != null) return false;
        if (delFlag != null ? !delFlag.equals(sysDict.delFlag) : sysDict.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
