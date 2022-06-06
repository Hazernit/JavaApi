package ru.api.backendnotificationapi.service;

import ru.api.backendnotificationapi.model.NotificationsBase;

import java.util.List;
import java.util.Optional;

public interface NotificationsService {

    List<NotificationsBase> getAll();

    List<NotificationsBase> getAllNotification();

    Optional<NotificationsBase> findById(Long id);




    NotificationsBase findByTitle(String title);

    void delete(Long id);
}
