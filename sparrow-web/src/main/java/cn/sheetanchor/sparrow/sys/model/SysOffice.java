package cn.sheetanchor.sparrow.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 机构表
 */
@Entity
@Table(name = "sys_office")
public class SysOffice implements Serializable{
    private static final long serialVersionUID = 714727815692266382L;
    private String id;
    private String parentId;
    private String parentIds;
    private String name;
    private int sort;
    private String areaId;
    private String code;
    private String type;
    private String grade;
    private String address;
    private String zipCode;
    private String master;
    private String phone;
    private String fax;
    private String email;
    private String useable;
    private String primaryPerson;
    private String deputyPerson;
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
    @Column(name = "area_id")
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "master")
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "USEABLE")
    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }

    @Basic
    @Column(name = "PRIMARY_PERSON")
    public String getPrimaryPerson() {
        return primaryPerson;
    }

    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    @Basic
    @Column(name = "DEPUTY_PERSON")
    public String getDeputyPerson() {
        return deputyPerson;
    }

    public void setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson;
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

        SysOffice sysOffice = (SysOffice) o;

        if (sort != sysOffice.sort) return false;
        if (id != null ? !id.equals(sysOffice.id) : sysOffice.id != null) return false;
        if (parentId != null ? !parentId.equals(sysOffice.parentId) : sysOffice.parentId != null) return false;
        if (parentIds != null ? !parentIds.equals(sysOffice.parentIds) : sysOffice.parentIds != null) return false;
        if (name != null ? !name.equals(sysOffice.name) : sysOffice.name != null) return false;
        if (areaId != null ? !areaId.equals(sysOffice.areaId) : sysOffice.areaId != null) return false;
        if (code != null ? !code.equals(sysOffice.code) : sysOffice.code != null) return false;
        if (type != null ? !type.equals(sysOffice.type) : sysOffice.type != null) return false;
        if (grade != null ? !grade.equals(sysOffice.grade) : sysOffice.grade != null) return false;
        if (address != null ? !address.equals(sysOffice.address) : sysOffice.address != null) return false;
        if (zipCode != null ? !zipCode.equals(sysOffice.zipCode) : sysOffice.zipCode != null) return false;
        if (master != null ? !master.equals(sysOffice.master) : sysOffice.master != null) return false;
        if (phone != null ? !phone.equals(sysOffice.phone) : sysOffice.phone != null) return false;
        if (fax != null ? !fax.equals(sysOffice.fax) : sysOffice.fax != null) return false;
        if (email != null ? !email.equals(sysOffice.email) : sysOffice.email != null) return false;
        if (useable != null ? !useable.equals(sysOffice.useable) : sysOffice.useable != null) return false;
        if (primaryPerson != null ? !primaryPerson.equals(sysOffice.primaryPerson) : sysOffice.primaryPerson != null)
            return false;
        if (deputyPerson != null ? !deputyPerson.equals(sysOffice.deputyPerson) : sysOffice.deputyPerson != null)
            return false;
        if (createBy != null ? !createBy.equals(sysOffice.createBy) : sysOffice.createBy != null) return false;
        if (createDate != null ? !createDate.equals(sysOffice.createDate) : sysOffice.createDate != null) return false;
        if (updateBy != null ? !updateBy.equals(sysOffice.updateBy) : sysOffice.updateBy != null) return false;
        if (updateDate != null ? !updateDate.equals(sysOffice.updateDate) : sysOffice.updateDate != null) return false;
        if (remarks != null ? !remarks.equals(sysOffice.remarks) : sysOffice.remarks != null) return false;
        if (delFlag != null ? !delFlag.equals(sysOffice.delFlag) : sysOffice.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (parentIds != null ? parentIds.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (master != null ? master.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (useable != null ? useable.hashCode() : 0);
        result = 31 * result + (primaryPerson != null ? primaryPerson.hashCode() : 0);
        result = 31 * result + (deputyPerson != null ? deputyPerson.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
