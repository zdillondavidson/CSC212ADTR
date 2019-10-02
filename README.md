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

## Test coverage (=56).

There are some intentional bugs in the MapADT implementing code and (likely) some accidental bugs. See if you can catch them.

### SetADT (=16)

- size
- insert
- contains
- remove


### MapADT (=16)

- put
- get
- size
- remove


### ListADT (=24)

Make use of the structure I created for you in ``makeFullList``. The following methods need tests:

- setIndex
- addIndex
- addToBack
- removeBack
- removeIndex
- removeFront

Try to understand what's going on with the new errors: ``BadIndexError``, and ``EmptyListError`` in particular.

### Testing (and completeness)

It is impossible to fully prove these some of these methods work for every collection. Consider how to find a balance between proving it works to yourself and making a lot of tedious code.

## Coding Challenges (=12 + 12)

Writing code and tests for these methods (see ``Challenge.java``) is worth 12 points, and 12 if you have tests.

 - intersection (4 + 4)
 - union (4 + 4)
 - wordCount (4 + 4)


## ADT-Reductions: Construct one data structure from another and test it. (=?)

- ListFromMap
- MapFromList
- SetFromMap
- SetFromList

 