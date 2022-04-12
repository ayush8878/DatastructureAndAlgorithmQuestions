package BinarySearch;

public class AngryBird {
    public static void main(String args[])
    {
        int[] nests = {1,2,4,8,9};
        int birds = 3;
        int largestMinDist = findLargestMinDistance(nests,birds);
        System.out.println(largestMinDist);
    }

    private static int findLargestMinDistance(int[] nests, int birds) {
        int min = 0;
        int max = nests[nests.length-1]-nests[0];
        int result = -1;
        while(min<=max)
        {
            int mid = (min + max) / 2;
            // check if all birds are placed successfully
            boolean canPlaceBirds = checkCanPlaceBirds(nests,birds,mid);
            if(canPlaceBirds)
            {
                result=mid;
                min = mid+1;
            }
            else
            {
                max=mid-1;
            }
        }
        return result;
    }


    private static boolean checkCanPlaceBirds(int[] nests, int birds, int sep) {
        // place first bird at first position
        int lastPlaced = nests[0];
        int b = 1;
        // place birds in position
        for(int i=1;i<nests.length;i++)
        {
            int currentPlaced=nests[i];
            // check for current bird if its separated by at-least sep
            if(currentPlaced-lastPlaced >= sep)
            {
                // increment birds
                b++;
                // update nest place with current
                lastPlaced=currentPlaced;
                if(b == birds)
                    return true;
            }
        }
        return false;
    }
}
