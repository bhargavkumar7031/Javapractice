package org.example.services;

import org.example.classes.Task;
import org.example.classes.User;
import org.example.sql.TasksDAO;
import org.example.sql.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TasksDAO tasksDAO;
    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    @Qualifier("SMSNotification")
    private NotificationService notificationService;

    public void assignTaskToUser(Task task, User user) {
        task.setUserId(user);
        usersDAO.addUser(user);
        tasksDAO.addTask(task);
        notificationService.sendMessage("Added user");
    }


}
