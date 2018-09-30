
public class Unit {

	private String name;
	private int HEALTH=100;
	int attack;
	int def;
	boolean defence;
	
	Unit(String name){//생성자
		this.name=name;
	}
	
	int attack() { //공격데미지
		
		this.attack= (int) (Math.random()*10)+1;
		if(attack==1|| attack ==2 || attack ==3) {//크리티컬 확률
			attack=critical();
			System.out.println("!!!!!Critical!!!!");
		}
		return attack;
		
	}
	
	int critical() { // 크리티컬 데미지
		return attack=20;
	}
	boolean defence() {
		
		def =(int)(Math.random()*3)+1;//방어 확률
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
		Unit user =new Unit("사용자");
		Unit cpu =new Unit("컴퓨터");

		int ret; //user cpu 둘중 한명 공격자 선택용 주사위 변수
		boolean select = true;
		
			
			while(user.HEALTH>0 && cpu.HEALTH>0 && select==true) {
				ret =(int)(Math.random()*2) +1; //공격자 주사위
				
				
				if(ret==2) {
				
					try {
						Thread.sleep(500); // 슬립 0.5초
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					cpu.defence();
					if(cpu.defence()==true) {
						System.out.println("User 공격");
						System.out.println("Cpu 방어성공");
						System.out.println("Cpu Health : "+cpu.HEALTH);
						System.out.println("======턴 종료=======");
						System.out.println();
						
					}else if(cpu.defence()==false) {
						System.out.println("User 공격");
						System.out.println("Cpu 방어실패");
						cpu.HEALTH-= user.attack(); //현재 피에서 데미지 뺌
						System.out.println("Cpu Health : "+cpu.HEALTH);
						System.out.println("======턴 종료=======");
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
						System.out.println("Cpu 공격");
						System.out.println("User 방어성공");
						System.out.println("User Health : "+user.HEALTH);
						System.out.println("======턴 종료=======");
						System.out.println();
						
					}else if(user.defence()==false) {
						System.out.println("Cpu 공격");
						System.out.println("User 방어실패");
						user.HEALTH-= cpu.attack();
						System.out.println("User Health : "+user.HEALTH);
						System.out.println("======턴 종료=======");
						System.out.println();
					}
				}
				if(user.HEALTH<=0) { //승자 정함
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
