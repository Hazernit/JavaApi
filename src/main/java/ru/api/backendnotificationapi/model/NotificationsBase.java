package ru.api.backendnotificationapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notifications")
@Data
public class NotificationsBase extends BaseEntity{

//    @Enumerated(EnumType.STRING)
//    @Column(name = "type")
//    private Type type;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "last_sent_at")
    private Date lastSentAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")} )
    private List<Role> roles;

    public NotificationsBase(String title, String content, Date lastSentAt, List<Role> roles) {
        this.title = title;
        this.content = content;
        this.lastSentAt = lastSentAt;
        this.roles = roles;
    }
}
