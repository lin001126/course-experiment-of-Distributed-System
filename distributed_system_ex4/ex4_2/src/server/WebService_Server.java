package server;



import javax.xml.ws.Endpoint;

/**
 * WebService Server
 * 
 * @author zjj
 *
 */
public class WebService_Server {

	/**
	 * 启动 WebService 注册服务并进行对象注册
	 */
	public static void main(String[] args) {
		try {
			//将服务发布出去
			Endpoint.publish("http://127.0.0.1:8888/service", new UserServiceImpl());
			System.out.println("Webservice 发布成功！");
		} catch (Exception e) {
			System.out.println("failed: " + e);
			e.printStackTrace();
		}
	}

}
