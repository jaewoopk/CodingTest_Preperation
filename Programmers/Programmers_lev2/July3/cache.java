package Programmers_lev2.July3;

import java.util.LinkedList;

public class cache {
    public static void main(String[] args) {

    }
}

class Solution703_1 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> list = new LinkedList<>();
        for (var city : cities) {
            city = city.toLowerCase();

            if (list.contains(city)) {
                list.remove(city);
                list.addFirst(city);
                answer += 1;
            } else {
                if (list.size() >= cacheSize) {
                    list.pollLast();
                }
                list.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }
}

// import java.util.LinkedList;

// class Solution {
//     public int solution(int cacheSize, String[] cities) {
//         Database database = new Database(cacheSize);

//         int time = database.search(cities);

//         return time;
//     }
// }

// class Database {
//      private final Cache cache;

//     public Database(int cacheSize) {
//         this.cache = new Cache(cacheSize);
//     }

//     public int search(String[] cities) {
//         int hit = 0;
//         int miss = 0;

//         for (String city : cities) {
//             if (cache.match(city.toLowerCase())) {
//                 hit += 1;

//                 continue;
//             }

//             miss += 1;
//         }

//         return getProcessTime(hit, miss);
//     }

//     private int getProcessTime(int hit, int miss) {
//         return hit * 1 + miss * 5;
//     }
// }

// class Cache {
//     private int size;
//     private LinkedList<String> storage = new LinkedList<>();

//     public Cache(int cacheSize) {
//         this.size = cacheSize;
//     }

//     public boolean match(String city) {
//         if (size == 0) {
//             return false;
//         }

//         if (storage.contains(city)) {
//             if (storage.size() == size) {
//                 storage.remove(storage.lastIndexOf(city));
//                 storage.addFirst(city);

//                 return true;
//             }

//             storage.addFirst(city);

//             return true;
//         }

//         if (storage.size() == size) {
//             storage.removeLast();
//             storage.addFirst(city);

//             return false;
//         }

//         storage.addFirst(city);

//         return false;
//     }
// }


// import java.util.LinkedList;

// public class Solution {
//     public static void main(String[] args) {
//         // Test cases
//     }

//     public int solution(int cacheSize, String[] cities) {
//         Cache cache = new Cache(cacheSize);

//         int totalTime = 0;
//         for (String city : cities) {
//             if (cache.isInCache(city.toLowerCase())) {
//                 totalTime += 1; // cache hit
//             } else {
//                 totalTime += 5; // cache miss
//             }
//         }

//         return totalTime;
//     }
// }

// class Cache {
//     private final int size;
//     private final LinkedList<String> storage;

//     public Cache(int size) {
//         this.size = size;
//         this.storage = new LinkedList<>();
//     }

//     public boolean isInCache(String city) {
//         if (size == 0) {
//             return false;
//         }

//         if (storage.contains(city)) {
//             storage.remove(city);
//             storage.addFirst(city);
//             return true;
//         } else {
//             if (storage.size() == size) {
//                 storage.removeLast();
//             }
//             storage.addFirst(city);
//             return false;
//         }
//     }
// }
