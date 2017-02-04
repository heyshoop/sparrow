package cn.sheetanchor.sparrow.sys.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 角色-机构表
 */
@Entity
@Table(name = "sys_role_office")
@IdClass(SysRoleOfficePK.class)
public class SysRoleOffice implements Serializable{
    private static final long serialVersionUID = 1634399743284488758L;
    private String roleId;
    private String officeId;

    @Id
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "office_id")
    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleOffice that = (SysRoleOffice) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (officeId != null ? !officeId.equals(that.officeId) : that.officeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (officeId != null ? officeId.hashCode() : 0);
        return result;
    }
}
