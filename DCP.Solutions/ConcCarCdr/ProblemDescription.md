# Problem #5: cons, car and crd (Medium)

## Asked By:

This problem was asked by Jane Street.

## Description:
 
`cons(a, b)` constructs a pair, and `car(pair)` and `cdr(pair)` returns the first and last element of that pair.

## Example:

For example, `car(cons(3, 4))` returns `3`, and `cdr(cons(3, 4))` returns `4`.  


## Note:

Given this implementation of cons:

```
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
 ```
Implement `car` and `cdr`.