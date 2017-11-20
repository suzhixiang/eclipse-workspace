package timu2;

import java.util.Scanner;

public class timu2 
{
	static int a[]=new int[100000],b[]=new int[100000],c[]=new int[100000];
	static int first1=0;
	static void sort1(int s,int e)
	{
		if(e<=s)return;
		int mid=(s+e)/2;
		sort1(s, mid);
		sort1(mid+1, e);
		int num=s,s1=s,s2=mid+1;
		while(s1<=mid||s2<=e)
		{
			if(s1>mid)
			{
				c[num]=b[s2];
				num++;
				s2++;
			}
			else if(s2>e)
			{
				c[num]=b[s1];
				num++;
				s1++;
			}
			else if(b[s1]<b[s2])
			{
				c[num]=b[s1];
				num++;
				s1++;
			}
			else 
			{
				c[num]=b[s2];
				num++;
				s2++;
			}
		}
		for(int i=s;i<=e;i++)
		{
			b[i]=c[i];
		}
	}
	static void treeout(int x,int num)
	{
		if(x>=num)return ;
		treeout(x*2+1, num);
		treeout(x*2+2, num);
		if(first1!=0)System.out.print(",");
		System.out.print(a[x]);
		first1=1;
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		String s=new String();
		s=scan.nextLine();
		int sum=0,sum1=0,num=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='��')
			{
				
				a[num]=sum;
				b[num]=a[num];
				sum1+=sum;
				sum=0;
				num++;
			}
			else
			{
				sum*=10;
				sum+=s.charAt(i)-'0';
			}
		}
		
		a[num]=sum;
		b[num]=a[num];
		sum1+=sum;
		num++;
		System.out.print(sum1/num);
		System.out.print("#");
		sort1(0,num-1);
		first1=0;
		for(int i=0;i<num;i++)
		{
			if(first1!=0)System.out.print(",");
			System.out.print(b[i]);
			first1=1;
		}
		first1=0;
		System.out.print("#");
		treeout(0,num);
		first1=0;
	}
}
