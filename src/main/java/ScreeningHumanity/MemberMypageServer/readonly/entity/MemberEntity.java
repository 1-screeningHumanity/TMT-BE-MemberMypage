package ScreeningHumanity.MemberMypageServer.readonly.entity;

import ScreeningHumanity.MemberMypageServer.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId; //PK

    @Column(name = "name")
    private String name; //이름

    @Column(name = "password")
    private String password; //비밀번호

    @Column(name = "nickname")
    private String nickname; //닉네임

    @Column(name = "paying_password")
    private String payingPassword; //결제 PW

    @Column(name = "uuid")
    private String uuid; //uuid

    @Column(name = "status")
    private String status; //회원상태

    @Column(name = "grade")
    private String grade; //회원등급

    @Column(name = "phone_number")
    private String phoneNumber; //전화번호

    @Column(name = "member_id")
    private LocalDateTime createdAt;

    @Column(name = "member_id")
    private LocalDateTime modifiedAt;
}
