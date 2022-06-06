package ru.api.backendnotificationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.api.backendnotificationapi.model.NotificationsBase;

import javax.management.Notification;
import java.util.List;

public interface NotificationsRepository extends JpaRepository<NotificationsBase, Long> {
    List<Notification> findByTitleContaining(String title);

}
