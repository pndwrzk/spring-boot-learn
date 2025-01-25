package com.learn.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user" ,schema = "public")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, name = "phone_number", unique = true)
    public String phoneNumber;

    @Column(nullable = false)
    public String password;

}
