package client;


import clientcode.UserServiceImplService;
import clientcode.*;

import java.util.*;

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
            HashMap<String,String[]> mapping = new HashMap<>();
            mapping.put("register",new String[]{"3","registry"});
            mapping.put("add",new String[]{"6","addMeet"});
            mapping.put("query",new String[]{"5","queryMeet"});
            mapping.put("delete",new String[]{"4","deleteMeet"});
            mapping.put("clear",new String[]{"3","clearMeet"});



            String username = "alec";String password = "123";
            Scanner scanner = new Scanner(System.in);
            StringBuilder log = new StringBuilder();

            while (true){
                System.out.println(getHelpWord(username,password));
                String cmd = scanner.nextLine();
                log.append(cmd).append("\n");

                if(cmd.equals("quit"))break;
                else if(cmd.contains("admin"))System.out.println(userService.getMeetingList());
                else if(cmd.contains("print log"))System.out.println(log.toString());
                else {

                    //info存着指令的信息，methodInfo存着对应方法的配置信息
                    String[] info = cmd.split(" ");String[] methodInfo = mapping.get(info[0]);
                    if(methodInfo == null) { System.out.println("信息格式有误");continue; }

                    //将真实有用的信息转化为list存储到args中
                    List<String> args = Arrays.asList(Arrays.copyOfRange(info,1,info.length));


                    //check的作用：1.命令是否正确 2.账号密码是否正确
                    if(!methodInfo[0].equals(String.valueOf(info.length))){System.err.println("信息有误");continue;}
                    if(!info[0].equals("register") && !userService.checkId(args)){System.err.println("账号或密码错误");continue;}

                    //通过反射调用对应方法，并返回方法的结果打印出来
                    System.out.println(
                            userService.getClass().getDeclaredMethod(methodInfo[1],List.class).invoke(userService,(Object)args)
                    );

                }
            }

        }catch (Exception e) {
            System.out.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
    public static String getHelpWord(String username, String password){
        return "1. register "+username+" "+password + " \n" +
                "2. add "+username+" "+password + " 2020-10-11-08:00 2020-10-12-18:00 haohao\n" +
                "3. query "+username+" "+password +" 2020-10-10-08:00 2020-11-12-18:00\n" +
                "4. delete "+username+" "+password +" 21b00167-dc8d-4ab4-962b-c31878f72699\n" +
                "5. clear "+username+" "+password +" \n" +
                "6. quit\n" +
                "注: 时间格式支持yyyy-mm-dd 、yyyy-mm-dd-hh-mm 和 今天hh点\n";
    }
}
