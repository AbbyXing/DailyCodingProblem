# Problem #92: Sort Courses (Hard)

## Asked By:

This problem was asked by Airbnb.

## Description:
 
We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.  

Return null if there is no such ordering.

## Example:

For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].

## Note:
