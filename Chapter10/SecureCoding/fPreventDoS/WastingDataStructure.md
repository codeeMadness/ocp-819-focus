<h4>HashMap distribution</h4> 
using a HashMap is that you can look up an element quickly by key

=> as long as there is a **good distribution** of hashed keys

if **hashCode()** always returns 42 and puts a million of them in your map. Not so fast anymore.


<h4>Large Array size</h4>
write a method that lets you set the size of an array

=> repeatedly **pick a really large array size** and quickly exhaust the program's memory