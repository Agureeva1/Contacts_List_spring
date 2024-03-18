package com.example.springclientslistpractise;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

import static com.example.springclientslistpractise.MapClients.dellClient;
import static com.example.springclientslistpractise.MapClients.showAllClients;

/*
Вам необходимо реализовать небольшое консольное приложение «Контакты». Сущность контакта представляет собой полное имя (fullName), номер телефона (phoneNumber) и адрес электронной почты (email).
Приложение должно уметь:
1.	Выводить все имеющиеся контакты пользователя в формате «Ф. И. О. | Номер телефона | Адрес электронной почты».
2.	Добавлять новый контакт в список контактов. Формат ввода для обработки данных: Ф. И. О.;номер телефона;адрес электронной почты.
Пример пользовательского ввода: Иванов Иван Иванович;+790999999;someEmail@example.example.
3.	Удалять контакт по email.
4.	Сохранять имеющиеся контакты в файл в формате «Ф. И. О;номер телефона;адрес электронной почты».
Пример файла:
Иванов Иван Иванович;+790999999;someEmail@example.example
Смирнов Иван Иванович;+790999991;someEmail2@example.example
5.	Использовать инициализацию хранилища с контактами через файл, если профиль приложения = init. Файл должен хранить произвольный набор контактов. Все контакты должны быть разделены переносом строки.
Пример файла:
Иванов Иван Иванович;+790999999;someEmail@example.example
Смирнов Иван Иванович;+790999991;someEmail2@example.example
 */

public class SpringClientsListPractiseApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		String profile = context.getBean(AppConfig.class).getProfile();

		if(profile.equals("init")) {
		MapLoader loader = (MapLoader) context.getBean(MapLoader.class);
		loader.loadMap();
			System.out.println("Load contacts from client.txt");
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine().trim();
			if (line.matches("([a-zA-z а-яА-ЯёЁ]+;(?:\\+7|8)[0-9]{10};[\\w._]+@[\\w.-]+)")) {
				String[] splitLine = line.split(";");
				Client client = (Client) context.getBean(Client.class,splitLine[0],splitLine[1],splitLine[2]);
				System.out.println("Client");
			}
			else if (line.equals("all")) {
				if (!MapClients.mapClients.isEmpty()) showAllClients();
				else {
					System.out.println("У Вас нет ни одного контакта");
				}
			}
			else if (line.matches("(del [\\w.-]+@[\\w.-]+)"))  {
				String[] splitLine = line.split(" ");
				dellClient(splitLine[1]);
				System.out.println("DEL");
			}
			else {
				System.out.println("Команда не известна");
			}
		}

	}
}
