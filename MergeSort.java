public class MergeSort implements SortingAlgorithm{
    public void sort(int[] arr) {
        mergesort(arr, 0, arr.length-1);
    }

    void mergesort(int [] arr, int left, int right){
        if (left >= right){ //base case
            return;
        }
        int mid = (left+right)/2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[arr.length - mid];
        for(int i = 0; i < mid; i++){
            left_arr[i] = arr[i];
        }
        for(int i = mid+1; i < arr.length-1; i++){
            right_arr[i - mid] = arr[i];
        }
        mergesort(left_arr, left, mid);
        mergesort(right_arr, mid+1, right);
        merge(left_arr, right_arr, arr);
    }

    void merge(int [] left_arr, int [] right_arr, int [] target){
        int left = 0;
        int right = 0;
        int target_index = 0;

        while(left < left_arr.length && right < right_arr.length){
            if(left_arr[left]< right_arr[left]){
                target[target_index] = left_arr[left];
                ++left;
            } else{
                target[target_index] = right_arr[right];
                ++right;
            }
            ++target_index;
        }

        while(left<left_arr.length){
            target[target_index]= left_arr[left];
            target_index++;
            left++;
        }
        while(right<right_arr.length){
            target[target_index]= right_arr[right];
            target_index++;
            right++;
        }
    }

}
