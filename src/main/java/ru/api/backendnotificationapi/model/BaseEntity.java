package ru.api.backendnotificationapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    @Column(name = "createdDate")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updateDate")
    private Date update;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;



}
