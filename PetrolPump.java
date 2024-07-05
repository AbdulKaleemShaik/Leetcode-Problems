// public class Petrol {
//     static class petrolPump {
//         int petrol;
//         int distance;

//         public petrolPump(int petrol, int distance) {
//             this.petrol = petrol;
//             this.distance = distance;
//         }
//     }

//     static int printTour(petrolPump arr[], int n) {
//         int start = 0;
//         int end = 1;
//         int curr_petrol = arr[start].petrol - arr[start].distance;
//         while (end != start || curr_petrol < 0) {
//             while (curr_petrol < 0 && start != end) {
//                 curr_petrol -= arr[start].petrol - arr[start].distance;
//                 start = (start + 1) % n;
//                 if (start == 0)
//                     return -1;
//             }
//             curr_petrol += arr[end].petrol - arr[end].distance;

//             end = (end + 1) % n;
//         }

//         return start;
//     }

//     public static void main(String[] args) {

//         petrolPump[] arr = { new petrolPump(4, 6),
//                 new petrolPump(6, 5),
//                 new petrolPump(7, 3), new petrolPump(4, 5) };

//         int start = printTour(arr, arr.length);

//         System.out.println(start == -1 ? "No Solution" : "Start = " + start);

//     }

// }

import java.util.*;

public class Petrol {
    static class petrolPump {

        int petrol;
        int distance;

        petrolPump(int a, int b) {
            this.petrol = a;
            this.distance = b;
        }
    };

    static int printTour(petrolPump p[], int n) {
        int start = 0, deficit = 0;
        int capacity = 0;
        for (int i = 0; i < n; i++) {
            capacity += p[i].petrol - p[i].distance;
            if (capacity < 0) {
                start = i + 1;
                deficit += capacity;
                capacity = 0;
            }
        }
        return (capacity + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        petrolPump arr[] = { new petrolPump(4, 6),
                new petrolPump(6, 5),
                new petrolPump(7, 3), new petrolPump(4, 5) };

        int n = arr.length;
        int start = printTour(arr, n);

        if (start == -1)
            System.out.print("No solution");
        else
            System.out.print("Start = " + start);

    }
}

// This code is contributed by umadevi9616
