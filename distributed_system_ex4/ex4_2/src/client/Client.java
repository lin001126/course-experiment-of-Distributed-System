package client;


import service.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Client {


    public static void main(String[] argv) {
        try {

            UserServiceImplService userServiceImplService = new UserServiceImplService();
            UserServiceImpl userService = userServiceImplService.getPort(UserServiceImpl.class);

            System.out.println("系统连接成功");

            //构建一个用户输入command和方法的对应表，以供后面的反射调用使用
            HashMap<String, String[]> mapping = new HashMap<>();
            mapping.put("register", new String[]{"3", "registry"});
            mapping.put("add", new String[]{"6", "addTD"});
            mapping.put("query", new String[]{"5", "queryTD"});
            mapping.put("delete", new String[]{"4", "deleteTD"});
            mapping.put("clear", new String[]{"3", "clearTD"});



            Scanner scanner = new Scanner(System.in);
            StringBuilder log = new StringBuilder();

            while (true) {
                getHelpWord();
                String cmd = scanner.nextLine();
                log.append(cmd).append("\n");

                if (cmd.equals("quit")) break;
                else if (cmd.contains("admin")) System.out.println(userService.getTDList());
                else if (cmd.contains("print log")) System.out.println(log);
                else {

                    //info存着指令的信息，methodInfo存着对应方法的配置信息
                    String[] info = cmd.split(" ");
                    String[] methodInfo = mapping.get(info[0]);
                    if (methodInfo == null) {
                        System.out.println("信息格式有误");
                        continue;
                    }

                    //将真实有用的信息转化为list存储到args中
                    List<String> args = Arrays.asList(Arrays.copyOfRange(info, 1, info.length));


                    //check的作用：1.命令是否正确 2.账号密码是否正确
                    if (!methodInfo[0].equals(String.valueOf(info.length))) {
                        System.err.println("信息有误");
                        continue;
                    }
                    if (!info[0].equals("register") && !userService.checkId(args)) {
                        System.err.println("账号或密码错误");
                        continue;
                    }

                    //通过反射调用对应方法，并返回方法的结果打印出来
                    System.out.println(
                            userService.getClass().getDeclaredMethod(methodInfo[1], List.class).invoke(userService, (Object) args)
                    );

                }
            }

        } catch (Exception e) {
            System.out.println("Client exception: " + e);
            e.printStackTrace();
        }
    }

    public static void getHelpWord() {
        System.out.println("*****************************************************");
        System.out.println("Web Service Menu:");
        System.out.println("\t" + "1.register");
        System.out.println("\t\t" + "arguments:<username> <password>");
        System.out.println("\t\t" + "example:register zjj2 zjj2");
        System.out.println("\t" + "2.add");
        System.out.println("\t\t" + "arguments:<username> <password><startTime> <EndTime> <Description>");
        System.out.println("\t\t" + "example:add zjj2 zjj2 2021-11-1-08:00 2021-11-1-18:00 yyds");
        System.out.println("\t" + "3.query");
        System.out.println("\t\t" + "arguments:<startTime> <EndTime>");
        System.out.println("\t\t" + "example:query zjj2 zjj2 2021-10-31-08:00 2021-11-2-18:00 ");
        System.out.println("\t" + "4.delete");
        System.out.println("\t\t" + "arguments:<id>");
        System.out.println("\t\t" + "example:delete zjj2 zjj2 id");
        System.out.println("\t" + "5.clear");
        System.out.println("\t\t" + "arguments:<username> <password>");
        System.out.println("\t\t" + "example:clear zjj2 zjj2");
        System.out.println("\t" + "6.quit");
        System.out.println("*****************************************************");
        System.out.println("Please input your operation name and argument:");
        System.out.println("*****************************************************");

    }
}