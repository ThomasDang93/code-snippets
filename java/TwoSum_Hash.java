/*
This is a complete implementation of a Hash Table. The Solution class is just a 
code snippet that solves the TwoSum problem using my Hash Table classes.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMapper map = new HashMapper(nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int index = map.get(complement);
            if(index != -1 && index != i) {
                return new int[] { index, i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

class HashEntry {

      private int key;
      private int value;

      HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
      }     

      public int getKey() {
            return key;
      }

      public int getValue() {
            return value;
      }
}

class HashMapper {

      private int table_size;
      HashEntry[] table;

      /*Constructor that creates an array from given table size 
      and sets each hash entry in array to null*/
      HashMapper(int table_size) {
            this.table_size = table_size;
            table = new HashEntry[table_size];
            for (int i = 0; i < table_size; i++)
                  table[i] = null;
      }

      public int get(int key) {
          
            //Hash function that maps key to array index
            int hash = key % table_size;
          
            /*This makes sure that negative numbers from hash 
            function displays the correct modulus answer*/
            if (hash < 0) { 
                hash += table_size; 
            }
          
            //Linear probing used to resolve collisions in hash table
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % table_size;
            
            /*Determines the return value depending on whether or not 
            the hash entry has a value*/
            if (table[hash] == null)
                  return -1;
            else
                  return table[hash].getValue();
      }

      public void put(int key, int value) {
            int hash = key % table_size;
            if (hash < 0) { 
                hash += table_size; 
            }
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % table_size;
            
            //store key and value into a hash entry
            table[hash] = new HashEntry(key, value);
      }
}

