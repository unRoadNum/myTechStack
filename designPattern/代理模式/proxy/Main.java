package proxy;

//ʹ�ô���ģʽʵ���ӳټ���

public class Main {
	
	public static void main(String [] args){
		InterfaceDBQuery q = new DBQueryProxy(); //ʹ�ô���
		q.request(); //��������ʹ��ʱ���ӳټ���
	}
}
