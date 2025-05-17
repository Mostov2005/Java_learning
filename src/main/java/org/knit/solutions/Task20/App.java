package org.knit.solutions.Task20;

import org.example.passwordmanager.config.AppConfig;
import org.example.passwordmanager.security.MasterPasswordHolder;
import org.example.passwordmanager.service.PasswordService;
import org.example.passwordmanager.model.PasswordEntry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PasswordService passwordService = context.getBean(PasswordService.class);
        MasterPasswordHolder masterPasswordHolder = context.getBean(MasterPasswordHolder.class);

        // Мастер-пароль
        char[] masterPassword;
        System.out.print("Введите мастер-пароль: ");
        Scanner scanner = new Scanner(System.in);
        if (System.console() != null) {
            masterPassword = System.console().readPassword();
        } else {
            masterPassword = scanner.nextLine().toCharArray(); // для IDE
        }
        masterPasswordHolder.set(masterPassword);

        // Очистка мастер-пароля при завершении
        Runtime.getRuntime().addShutdownHook(new Thread(masterPasswordHolder::clear));

        // Основной цикл
        while (true) {
            System.out.print("> ");
            String commandLine = scanner.nextLine().trim();
            String[] tokens = commandLine.split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "add" -> {
                    System.out.print("Сайт: ");
                    String site = scanner.nextLine();
                    System.out.print("Логин: ");
                    String login = scanner.nextLine();
                    System.out.print("Пароль: ");
                    String password = scanner.nextLine();
                    passwordService.add(site, login, password);
                    System.out.println("Добавлено.");
                }
                case "list" -> {
                    List<PasswordEntry> entries = passwordService.list();
                    if (entries.isEmpty()) {
                        System.out.println("Нет записей.");
                    } else {
                        entries.forEach(e -> System.out.println(e.getSite() + " | " + e.getLogin()));
                    }
                }
                case "copy" -> {
                    if (tokens.length < 2) {
                        System.out.println("Укажите сайт.");
                        break;
                    }
                    String site = tokens[1];
                    boolean success = passwordService.copy(site);
                    System.out.println(success ? "Пароль скопирован в буфер обмена." : "Сайт не найден.");
                }
                case "delete" -> {
                    if (tokens.length < 2) {
                        System.out.println("Укажите сайт.");
                        break;
                    }
                    passwordService.delete(tokens[1]);
                    System.out.println("Удалено (если было).");
                }
                case "exit" -> {
                    System.out.println("До свидания!");
                    context.close();
                    return;
                }
                default -> System.out.println("Неизвестная команда.");
            }
        }
    }
}