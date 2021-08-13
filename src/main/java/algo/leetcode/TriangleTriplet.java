package algo.leetcode;


public class TriangleTriplet {
	public void triangleTriplet(int a[])
{
	int n=a.length;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			for(int k=0;j<n;j++)
			{
				if(i!=j && j!=k && i!=k)
				if(a[i]+a[j]>a[k]  && a[j]+a[k]>a[i] && a[i]+a[k]>a[j])
				{
					System.out.println(a[i]+" "+a[j]+" "+a[k]);
				}
			}
		}
	}
}


public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	int a[]={9,8,7,10};
	
	new TriangleTriplet().triangleTriplet(a);

}}
