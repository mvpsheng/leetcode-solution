package meituan;

/**
 * FileName: NSteps
 * author: gxs
 * Date: 2021/9/11  17:11
 */
/**
 * c++实现
 * #include <iostream>
 * using namespace std;
 * int sum;
 * void dfs(int x,int l)
 * {
 *     if(l>x)
 *     {
 *         return;
 *     }
 *     if((l+1)==x)
 *     {
 *         sum++;
 *     }
 *     if((l+2)==x)
 *     {
 *         sum++;
 *     }
 *     if((l+3)==x)
 *     {
 *         sum++;
 *     }
 *     if((l+4)==x)
 *     {
 *         sum++;
 *     }
 *     if((l+5)==x)
 *     {
 *         sum++;
 *     }
 *     if((l+6)==x)
 *     {
 *         sum++;
 *     }
 *         dfs(x,l+1);
 *         dfs(x,l+2);
 *         dfs(x,l+3);
 *         dfs(x,l+4);
 *         dfs(x,l+5);
 *         dfs(x,l+6);
 * }
 * int main()
 * {
 *     int n;
 *     cin>>n;
 *     dfs(n,0);
 *     cout<<sum<<endl;
 *     return 0;
 * }
 * */
public class NSteps {

}
