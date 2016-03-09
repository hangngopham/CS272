// File: DoubleLinkedSeq.java from the package edu.colorado.collections

// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.collections:
package linkedlist;

/******************************************************************************
* This class is a homework assignment;
* A <CODE>DoubleLinkedSeq</CODE> is a collection of <CODE>double</CODE> numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the sequence class 
* (start, getCurrent, advance and isCurrent).
*
* <b>Limitations:</b>
*   Beyond <CODE>Int.MAX_VALUE</CODE> elements, the <CODE>size</CODE> method
*   does not work.
*
* <b>Note:</b>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version Feb 10, 2016
******************************************************************************/
public class DoubleLinkedSeq implements Cloneable
{

    private DoubleNode head;
    private int manyNodes;
    
   /**
   * Initialize an empty sequence.
   * <b>Postcondition:</b>
   *   This sequence is empty.
   **/   
   public DoubleLinkedSeq( )
   {
	   head = null;
	   manyNodes = 0;
   }
    
 
   /**
   * Add a new element to this sequence, after the current element. 
   * @param element
   *   the new element that is being added
   * <b>Postcondition:</b>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(int element)
   {
      head = new DoubleNode(element, head);
      manyNodes++;
   }


   /**
   * Add a new element to this sequence, before the current element. 
   * @param element
   *   the new element that is being added
   * <b>Postcondition:</b>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(int element)
   {
      // Implemented by student.
   }
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend
   *   a sequence whose contents will be placed at the end of this sequence
   * <b>Precondition:</b>
   *   The parameter, <CODE>addend</CODE>, is not null. 
   * <b>Postcondition:</b>
   *   The elements from <CODE>addend</CODE> have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the <CODE>addend</CODE> is also unchanged.
   * @exception NullPointerException
   *   Indicates that <CODE>addend</CODE> is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   **/
   public void addAll(DoubleLinkedSeq addend)
   {
      // Implemented by student.
   }   
   
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * <b>Precondition:</b>
   *   <CODE>isCurrent()</CODE> returns true. 
   * <b>Postcondition:</b>
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   <CODE>advance</CODE> may not be called.
   **/
   public void advance( )
   {
      // Implemented by student.
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to a <CODE>DoubleLinkedSeq</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public Object clone( )
   {  // Clone a DoubleLinkedSeq object.
      // Student will replace this return statement with their own code:
      return null;
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1
   *   the first of two sequences
   * @param s2
   *   the second of two sequences
   * <b>Precondition:</b>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of <CODE>s1</CODE> followed by the
   *   elements of <CODE>s2</CODE> (with no current element)
   * @exception NullPointerException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/   
   public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
   {
      // Student will replace this return statement with their own code:
      return null;
   }


   /**
   * Accessor method to get the current element of this sequence. 
   * <b>Precondition:</b>
   *   <CODE>isCurrent()</CODE> returns true.
   * @return
   *   the current capacity of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   <CODE>getCurrent</CODE> may not be called.
   **/
   public double getCurrent( )
   {
      // Student will replace this return statement with their own code:
      return 0;
   }


   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * <CODE>getCurrent</CODE> method. 
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public double isCurrent( )
   {
      // Student will replace this return statement with their own code:
      return 0;
   }
              
   /**
   * Remove the current element from this sequence.
   * <b>Precondition:</b>
   *   <CODE>isCurrent()</CODE> returns true.
   * <b>Postcondition:</b>
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   <CODE>removeCurrent</CODE> may not be called. 
   **/
   public void removeCurrent( )
   {
      // Implemented by student.
   }
                 
   
   /**
   * Determine the number of elements in this sequence.
   * @return
   *   the number of elements in this sequence
   **/ 
   public int size( )
   {
      return manyNodes;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * <b>Postcondition:</b>
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( )
   {
      
   }
}
           
