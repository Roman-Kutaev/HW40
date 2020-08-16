package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title;
    private Action action;
    private List<Menu> item;


    public Menu(String title){
        this(title, null);
    }

    public Menu(String title, Action action) {
        this.title = title;
        this.action = action;
        item = new ArrayList<>();
    }
    public Menu add(Menu menu){
        item.add(menu);
        return menu;
    }

    public void show(){
        if (action != null){
            action.doAction();
        }else {
            System.out.println(title);
            int menuCounter = 0;
            while (menuCounter != item.size()-1) {
                for (int i = 0; i < item.size(); i++) {
                    System.out.println((i + 1) + ". " + item.get(i).title);
                }
                Scanner scanner = new Scanner(System.in);
                String choose = scanner.nextLine();
                try {
                    menuCounter = Integer.parseInt(choose) - 1;

                    item.get(menuCounter).show();
                }catch (Throwable throwable){
                    throwable.printStackTrace();
                }
            }
        }
    }
}