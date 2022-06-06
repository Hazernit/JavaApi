package ru.api.backendnotificationapi.service.impl;



import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.api.backendnotificationapi.model.NotificationsBase;
import ru.api.backendnotificationapi.repository.NotificationsRepository;
import ru.api.backendnotificationapi.repository.RoleRepository;
import ru.api.backendnotificationapi.service.NotificationsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationsService {

    public final NotificationsRepository notificationsRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public NotificationServiceImpl(NotificationsRepository notificationsRepository, RoleRepository roleRepository) {
        this.notificationsRepository = notificationsRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<NotificationsBase> getAll() {
        List<NotificationsBase> result = notificationsRepository.findAll();
        log.info("Из getAll - {} всего сообщений", result.size());
        return result;
    }

    @Override
    public List<NotificationsBase> getAllNotification() {
        List<NotificationsBase> result = new ArrayList<NotificationsBase>();
        notificationsRepository.findAll().forEach(result::add);
        log.info("Из getAll - {} всего сообщений", result.size());
        return result;
    }

    @Override
    public Optional<NotificationsBase> findById(Long id) {
        Optional<NotificationsBase> result = notificationsRepository.findById(id);
        if (result.isPresent()) {
            log.info("Выполнен findById - сообщения с таким id {} выведены на экран", id);
            return result;
        }
        log.warn("Выполнен findById - сообщения с таким id {} не обнаружены!", id);
        return null;
    }

//    @Override
//    public NotificationsBase findById(Long id) {
//        NotificationsBase result = notificationsRepository.findById(id).orElse(null);
//        if (result == null) {
//            log.warn("Выполнен findById - сообщения с таким id {} не обнаружены!", id);
//            return null;
//        }
//        log.info("Выполнен findById - сообщения с таким id {} выведены на экран", id);
//        return result;
//    }

//    @Override
//    public ResponseEntity<NotificationsBase> findById(Long id) {
//        Optional<NotificationsBase> result = notificationsRepository.findById(id).orElse(null);
//        if (result.isPresent()) {
//            log.warn("Выполнен findById - сообщения с таким id {} не обнаружены!", id);
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }
//        log.info("Выполнен findById - сообщения с таким id {} выведены на экран", id);
//        return null;
//    }

    @Override
    public NotificationsBase findByTitle(String title) {
        return null;
    }

    @Override
    public void delete(Long id) {
        notificationsRepository.deleteById(id);
        log.info("Выполнен delete. Все данные свзанные с этим {} id удалены", id);
    }
}
