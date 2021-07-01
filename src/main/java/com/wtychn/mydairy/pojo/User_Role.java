package com.wtychn.mydairy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int user_id;
    private int role_id;
}
