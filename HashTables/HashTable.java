class HashTable 
{
   // hash table size
   int hashTableSize = 37;   

   // array to store items
   String [] hashTableArray;
   // for counting the number of additional comparisons due to collisions
   int collisions;
   
   // constructor
   public HashTable () 
   {
      hashTableArray = new String [hashTableSize];
      for ( int i=0; i<hashTableSize; i++ )
         hashTableArray[i] = "";
      collisions = 0;
   }
   
   // return number of additional collision comparisons
   public int getCollisions ()
   { return collisions; }
   
   // hash function based on external weights
   public int hash (String s, int[] weights)
   {
      //HashTableFunctions htf = new HashTableFunctions ();
      //int[] weights = htf.weights;
      /*for(int i =0; i < 9; i++){
         System.out.println(weights[i]);
      }
      */
      int val = 0;
      for ( int i=0; i<9; i++ )
         val += weights[i] * s.charAt (i);
      return val % hashTableSize;   
   }   
   
   // inserts string s into the hash table
   public void insert ( String s, int[] weights )
   {
      HashTableFunctions htf = new HashTableFunctions ();
      //int[] weights = htf.weights;
      int h = hash (s, weights);
      while (! hashTableArray[h].equals (""))
      {
         h = (h+1) % hashTableSize;
         collisions++;
      }
      hashTableArray[h] = s;
   }
   
   // stub to point to external function
   boolean find ( String s )
   {
      HashTableFunctions htf = new HashTableFunctions ();
      return htf.find (s, hash (s, htf.weights), hashTableSize, hashTableArray);
   }
}
