#include<stdio.h>

int fibonacci(int n) {
    int fib_series[n + 1];
    fib_series[0] = 0;
    fib_series[1] = 1;
    for(int i = 2; i <= n; i++){
        fib_series[i] = fib_series[i - 1] + fib_series[i - 2];
    }
    return fib_series[n];
}

int main() {
    int months;
    printf("enter the no of months:");
    scanf("%d", &months);

    printf("the no of pairs of rabbit at the end of %dth month are: %d", months, fibonacci(months));
    return 0;
}

/*yes_pair = pair that can reproduce
no_pair = pair that can't reproduce


month 0   - 0 -   zero pairs

month 1   - 1 -   no_pair(1)                                                              
                    
month 2   - 1 -  yes_pair(1)          
    
month 3   - 2 -  yes_pair(1) + no_pair(2)
                             
month 4   - 3 -  yes_pair(1) + yes_pair(2) + no_pair(3) - (1 yes_pair from above)
							  
month 5   - 5 -  yes_pair(1) + yes_pair(2) + Yes_pair(3) + (no_pair(4) + no_pair(5) from the above 2 yes_pair s)
                                                                  
month 6   - 8 -  yes_pair(1) + yes_pair(2) + yes_pair(3) + yes_pair(4) + yes_pair(5) + (no_pair(6) + no_pair(7) + no_pair(8) from the above 3 yes_pairs)
	:
	:
	:
series = 0, 1, 2, 3, 5, 8, 13, ......

f(n) = f(n - 1) + f(n - 2)  --  inaddition, all the pairs from the 2 months before can be reproduce now as they are all older than 2 months 
           |
       all the pairs from the month before remains same */