package com.jat.UserService.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "micro_user")
public class User {
    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME",length = 20)
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "About")
    private String About;

    @Transient
    private List<Rating> ratings=new ArrayList<>();

}
