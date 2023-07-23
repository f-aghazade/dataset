#include<stdio.h>

 #include<string.h>

 #define maxn 100005

 int a[maxn];

 using namespace std;

 int main(void)

 {

     __int64 n,i,j,Max;

     memset(a,0,sizeof(a));

     while(scanf("%I64d",&n)!=EOF)

     {

         for(i=1;i<=n;i++)

             scanf("%I64d",&a[i]);

         for(i=1;i<n;i++)

         {

             Max=a[i+1];

             for(j=i+1;j<=n;j++)

             {

                 if(Max<a[j])

                     Max=a[j];

             }

             if(a[i]<Max)

             printf("%I64d ",Max+1-a[i]);

             else

                 printf("0 ");

         }

         if(i==n)

             printf("0\n");

     }

     return 0;

 }