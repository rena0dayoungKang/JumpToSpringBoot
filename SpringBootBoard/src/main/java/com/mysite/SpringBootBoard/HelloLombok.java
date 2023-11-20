package com.mysite.SpringBootBoard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@RequiredArgsConstructor
@Getter
//@Setter
public class HelloLombok {

    private final String hello;
    private final int lombok;

    //@RequiredArgsConstructor 대신 생성자를 직접 작성할 수 있다. 의존성 주입(Dependency Injection)시 사용된다.
    public HelloLombok(String hello, int lombok) {
        this.hello = hello;
        this.lombok = lombok;
    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }
}
