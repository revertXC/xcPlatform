package com.deer.model.Demo;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
public class DemoModel {

    @Getter
    private String name;

    private String age;

    public void aa(@NonNull String a){
        System.out.println("11");
    }


    public static void main(String[] args) {
        DemoModel demoModel = new DemoModel();
    }

}
