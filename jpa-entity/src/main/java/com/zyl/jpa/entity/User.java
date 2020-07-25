package com.zyl.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name= "tt_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer uid;
    private  String username;
    private  String password;
    private  String name;
    private  String email;
    private  String telephone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private  int sex;
    private  int state;
    private  String code;

    @OneToOne(targetEntity=DriverCard.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = false,nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private DriverCard driverCard;

    // 多对一
    @ManyToOne(targetEntity=Depart.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,
            foreignKey=@ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private Depart depart;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "uid",insertable = true,updatable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Room> roomList;





}
