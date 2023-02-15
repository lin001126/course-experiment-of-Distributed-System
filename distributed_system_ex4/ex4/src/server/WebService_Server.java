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
	 * ���� WebService ע����񲢽��ж���ע��
	 */
	public static void main(String[] args) {
		try {
			//�����񷢲���ȥ
			Endpoint.publish("http://127.0.0.1:8888/service", new UserServiceImpl());
		} catch (Exception e) {
			System.out.println("Hello Server failed: " + e);
			e.printStackTrace();
		}
	}

}
