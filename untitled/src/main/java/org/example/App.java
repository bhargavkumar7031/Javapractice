package org.example;

import org.example.classes.Task;
import org.example.classes.User;
import org.example.services.TaskService;
import org.example.services.UserService;
import org.example.sql.TasksDAO;
import org.example.sql.UsersDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


//        User user = context.getBean("user", User.class);
//        user.setId(2);
//        user.setName("Jatayu");
//        user.setEmail("Jatayu@gmail.com");
//
//        Task task = context.getBean("task", Task.class);
//        task.setTaskId(3);
//        task.setName("write Notes");
//        task.setPriority("MEDIUM");
//        task.setStatus("PENDING");
//
//        UserService USer = context.getBean("userService", UserService.class);
//        USer.assignTaskToUser(task, user);
//
//        UsersDAO userService = context.getBean("usersDAO", UsersDAO.class);
//        userService.deleteUser(2);
//
//        TasksDAO taskservice = context.getBean("tasksDAO", TasksDAO.class);
//        taskservice.deleteTask(3);
    }
}
