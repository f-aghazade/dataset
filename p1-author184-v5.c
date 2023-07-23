#include<stdio.h>

 #include<string.h>

 #define maxn 100005

 __int64 a[maxn],b[maxn];

 int main(void)

 {

     __int64 n,i;

     memset(a,0,sizeof(a));

     memset(b,0,sizeof(b));

     scanf("%I64d",&n);

     for(i=1;i<=n;i++)

         scanf("%I64d",&a[i]);

     b[n]=a[n];

     for(i=n-1;i>=1;i--)

         {

             if(a[i]<b[i+1])

                 b[i]=b[i+1];

             else

                 b[i]=a[i];

         }

         for(i=1;i<n-1;i++)

         {

             if(a[i]<b[i+1])

                 printf("%I64d ",b[i+1]+1-a[i]);

             else

                 printf("0 ");

         }

     if(i==n)

         printf("0\n");

     return 0;

 }