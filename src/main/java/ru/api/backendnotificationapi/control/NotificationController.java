package ru.api.backendnotificationapi.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.api.backendnotificationapi.model.NotificationsBase;
import ru.api.backendnotificationapi.model.Type;
import ru.api.backendnotificationapi.repository.NotificationsRepository;
import ru.api.backendnotificationapi.service.impl.NotificationServiceImpl;

import javax.management.Notification;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationServiceImpl;

    @GetMapping("/notification")
    public ResponseEntity<List<NotificationsBase>> getAllNotification() {
        try {
            if (notificationServiceImpl.getAllNotification().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(notificationServiceImpl.getAllNotification(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<Optional> getNotificationById(@PathVariable("id") long id) {
        if (notificationServiceImpl.findById(id).isPresent()) {
            return new ResponseEntity<>(notificationServiceImpl.findById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notification")
    public ResponseEntity<NotificationsBase> createNotification(@ResponseBody NotificationsBase notificationsBase) {
        try {
            NotificationsRepository notificationsRepository = notificationServiceImpl.notificationsRepository.save(new NotificationsBase(notificationsBase.getTitle(), notificationsBase.getContent(), notificationsBase.getLastSentAt(), notificationsBase.getRoles()))
        }
    }

}
