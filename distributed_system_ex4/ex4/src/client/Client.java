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

            System.out.println("ϵͳ���ӳɹ�");

            //����һ���û�����command�ͷ����Ķ�Ӧ���Թ�����ķ������ʹ��
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

                    //info����ָ�����Ϣ��methodInfo���Ŷ�Ӧ������������Ϣ
                    String[] info = cmd.split(" ");String[] methodInfo = mapping.get(info[0]);
                    if(methodInfo == null) { System.out.println("��Ϣ��ʽ����");continue; }

                    //����ʵ���õ���Ϣת��Ϊlist�洢��args��
                    List<String> args = Arrays.asList(Arrays.copyOfRange(info,1,info.length));


                    //check�����ã�1.�����Ƿ���ȷ 2.�˺������Ƿ���ȷ
                    if(!methodInfo[0].equals(String.valueOf(info.length))){System.err.println("��Ϣ����");continue;}
                    if(!info[0].equals("register") && !userService.checkId(args)){System.err.println("�˺Ż��������");continue;}

                    //ͨ��������ö�Ӧ�����������ط����Ľ����ӡ����
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
                "ע: ʱ���ʽ֧��yyyy-mm-dd ��yyyy-mm-dd-hh-mm �� ����hh��\n";
    }
}
