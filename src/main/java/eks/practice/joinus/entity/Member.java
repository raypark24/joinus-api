package eks.practice.joinus.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_sn", nullable = false, updatable = false)
    private String memberSn;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "login_id", nullable = false, length = 300)
    private String loginId;

    @Column(name = "login_pwd", nullable = false, length = 200)
    private String loginPwd;

    @Column(name = "tel_no_1", length = 20)
    private String telNo1;

    @Column(name = "tel_no_2", length = 20)
    private String telNo2;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_dt")
    private Date updatedDt;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Override
    public String toString() {
        return "Member{" +
                "memberSn='" + memberSn + '\'' +
                ", name='" + name + '\'' +
                ", loginId='" + loginId + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", telNo1='" + telNo1 + '\'' +
                ", telNo2='" + telNo2 + '\'' +
                ", createdDt=" + createdDt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDt=" + updatedDt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}