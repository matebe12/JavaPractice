
public class Jokbo{

	int card1;
	int card2;
	int rank;
	
				//10,1,2,3,4,5,6,7,8,9,10,1k,2, 3k, 4, 5, 6, 7, 8k, 9 
	int[] card = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}; // �迭  20��
	
	
	
	int jokbo() { //���� ����
		if((card1==13&&card2==18) || (card2==13 && card1==18)) {
			rank= 100;//38����
		}else if((card1==11&&card2==13) || (card2==11&&card2==13)) {
			rank=99; // 13����
		}else if((card1==13&&card2==18) || (card2==13 && card1==18)) {
			rank=99; //18����
		}else if((card1==0&&card2==10) || (card2==0 && card1 ==10)) {
			rank=98;//�嶯
		}else if((card1==9&&card2==19) || (card2==9 && card1==19)) {
			rank=97;//9��
		}else if((card1==8&&card2==18) || (card2==8 && card1 ==18)) {
			rank=96; //8��
		}else if((card1==7&&card2==17) || (card2==7 && card1 == 17)) {
			rank=95;//7��
		}else if((card1==6&&card2==16) || (card2==6 && card1 == 16)) {
			rank=94;//6��
		}else if((card1==5&&card2==15) || (card2==5 && card1 == 15)) {
			rank=93;//5��
		}else if((card1==4&&card2==14) || (card2==4 && card1 == 14)) {
			rank=92;//4��
		}else if((card1==3&&card2==13) || (card2==3 && card1 == 13)) {
			rank=91;//3��
		}else if((card1==2&&card2==12) || (card2==2 && card1 == 12)) {
			rank=90;//2��
		}else if((card1==1&&card2==11) || (card2==1 && card1 == 11)) {
			rank=89;//1��
		
		//�� ���� ����
		}else if((card1==1&&card2==2) || (card2==1 && card1 == 2) || (card1==1&&card2==12) || (card2==1 && card1 == 12) 
						|| (card1==12&&card2==11) || (card2==12 && card1 == 11)|| (card1== 12&& card2==1) || (card2==12 && card1==11)) {
			rank=88;//�˸�
		}else if((card1==1&&card2==4) || (card2==1 && card1 == 4) || (card1==1&&card2==14) || (card2==1 && card1 == 14) 
				|| (card1==14&&card2==11) || (card2==14 && card1 == 11)|| (card1== 11&& card2==4) || (card2==11 && card1==4)) {
				rank=87;//����
		}else if((card1==1&&card2==9) || (card2==1 && card1 == 9) || (card1==1&&card2==19) || (card2==1 && card1 == 19) 
				|| (card1==11&&card2==9) || (card2==11 && card1 == 9) || (card1== 11&& card2==19) || (card2==11 && card1==19)) {
				rank=86;//����
		}
		else if((card1==1&&card2==9) || (card2==1 && card1 == 9) || (card1==1&&card2==19) || (card2==1 && card1 == 19) 
				|| (card1==11&&card2==9) || (card2==11 && card1 == 9) || (card1== 11&& card2==19) || (card2==11 && card1==19)) {
				rank=86;//����
		}else if((card1==1&&card2==0) || (card2==1 && card1 == 0) || (card1==1&&card2==10) || (card2==1 && card1 == 10) 
				|| (card1==11&&card2==0) || (card2==11 && card1 == 0) || (card1== 11&& card2==10) || (card2==11 && card1==10)) {
				rank=86;//���
		}else if((card1==4&&card2==0) || (card2==4 && card1 == 0) || (card1==4&&card2==10) || (card2==4 && card1 == 10) 
				|| (card1==14&&card2==0) || (card2==14 && card1 == 0) || (card1== 14&& card2==10) || (card2==14 && card1==10)) {
				rank=86;//���
		}else if((card1==4&&card2==6) || (card2==4 && card1 == 6) || (card1==4&&card2==16) || (card2==4 && card1 == 16) 
				|| (card1==14&&card2==6) || (card2==14 && card1 == 6) || (card1== 14&& card2==16) || (card2==14 && card1==16)) {
				rank=86;//����
	
				//������������
		}else if(card1+card2%10==0) {//����
			rank=0;
		}else if(card1+card2%10==1) {//�Ѳ�
			rank=1;
		}else if(card1+card2%10==2) {//�β�
			rank=2;
		}else if(card1+card2%10==3) {//����
			rank=3;
		}else if(card1+card2%10==4) {//�ײ�
			rank=4;
		}else if(card1+card2%10==5) {//�ټ���
			rank=5;
		}else if(card1+card2%10==6) {//������
			rank=6;
		}else if(card1+card2%10==7) {//�ϰ���
			rank=7;
		}else if(card1+card2%10==8) {//������
			rank=8;
		}else if(card1+card2%10==9) {//����
			rank=9;
		}		
		return rank;
	}
	
	void card() {
		System.out.println(card[5]);
	}
	
	
	

}