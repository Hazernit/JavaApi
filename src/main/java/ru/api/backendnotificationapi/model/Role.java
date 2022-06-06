package ru.api.backendnotificationapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity{

    @Column(name = "nameRole")
    private String nameRole;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<NotificationsBase> notificationsBases;
}
