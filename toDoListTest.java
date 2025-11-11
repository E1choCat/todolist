package todoLis;

import java.util.ArrayList;
import java.util.Scanner;

public class toDoListTest {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<toDoList> toDoListfull = new ArrayList<>();
    static ArrayList<toDoList> newToDoListfull = new ArrayList<>();
    static ArrayList<Integer> year = new ArrayList<>();
    static ArrayList<Integer> month = new ArrayList<>();
    static ArrayList<Integer> day = new ArrayList<>();

    public static void main() {
        toDOListenter();
    }

    public static void toDOListenter() {
        loop:
        while (true) {
            System.out.println("=======================");
            System.out.println("\t代办事项管理系统");
            System.out.println("=======================");
            System.out.println(" ");
            System.out.println("请选择功能（输入序号）:");
            System.out.println("1.添加待办事项");
            System.out.println("2.查看所有代办");
            System.out.println("3.标记代办为已完成");
            System.out.println("4.按截止时间排序");
            System.out.println("5.查找代办（按关键词）");
            System.out.println("6.删除代办事项");
            System.out.println("7.退出程序");
            int choice = sc.nextInt();
            swi:
            switch (choice) {
                case 1:
                    //添加代办事项
                    addToDOList();
                    break;
                case 2:
                    //查看所有代办事项
                    viewAllToDoList();
                    break;
                case 3:
                    //标记代办为已完成
                    markTodoAsCompleted();
                    break;
                case 4:
                    //按截止时间排序
                    sortTodosByDdl();
                    break;
                case 5:
                    //查找关键词
                    findKeyToDo();
                    break;
                case 6:
                    deleToDo();
                    break;
                case 7:
                    System.out.println("感谢使用");
                    break loop;
            }
        }

    }


    //添加待办事项
    public static void addToDOList() {
        toDoList toDoList = new toDoList();
        System.out.println("=====添加待办事项=====");
        int i = toDoListfull.size() + 1;
        System.out.println("请输入代办描述：");
        String importTodo = sc.next();
        String ddlTime;
        while (true) {
            if (importTodo.isEmpty()) {
                System.out.println("❗ 代办描述不能为空，请重新输入：");
                importTodo = sc.next();
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("请输入截止时间(格式yyyy-MM-dd,如2025-01-02)");
            ddlTime = sc.next();
            if (!ddlTime.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("❗ 截止时间格式错误，请重新输入：");
            } else {
                break;
            }
        }

        toDoList.setStatus("\uD83D\uDD04 未完成");
        toDoList.setDescription(importTodo);
        toDoList.setDdlTime(ddlTime);
        toDoList.setIndex(i);
        System.out.println("✅ 代办添加成功！");
        toDoListfull.add(toDoList);
        System.out.println(toDoListfull.toString());

    }

    //查看所有代办事项
    public static void viewAllToDoList() {
        System.out.println("=====所有代办事项=====");
        for (int i = 0; i < toDoListfull.size(); i++) {
            System.out.println(toDoListfull.get(i).toString() + "\t");
        }
    }

    //更改代办事项为已完成
    public static void markTodoAsCompleted() {
        System.out.println("=====标记代办为已完成=====");
        viewAllToDoList();
        checkNotEmpty();
        loop:
        while (true) {
            System.out.println("请输入要标记的代办序号：");
            int makeNum = sc.nextInt();

            for (int i = 0; i < toDoListfull.size(); i++) {
                if (makeNum == toDoListfull.get(i).getIndex()) {
                    toDoListfull.get(makeNum - 1).setStatus("✅ 已完成");
                    System.out.println("✅ 标记成功！该代办已设已完成~");
                    break loop;
                } else {
                    System.out.println("❗ 没有这个代办事项，请重新输入：");
                    break loop;
                }
            }

            toDoListfull.get(makeNum - 1).setStatus("✅ 已完成");
            System.out.println("✅ 标记成功！该代办已设已完成~");
        }
    }

    //按截止时间排序
    public static void sortTodosByDdl() {
        checkNotEmpty();
        toDoListfull.sort((t1, t2) -> {
            // 提取日期字符串并直接比较（yyyy-MM-dd格式可直接按字符串比较）
            return t1.getDdlTime().compareTo(t2.getDdlTime());
        });
        System.out.println("✅ 排序成功！按截止时间排序后为：");
        viewAllToDoList();

    }

    //查找关键词
    public static void findKeyToDo() {
        checkNotEmpty();
        System.out.println("请输入您要查找的关键词");
        String key = sc.next();
        int i;
        boolean flag = false;
        for (i = 0; i < toDoListfull.size(); i++) {
            if (toDoListfull.get(i).getDescription().equals(key)) {
                System.out.println(toDoListfull.get(i).toString());
                flag = true;
            }
        }
        if (flag == true) {
            System.out.println("✅ 成功找到了待办事项");
        } else {
            System.out.println("❗ 并没有这个待办事项");
        }
    }


    //删除代办
    public static void deleToDo() {
        viewAllToDoList();
        checkNotEmpty();
        System.out.println("请输入您要删除的代办的序号");
        int deleIndex = sc.nextInt();
        boolean flag = false;
        for (int i = 0; i < toDoListfull.size(); i++) {
            if (deleIndex == toDoListfull.get(i).getIndex()) {
                toDoListfull.remove(deleIndex);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("✅ 恭喜删除成功！");
        } else {
            System.out.println("❗ 没有这个代办事项，请重新输入：");
        }
    }

    //确定非空
    public static void checkNotEmpty() {
        if (toDoListfull.isEmpty()) {
            System.out.println("❗ 当前没有代办事项，请先添加代办事项");
            toDOListenter();
        }
    }
}

