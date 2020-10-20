package com.sadjoumoumouni.demo.hexagon.domain.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @NonNull
    private String userId;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String email;

    @NonNull
    @Column
    private Double money;
}
