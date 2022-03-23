package Array;

public class Rains {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int waterStored = getWaterStored(height);
        System.out.print(waterStored);
    }

    private static int getWaterStored(int[] height)
    {
        int waterStored = 0;
        int []left = new int[height.length];
        int []right = new int[height.length];
        for(int i=0, j=height.length - 1;i<height.length;i++,j--)
        {
            int leftNode = height[i];
            if(i == 0 || leftNode > left[i-1])
            {
                left[i] = leftNode;
            }
            else
            {
                left[i] = left[i-1];
            }
            int rightNode = height[j];
            if(j == height.length-1 || rightNode > right[j+1])
            {
                right[j] = rightNode;
            }
            else
            {
                right[j] = right[j+1];
            }
        }

        for(int i=1;i<height.length-1;i++)
        {
            int waterUnits = Math.min(left[i],right[i])-height[i];
            waterStored+=waterUnits;
        }
        return waterStored;
    }
}
