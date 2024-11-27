package src.Medium.Problem146;

import java.util.*;
import src.common.ListUtils;

class LRUCache {
    private ArrayDeque<Integer> lruCache;
    private Map<Integer, Integer> lruMap;
    private int maxCapacity;

    public LRUCache(int capacity) {
        lruCache = new ArrayDeque<Integer>(capacity);
        lruMap = new HashMap<Integer, Integer>();

        maxCapacity = capacity;
    }
    
    public int get(int key) {
        int rval = lruMap.getOrDefault(Integer.valueOf(key), -1);
        if ( rval != -1 ){ 
            lruCache.remove(Integer.valueOf(key));
            lruCache.addLast(Integer.valueOf(key));
        }

        return rval;
    }
    
    public void put(int key, int value) {
        if ( this.get(key) != -1 ){
            lruMap.put(Integer.valueOf(key), Integer.valueOf(value));
        } else {
            if ( lruCache.size() == maxCapacity ){
                Integer leastRecentlyUsedElem = lruCache.removeFirst();
                lruMap.remove(Integer.valueOf(leastRecentlyUsedElem));
            }

            lruCache.addLast(Integer.valueOf(key));
            lruMap.put(Integer.valueOf(key), Integer.valueOf(value));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Solution {
    public static List<String> runTC(String [] tcCmds, int [][] tcArgs){
        LRUCache lruCache = new LRUCache(2);

        List<String> output = new ArrayList<String>();

        for ( int cmdIdx = 0; cmdIdx < tcCmds.length; cmdIdx++ ){
            String cmd = tcCmds[cmdIdx];
            int [] args = tcArgs[cmdIdx];
            if ( cmd.equals("LRUCache") ){
                lruCache = new LRUCache(args[0]);
                output.add("null");
            } else if ( cmd.equals("put") ){
                lruCache.put(args[0], args[1]);
                output.add("null");
            } else if ( cmd.equals("get") ){
                output.add(String.valueOf(lruCache.get(args[0])));
            }
        }

        return output;
    }
    public static void main(String[] args){ 
        Solution sol = new Solution();

        String [] tcCmds = new String[]{"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int [][] tcArgs = new int[][]{{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
        List<String> output = sol.runTC(tcCmds, tcArgs);
        ListUtils.printStringList(output);

        //["LRUCache","get","put","get","put","put","get","get"]
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

        String [] tcCmds2 = new String[]{"LRUCache","get","put","get","put","put","get","get"};
        int [][] tcArgs2 = new int[][]{{2},{2},{2,6},{1},{1,5},{1,2},{1},{2}};
        List<String> output2 = sol.runTC(tcCmds2, tcArgs2);
        ListUtils.printStringList(output2);
    }
}