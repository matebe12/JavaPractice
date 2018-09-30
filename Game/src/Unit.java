
public class Unit {

	private String name;
	private int HEALTH=100;
	int attack;
	int def;
	boolean defence;
	
	Unit(String name){//������
		this.name=name;
	}
	
	int attack() { //���ݵ�����
		
		this.attack= (int) (Math.random()*10)+1;
		if(attack==1|| attack ==2 || attack ==3) {//ũ��Ƽ�� Ȯ��
			attack=critical();
			System.out.println("!!!!!Critical!!!!");
		}
		return attack;
		
	}
	
	int critical() { // ũ��Ƽ�� ������
		return attack=20;
	}
	boolean defence() {
		
		def =(int)(Math.random()*3)+1;//��� Ȯ��
		if(def==1) {
			defence=true;
		}else if(def!=1) {
			defence=false;
		}
		return defence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHEALTH() {
		return HEALTH;
	}
	
	
	
	public static void main(String[] args) {
		Unit user =new Unit("�����");
		Unit cpu =new Unit("��ǻ��");

		int ret; //user cpu ���� �Ѹ� ������ ���ÿ� �ֻ��� ����
		boolean select = true;
		
			
			while(user.HEALTH>0 && cpu.HEALTH>0 && select==true) {
				ret =(int)(Math.random()*2) +1; //������ �ֻ���
				
				
				if(ret==2) {
				
					try {
						Thread.sleep(500); // ���� 0.5��
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					cpu.defence();
					if(cpu.defence()==true) {
						System.out.println("User ����");
						System.out.println("Cpu ����");
						System.out.println("Cpu Health : "+cpu.HEALTH);
						System.out.println("======�� ����=======");
						System.out.println();
						
					}else if(cpu.defence()==false) {
						System.out.println("User ����");
						System.out.println("Cpu ������");
						cpu.HEALTH-= user.attack(); //���� �ǿ��� ������ ��
						System.out.println("Cpu Health : "+cpu.HEALTH);
						System.out.println("======�� ����=======");
						System.out.println();
					}
					
				}else if(ret==1) {
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					user.defence();
					if(user.defence()==true) {
						System.out.println("Cpu ����");
						System.out.println("User ����");
						System.out.println("User Health : "+user.HEALTH);
						System.out.println("======�� ����=======");
						System.out.println();
						
					}else if(user.defence()==false) {
						System.out.println("Cpu ����");
						System.out.println("User ������");
						user.HEALTH-= cpu.attack();
						System.out.println("User Health : "+user.HEALTH);
						System.out.println("======�� ����=======");
						System.out.println();
					}
				}
				if(user.HEALTH<=0) { //���� ����
					System.out.println("========");
					System.out.println("Cpu win");
					System.out.println("========");
					
				}else if(cpu.HEALTH<=0) {
					System.out.println("========");
					System.out.println("User win");
					System.out.println("========");
				}
			}
	}
	
}
