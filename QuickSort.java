public class QuickSort implements SortingAlgorithm{
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public void quickSort(int[] arr, int low, int high) {
        int p = partition(arr, low, high);
        quickSort(arr, low, p-1);
        quickSort(arr, p+1, high);
    }

    int partition(int [] arr, int low, int high){
        if(low < high){
            int pivot = low;
            int i = low+1;
            int k = high;
            while(i<k){
                while(i<=k && arr[i] < arr[pivot]){
                    ++i;
                }
                while(k>=i && arr[k]>arr[pivot]){
                    --k;
                }
                if(i < k){
                    //below is swap(i ,k, arr);
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
            //below is swap(k, pivot, arr);
            int temp = arr[k];
            arr[k] = arr[pivot];
            arr[pivot] = temp;
            return k;
        }
        return -1;
    }

}

