package test1;

import java.util.Scanner;


public class Main {
	public static void main(String args[])
	{
		String cata[];String role[];String name[];
		int priv[][];int level[];int wei[][];
		Scanner scanner=new Scanner(System.in);
		int p=scanner.nextInt();
		cata=new String[p+1];
		level=new int[p+1];
		for(int i=1;i<=p;i++)
		{
			String s=scanner.next();
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)==':')
				{
					cata[i]=s.substring(0,j);
					level[i]=Integer.parseInt(s.substring(j+1,s.length()));
					break;
				}
				if(j==s.length()-1)
				{
					cata[i]=s;
					level[i]=0;
				}
			}
		}
		int r=scanner.nextInt();
		priv=new int[r+1][p+1];
		for(int i=0;i<=r;i++)
		{
			for(int j=0;j<=p;j++)
			{
				priv[i][j]=-1;
			}
		}
		role=new String[r+1];
		for(int i=1;i<=p;i++)
		{
			priv[0][i]=level[i];
		}
		for(int i=1;i<=r;i++)
		{
			role[i]=scanner.next();
			int num=scanner.nextInt();
			for(int j=1;j<=num;j++)
			{
				String s=scanner.next();
				String cata1 = null;int level1 = 0;
				for(int k=0;k<s.length();k++)
				{
					if(s.charAt(k)==':')
					{
						cata1=s.substring(0,k);
						level1=Integer.parseInt(s.substring(k+1,s.length()));
						break;
					}
					if(k==s.length()-1)
					{
						cata1=s;
						level1=0;
					}
				}
				for(int k=1;k<=p;k++)
				{
					if(cata1.equals(cata[k]))
					{
						if(level1>priv[i][k])priv[i][k]=level1;
						break;
					}
				}
			}
		}
		int u=scanner.nextInt();
		name=new String[u+1];
		wei=new int[u+1][10001];
		for(int i=1;i<=u;i++)
		{
			name[i]=scanner.next();
			wei[i][0]=scanner.nextInt();
			for(int j=1;j<=wei[i][0];j++)
			{
				String s=scanner.next();
				for(int k=1;k<=r;k++)
				{
					if(role[k].equals(s))
					{
						wei[i][j]=k;
					}
				}
			}
		}
		int q=scanner.nextInt();
		for(int i=1;i<=q;i++)
		{
			String name0=scanner.next();
			int id=0;
			for(int j=1;j<=u;j++)
			{
				if(name[j].equals(name0))
				{
					id=j;
					break;
				}
			}
			if(id==0)
			{
				System.out.println("false");
				continue;
			}
			String s=scanner.next();
			String cata1 = null;int level1 = 0;
			int check=0;
			for(int k=0;k<s.length();k++)
			{
				if(s.charAt(k)==':')
				{
					cata1=s.substring(0,k);
					level1=Integer.parseInt(s.substring(k+1,s.length()));
					break;
				}
				if(k==s.length()-1)
				{
					cata1=s;
					level1=0;
					check=1;
				}
			}
			int maxpriv=-1;
			for(int k=1;k<=p;k++)
			{
				if(cata1.equals(cata[k]))
				{
					if(priv[id][k]>maxpriv)maxpriv=priv[id][k];
				}
				if(k==p)
					{
						if(maxpriv==-1)System.out.println("false");
						else if(maxpriv==0||check==0)System.out.println(true);
						else {
							System.out.println(maxpriv);
						}
					}
			}
		}
	}
}
