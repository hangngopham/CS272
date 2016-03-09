package lab1;

public class countNum {
	int count1 = 0;
	int count2 = 0;
	int count3 = 0;
	public void countTotal() {
		for(int i = 1; i < 51; i++) {
			if(i % 6 == 0) {
				System.out.println(i + " Blueberry");
				count1++;
			}
			else if(i % 2 == 0) {
				System.out.println(i + " Blue");
				count2++;
			}
			else if(i % 3 == 0) {
				System.out.println(i + " Berry");
				count3++;
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	public void printNum() {
		System.out.println("Count1: " + count1);
		System.out.println("Count2: " + count2);
		System.out.println("Count3: " + count3);
	}
	public static void main(String[] args) {
		countNum cn = new countNum();
		cn.countTotal();
		cn.printNum();
		
	}
}
