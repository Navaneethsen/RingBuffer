# Ring-Buffer

## Task 

Create a ring-buffer data structure in the language of your choice (see pictures below for a schematic representation). 
You should not spend much more than three hours on this task.

## Specifications

The Ring-Buffer will be instantiated for a certain type, e.g., string, int, or similar type. Instances of that type can be put into the buffer.
* The ring-buffer has a certain capacity.
* The ring-buffer has these main functions:

    * **Put**: adds a new element to the buffer. If the buffer is already full, the oldest element shall be overwritten.
    * **Get**: get and remove the oldest element. If the buffer is empty, an exception shall be raised.
    * **Size**: Gets the current size of the buffer (i.e., the actual number of elements contained in the buffer).
    * **Capacity**: Gets the capacity which was set when during the instantiation of the buffer.

## Examples
1. Fully filled ring-buffer with capacity of 4, 5 is the oldest element.
   ![](images/ex-1.png)

[comment]: <> (   <img src="https://github.com/Sensonic/navanese/images/ex-1.png" width="48">)
   
2. State of the ring-buffer after adding another element. The oldest element, 5, has been overwritten with the new element 9. 6 is now the oldest element
   ![](images/ex-2.png)

[comment]: <> (   <img src="https://github.com/Sensonic/navanese/images/ex-2.png" width="48">)
    
3. Ring-buffer after getting the head (i.e., the oldest) element. Get returns and removes the oldest element 6. The capacity stays the same (4), but the size decreases by 1.
   ![](images/ex-3.png)

[comment]: <> (   <img src="https://github.com/Sensonic/navanese/images/ex-3.png" width="48">)

## Technical Comments

Please choose to implement the ring-buffer by: 
* either using plain arrays or
* creating a dedicated data structure per element that you link together on your own.
Please do not use existing data structures like Queues, Dques, *Lists, …. as this would make the whole exercise obsolete.

## Developer Notes
I have tried to implement the ring-buffer by using plain arrays and linked lists.
* RingBuffer is a class that is implemented by using Plain arrays and two pointers
* RingBufferLL is a class that is implemented by using Circular Linked lists.

I have **not** noticed any significant difference in the performance of the buffers, but logic wise it was a bit more complicated to implement the ring-buffer by using plain arrays. The main complication was when we have the write pointer trying to crossover the read pointer.

Running times for the methods implemented by the buffer is shown in the below table:

| Method     | Running Time |
| ---      | ---       |
| put(e) | O(1)         |
| get()     | O(1)        |
| size() | O(1)         |
| capacity()     | O(1)       |

## License

This repository is released under the [MIT license](https://opensource.org/licenses/MIT). In short, this means you are free to use this software in any personal, open-source or commercial projects. Attribution is optional but appreciated.
