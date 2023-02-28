Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
  
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
  
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.


Input:
        N = 4
        Petrol = 4 6 7 4
        Distance = 6 5 3 5
Output: 1
Explanation: There are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5},
              {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. 
              Output in this case is 1 (index of 2nd petrol pump).
  
  
class Solution {
    int tour(int petrol[], int distance[]) {
	
	    int petrolSum = 0, distanceSum = 0; 
	    for(int i = 0; i < petrol.length; i++){
	        petrolSum += petrol[i];
	        distanceSum += distance[i];
	    }
	    
	    if(distanceSum > petrolSum){
	        return -1;
	    }
	    
	    int remainPetrol = 0, startIndex = 0;

        for(int i = 0; i < petrol.length; i++) {
            remainPetrol += (petrol[i] - distance[i]);
            if(remainPetrol < 0) {
                startIndex = i + 1;
                remainPetrol = 0;
            }
        }

        return startIndex;
    }
}
