public class Solution {

public static void swap(int[] profitByWeight, int[] values, int[] weights, int i, int j) {
   
    int temp = profitByWeight[i];
    profitByWeight[i] = profitByWeight[j];
    profitByWeight[j] = temp;

    temp = values[i];
    values[i] = values[j];
    values[j] = temp;


    temp = weights[i];
    weights[i] = weights[j];
    weights[j] = temp;
}

    
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        
        int ProfitByWeight[]= new int[values.length];

        for(int i=0;i<values.length;i++)
        {
          ProfitByWeight[i]=values[i]/weights[i];
        }
        
for (int i = 0; i < values.length; i++) {
    int greatest = i;  

   
    for (int j = i + 1; j < values.length; j++) {
        if (ProfitByWeight[j] > ProfitByWeight[greatest]) {
            greatest = j;
        }
    }
       
       
   swap(ProfitByWeight, values, weights, i, greatest);
        
    }
    

        double totalProfit = 0.0;

        for (int b = 0; b < weights.length; b++) {
            if (W == 0) break;

            if (weights[b] <= W) {
                totalProfit += values[b];
                W -= weights[b];
            } else {
                totalProfit += ((double) values[b] / weights[b]) * W;
                W = 0;
            }
        }

        return Math.round(totalProfit * 1e6) / 1e6;  // Round to 6 decimal places
    }
}