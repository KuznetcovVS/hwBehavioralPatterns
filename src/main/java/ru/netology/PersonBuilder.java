package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age; // Используем Integer для проверки на null
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия обязательны для заполнения");
        }

        Person person = new Person(name, surname);

        if (age != null) { // Если возраст был установлен
            person.setAge(age);
        }

        if (address != null) { // Если адрес был установлен
            person.setAddress(address);
        }

        return person;
    }
}
