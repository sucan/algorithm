package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:19
 * @Description:
 */
public class LeetCode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        if(n == 0){
            if(isOdd){
                return nums2[nums2.length/2] * 1.0;
            }else{
                return (nums2[nums2.length/2] + nums2[nums2.length/2 - 1])/2.0;
            }
        }
        if(m == 0){
            if(isOdd){
                return nums1[nums1.length/2] * 1.0;
            }else{
                return (nums1[nums1.length/2] + nums1[nums1.length/2 - 1])/2.0;
            }
        }
        for(int i = 0;i<=(n+m)/2 && i<=n;i++){
            int j = (n+m)/2 - i;
            Double ans = isOk(nums1,nums2,i,j);
            if(ans != null){
                return ans;
            }
        }
        return 0;
    }


    public Double isOk(int[] nums1, int[] nums2,int i,int j){
        if(i > nums1.length || j > nums2.length){
            return null;
        }
        Integer lMax = null;
        Integer rMin = null;
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        lMax = max(i - 1 < 0?null:nums1[i-1],j - 1 < 0?null:nums2[j-1]);
        rMin = min(i >= nums1.length?null:nums1[i],j >= nums2.length?null:nums2[j]);
        if(lMax > rMin){
            return null;
        }
        if(isOdd){
            return rMin*1.0;
        }else{
            return (rMin + lMax)/2.0;
        }
    }

    public Integer max(Integer a,Integer b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        return Math.max(a,b);
    }

    public Integer min(Integer a,Integer b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        return Math.min(a,b);
    }
}
