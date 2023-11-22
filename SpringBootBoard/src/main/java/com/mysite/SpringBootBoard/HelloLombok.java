package com.mysite.SpringBootBoard;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//2) @RequiredArgsConstructor
@Getter
//1)@Setter
//@Data
public class HelloLombok {

    //1) Getter, Setter 어노테이션 이용 시
    //private String hello;
    //private int lombok;

    private final String hello;
    private final int lombok;


    //2) @RequiredArgsConstructor 대신
    //3) 생성자를 직접 작성할 수 있다. 의존성 주입(Dependency Injection)시 사용된다.
    public HelloLombok(String hello, int lombok) {
        this.hello = hello;
        this.lombok = lombok;
    }

    public static void main(String[] args) {
//       1) Getter, Setter 어노테이션 이용 시
//        HelloLombok helloLombok = new HelloLombok();
//        helloLombok.setHello("헬로");
//        helloLombok.setLombok(5);

        //2), 3) 작성 시
        HelloLombok helloLombok = new HelloLombok("헬로", 5);


        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());



    }
}
