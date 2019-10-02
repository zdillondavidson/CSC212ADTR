# P4: Testing ADTs

The learning objectives of this assignment are to understand how JUnit works and how to read and write basic tests before we start working on our own data structures.

***Due Date***: October 11, 2019.

Remember that we will have a midterm that weekend, so don't save it until the last minute!

# Rubric

### Rubric and Reflection (=15)

You must fill out a Google Form to indicate the parts of the assignment that you have attempted. 

In addition, you will write 10 statements of either:
 - Accomplishments: things that you understand much better now.
 - Challenges: things that you are still working on understanding.

I will provide direct feedback to your writing.

## Program Compiles; Tests Pass (=15)
This includes that your code should be professional. 
- Try to proofread your work like an essay! 
- Find all your ``println("stuff")`` statements and remove them, etc.
- Your code looks intentional: don't just fiddle with it until it works. Reason about it! Sketch out the python by hand and then try translating to Java.
- Delete commented out code or experiments that don't work out. Make your submission as small as it needs to be.
- Your code is your own. Respect the honor code.
- Working with others or helping them debug is acceptable - use your best judgment! Make sure that you know what you're working on.
- Have comments explaining tricky code!

## Test coverage (=60).

There are some intentional bugs in the MapADT implementing code and (likely) some accidental bugs. See if you can catch them.

### SetADT (=20)

- size
- insert
- contains
- remove
- toList*
- toJava*

### MapADT (=20)

- put
- get
- size
- remove
- getKeys*
- getEntries*
- toJava*


### ListADT (=20)

Make use of the structure I created for you in ``makeFullList``. The following methods need tests:

- setIndex
- addIndex
- removeBack
- removeIndex
- removeFront

Try to understand what's going on with the new errors: ``BadIndexError``, and ``EmptyListError`` in particular.

### Testing toList, toJava, getKeys, and getEntries

It is impossible to fully prove these transformations work for every collection. Since SetADT and MapADT do not specify an order, we would need the ability to sort their output in order to make equality work against collections. Instead of writing tricky tests for this, consider the following statements:

1. Converting collections should not change its size.
2. An empty collection should have an empty list (or list of keys, or list of entries).
3. A one-element collection 

## Coding Challenges (=10 + 10)

Writing code and tests for these methods (see ``Challenge.java``) is worth 10 points, and 10 if you have tests.

 - intersection
 - union
 - wordCount
 
 The challenge of the tests here is that you will need to devise a way to compute equality of MapADTs...
 
 Hint: here's SetADT:
 ```java
 boolean areSetsEqual(SetADT<Integer> lhs, SetADT<Integer> rhs) {
   if (lhs.size() != rhs.size()) { return false; }
   for (int item : lhs.toList()) {
     if (!rhs.contains(item)) { return false; }
   }
   return true;
 }
 ```

