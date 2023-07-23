#include<stdio.h>
 int a[100005],b[100005];
 int main()
 {
     int n,i,Max=0;
     scanf("%d",&n);
     for(i=0;i<n;i++)
     {
         scanf("%d",&a[i]);
     }
     for(i=n-1;i>=0;i--)
     {
         if(Max<a[i])
         {
             Max=a[i];
             b[i]=0;
         }
         else
         {
             b[i]=Max-a[i]+1;
         }
     }
     for(i=0;i<n;i++)
     {
         printf("%d ",b[i]);
     }
     printf("\n");
     return 0;
 }