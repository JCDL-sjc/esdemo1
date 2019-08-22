import org.junit.Test;

/**
 * @创建人 健程大佬
 * @创建时间 2019/8/19    8:44
 * @描述
 */
public class test {
    @Test
    public void test(){

        int a[] = {7,2,3,4,5};
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println(1-100/3%1);
    }
}
