package com.i5e2.likeawesomevegetable.board.like;

import com.i5e2.likeawesomevegetable.company.buying.CompanyBuying;
import com.i5e2.likeawesomevegetable.user.basic.User;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_company_buying_like")
public class CompanyBuyingLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_buying_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_buying_id")
    private CompanyBuying companyBuying;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "company_buying_like_registered_at")
    private LocalDateTime companyBuyingLikeRegisteredAt;

    @Builder
    public CompanyBuyingLike(CompanyBuying companyBuying, User loginUser) {
        this.companyBuying = companyBuying;
        this.user = loginUser;
        this.companyBuyingLikeRegisteredAt = LocalDateTime.now();
    }
}
