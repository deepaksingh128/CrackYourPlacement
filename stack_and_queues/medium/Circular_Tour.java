class Solution
{
    // t.c.=> O(n)   , s.c.=> O(1)
    
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	    int extraPetrol = 0;
	    int startPos = 0;
	    int needed = 0;
	    
	    for (int i=0; i<petrol.length; i++) {
	        extraPetrol = extraPetrol + petrol[i] - distance[i];
	        
	        if (extraPetrol < 0) {
	            startPos = i + 1;
	            needed += Math.abs (extraPetrol);
	            extraPetrol = 0;
	        }
	    }
	    
	    if (extraPetrol - needed >= 0) {
	        return startPos;
	    } else {
	        return -1;
	    }
    }
}
