package edu.uncc.midterm.utils;

public class User {
    public String name, gender, group, state;
    public int age;

    public User(String name, String gender, String group, String state, int age) {
        this.name = name;
        this.gender = gender;
        this.group = group;
        this.state = state;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dept='" + group + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                '}';
    }
}
