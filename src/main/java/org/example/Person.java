package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * @author Developer Name.
 * @version 1.0.
 * @apiNote Класс для описания участника списка.
 */
public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private Date birthDay;
    private Integer phoneNumber;
    private String gender;

    private static DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Конструктор класса
     *
     * @param surname     фамилия
     * @param name        имя
     * @param patronymic  отчество
     * @param birthDay    дата рождения
     * @param phoneNumber номер телефона
     * @param gender      пол
     */
    public Person(String surname, String name, String patronymic, Date birthDay, Integer phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Метод запроса данных через консоль для создания экземпляра Person
     */
    public static Person dataConsoleInput() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите данные участника через пробел \n" +
                " (Фамилия Имя Отчество Дата_рождения(дд.мм.гггг) телефон(7 знаков) пол(f - женский/ m - мужской ");
        String input = scan.nextLine();
        String[] data = input.split("\\s");
        if (data.length < 6) {
            throw new RuntimeException("Введены неполные данные");
        } else if (data.length > 6) {
            throw new RuntimeException("Введены избыточные данные");
        } else if (data[4].length() != 7) {
            throw new RuntimeException("Номер телефона должен состоянть из 7 цифр");
        } else if ((!data[5].matches("m")) && (!data[5].matches("f"))) {
            throw new RuntimeException("Пол должн обозначатся буквами: m - мужской, f - женский");
        }

        Person pers = new Person(data[0], data[1], data[2], df.parse(data[3]), Integer.parseInt(data[4]), data[5]);
        return pers;
    }

    @Override
    public String toString() {
        return "<" + this.getSurname() + ">" +
                "<" + this.getName() + ">" +
                "<" + this.getPatronymic() + ">" +
                "<" + df.format(this.getBirthDay()) + ">" +
                "<" + this.getPhoneNumber() + ">" +
                "<" + this.getGender() + ">";
    }
}
