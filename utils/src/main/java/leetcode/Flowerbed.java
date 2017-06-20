package leetcode;


import java.util.List;

public class Flowerbed {
	/*
    Suppose you have a long flowerbed in which some of the plots are planted and 
    some are not. However, flowers cannot be planted in adjacent plots - 
    they would compete for water and both would die. Given a flowerbed 
    (represented as an array containing booleans), return if a given number of 
    new flowers can be planted in it without violating the no-adjacent-flowers rule.
	 */

	public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
//		this.hashCode();
		if(flowerbed == null || flowerbed.isEmpty()){
			throw new IllegalArgumentException("bed is empty");
		}

		if(numberToPlace==0)
			return true;

		if(flowerbed.size()==1){
			return !flowerbed.get(0) && numberToPlace<=1;
		}

		int counter = 0;

		for(int i=0; i< flowerbed.size(); i++){
			if(!flowerbed.get(i)){
				if((i==0 && !flowerbed.get(i+1)) 
						|| (i==flowerbed.size()-1 && !flowerbed.get(i-1)) 
						|| (!flowerbed.get(i+1) && !flowerbed.get(i-1)) ){
					//place the flower
					flowerbed.set(i, true);
					counter++;
					if(counter==numberToPlace)
						return true;
				}
			}
		}    

		return false;
	}
	
	//solution 2
	public static boolean canPlant(int[] input,int n){
		int size = input.length;
		int planted = 0;
		int i=0;
		while(i < size) {
			if(input[i] == 0 ){
				if(input[i+1] == 0){
					planted++;
					i+=2;
				}else{
					i+=3;
				}
			}else{
				i+=2;
			}
			if(planted == n ){
				return true;
			}
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
