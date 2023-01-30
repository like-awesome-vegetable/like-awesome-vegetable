package com.i5e2.likeawesomevegetable.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "t_farm_image")
public class FarmImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "farm_image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farm_user_id")
    private FarmUser farmUser;

    //    @Column(name = "link")
//    private String link;
    @Column(name = "farm_image_link")
    private String farmImageLink;

    // 추가
    @Column(name = "farm_image_name")
    private String farmImageName;
}