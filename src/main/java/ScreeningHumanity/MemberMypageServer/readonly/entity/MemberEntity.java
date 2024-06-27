package ScreeningHumanity.MemberMypageServer.readonly.entity;

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
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id; //PK
    private String name; //이름
    private String password; //비밀번호
    private String nickname; //닉네임
    private String paying_password; //결제 PW
    private String uuid; //uuid
    private String status; //회원상태
    private String grade; //회원등급
    private String phone_number; //전화번호
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
