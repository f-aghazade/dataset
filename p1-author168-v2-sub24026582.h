#include<iostream>
 using namespace std;
 
 int main()
 {
 	int n,k,max,count=0;
 	int h[100000],a[100000];
 	cin>>n;
 	for(int i=0;i<n;i++)
 		cin>>h[i];
 	for(int i=0;i<n-1;i++){
 		for(int j=i+1;j<n;j++)
 			a[i]=(h[i]<=h[j])?(h[j]-h[i]+1):0;
 		a[n-1]=0;
 	}
 	for(int i=0;i<n;i++)
 		cout<<a[i]<<" ";
 	cout<<endl;
 	return 0;
 }