#include<iostream>
 #include<cstring>
 using namespace std;
 int num[100000];
 int main(void)
 {
 	int n;
 	cin>>n;
 	for(int i=0;i<n;i++)
 	{
 		cin>>num[i];
 	}
 	int k;
 	for(int i=n-1,temp=-1;i>=0;i--)
 	{
 		if(num[i]<=temp)num[i]=temp-num[i]+1;
 			else
 		{
 			temp=num[i];
 			num[i]=0;
 		}
 	}
 	for(int i=0;i<n-1;i++)
 	{
 		cout<<num[i]<<' ';
 	}
 	cout<<num[n-1]<<endl;
 	return 0;
 }