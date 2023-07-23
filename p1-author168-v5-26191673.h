#include<stdio.h>
 #include<string.h>
 #include<math.h>
 #include<algorithm>
 using namespace std;
 
 int a[101000];
 
 int main()
 {
     int t;
     scanf("%d", &t);
     for(int i=0; i<t; i++)
     {
         scanf("%d", &a[i]);
     }
     for(int i=0; i<t; i++)
     {
         int _max=a[t-1];
         for(int j=i+1; j<t; j++)
         {
             if(a[j]>=_max)
                 _max=a[j];
         }
         if(i!=t-1)
         {
             if(_max<a[i])
                 printf("0 ");
             else
                 printf("%d ", _max+1-a[i]);
         }
         if(i==t-1)
             printf("0\n");
     }
     printf("\n");
     return 0;
 }