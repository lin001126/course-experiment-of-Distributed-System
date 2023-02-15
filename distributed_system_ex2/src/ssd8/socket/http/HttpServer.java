package ssd8.socket.http;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    ServerSocket server;
    private static final int PORT = 80;
     static File root;//文件root目录
    ExecutorService executorService; // 线程池
    final int POOL_SIZE = 5; // 单个处理器线程池工作线程数目

    public HttpServer(String root) throws IOException {
        this.root = new File(root);
        this.server = new ServerSocket(PORT, 5);
        this.executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() * POOL_SIZE);
        // 创建线程池
        // Runtime的availableProcessors()方法返回当前系统可用的java虚拟机处理器的数目
        // 根据可用处理器数目，设置线程数量
        System.out.println("服务器启动");
    }

    public static void main(String[] args) throws  Exception {
        // pass root directory by String[] args
        if (args.length < 1) {
            System.out.println("请输入root目录参数");
        } else if (isRight(args[0])) {
            // 验证文件夹路径是否正确
            new HttpServer(args[0]).service();
        } else {
            System.out.println("这不是一个有效地址，请重新输入");
        }
    }

    /**
     * service implements
     */
    public void service() throws Exception {
        Socket socket = null;
        //循环等待客户端连接
        while (true) {
            try {
                socket = server.accept(); // 等待并取出用户连接，并创建套接字

                executorService.execute(new Handler(socket, root));// 使用线程池维护


            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 验证path路径是否存在并且为文件夹
    private static boolean isRight(String path) {

        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }
}
