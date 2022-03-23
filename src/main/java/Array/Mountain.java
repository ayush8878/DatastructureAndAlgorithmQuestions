package Array;

public class Mountain {
    public static void main(String[] args) {
        //int [] arr = new int[]{1,6,3,4,5};
        int [] arr = new int[]{5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
        int mountainPeak = findMountainPeak(arr);
        System.out.println(mountainPeak);
    }

    private static int findMountainPeak(int[] mountain) {
        // setting peak as min
        int highestPeakLength = Integer.MIN_VALUE;
        // Mountain should have at-least 3 points
        if(mountain.length < 3)
        {
            return -1;
        }
        int currentPeak = Integer.MIN_VALUE;
        int length = 0;
        for(int i = 1;i<mountain.length - 1;i++) {
            // reset current peak if right side of mountain is becoming greater than peak
            if (mountain[i] > mountain[i - 1] && mountain[i] < mountain[i + 1]) {
                if(highestPeakLength < length)
                highestPeakLength = length;
                // currentPeak = Integer.MIN_VALUE;
                length = 0;
            }
            // found new peak ,
            else if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                // Setting current peak
                currentPeak = mountain[i];
                int j = i - 1;
                // check left length from peak
                while (j >= 0) {
                    // break loop when mountain[j] become greater than current peak or the next forward peak
                    if (mountain[j] > mountain[j+1]) {
                        break;
                    }
                    length += mountain[j+1] - mountain[j];
                    j--;
                }
                // include length of next forward peak
                length+= mountain[i]-mountain[i+1];
            }
            // Decreasing from peak
            else if(mountain[i] - mountain[i+1] > 0)
            {
                // increase length of mountain
                length+= mountain[i]-mountain[i+1];
            }
        }
        return highestPeakLength;
        }
    }
