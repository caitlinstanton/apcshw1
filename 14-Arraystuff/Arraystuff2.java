import java.util.*;

public class Arraystuff2 {
    private int[] a;
    private Random rnd;

    /*
    by making a variable final, we can't change the value
    after initial assignment
    public final int final_example = 123;
    */
    public Arraystuff(int n) {
	rnd = new Random();
	a = new int[100];
	for (int i = 0; i < a.length; i++){
	    a[i] = rnd.nextInt(150 - 75) + 75;
	}
    }

    public Arraystuff() {
	this(100);
    }

    public String toString(){
	String s = "";
	//length for arrays is a variable with a final value
	for (int i = 0; i < a.length; i++){
	    if (i < a.length - 1) {
		s = s + a[i] + ", ";
	    } else {
		s = s + a[i];
	    }
	}
	/*
	this is invalid because the var is final final_example = 123
	s = s + final_example;
	*/
	return s;
    }

    public int find(int n) {
    	int value = -1;
    	for (int i = 0; i < a.length; i++){
	    if(a[i] == n){
		value = i;
	    }
	}
	return value;
    }
    
    public int find2(int n) {
	for (int i = 0; i < a.length; i++){
	    if(a[i] == n){
		return i;
	    }
	}
	return -1;
    }

    public int maxVal(){
	int value = a[0];
	for (int i = 1; i < a.length; i++){
	    if (value < a[i]){
		value = a[i];
	    }
	}
	return value;
    }

    public int freq(int i) {
	int counter = 0;
	int answer = a[i];
	int freq = 0;
	while (counter < a.length) {
	    if (a[counter] == a[i]){
		freq = freq + 1;
	    }
	    counter++;
	}
	return freq;
    }

    public int sum67(int[] nums) {
	int sum = 0;
	for (int i = 0; i < nums.length; i++){
	    if(nums[i] == 6) {
		while(nums[i] != 7) {
		    i++;
		}
	    } else {
		sum = sum + nums[i];
	    }
	}
	return sum;
    }

    public boolean more14(int[] nums) {
	int number1 = 0;
	int number4 = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] == 1) {
		number1 = number1 + 1;
	    }
	    if (nums[i] == 4) {
		number4 = number 4 + 1;
	    }
	}
	return (number1 > number4);
    }

    public int[] tenRun(int[] nums) {
	int[] result = new int[nums.length];
	boolean multiple = false;
	int value = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] % 10 == 0) {
		multiple = true;
		value = nums[i];
		result[i] = nums[i];
	    } else if (nums[i] % 10 != 0 && multiple) {
		result[i] = value;
	    } else if (nums[i] % 10 != 0 && !multiple) {
		result[i] = nums[i];
	    }
	}
	return result;
    }

    public static void main(String[] args){
	Arraystuff as = new Arraystuff();
	//	System.out.println(as);
	//	System.out.println(as.find(134));
	//	System.out.println(as.find(906));
	//	System.out.println(as.maxVal());
	System.out.println(as.freq(17));
    }
    
}
