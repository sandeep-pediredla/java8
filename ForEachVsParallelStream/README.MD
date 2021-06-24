Weird issue encountered observed list.parallelStream() taking more time to loop through when compared to enhanced foreach.

Parallel stream time taken:**140**

Enhanced Foreach time taken:**91**

Normal For loop time taken:**88**

### 1. external vs. an internal iterator

``` java
List<Integer> list = Arrays.asList(1, 2, 3);
 
// Old school
for (Integer i : list)
    System.out.println(i);
 
// "Modern"
list.forEach(System.out::println);
```

 “modern” approach should be used with extreme care, i.e. only if you truly benefit from the internal, functional iteration (e.g. when chaining a set of operations via Stream’s map(), flatMap() and other operations).
 
 **Reason:**
Internal Iterator (clear overhead of additional fields )
When you pass a function object to a method to run over a list, that is an internal iterator

``` java
var.each( new Functor() {
  public void operate(Object arg) {
    arg *= 2;
  }
});
```

### 2. for-loop vs. an seq. stream

finding the max value in a list of boxed ints:
ArrayList, for-loop : **6.55 ms**
ArrayList, seq. stream: **8.33 ms**

int-array, for-loop : **0.36 ms**
int-array, seq. stream: **5.35 ms**

When performing relatively easy calculations on primitive data types, we absolutely SHOULD fall back to the classic for loop (and preferably to arrays, rather than collections).

### 3. Maintainability
From a maintenance perspective, a functional programming style can be much harder than imperative programming – especially when you blindly mix the two styles in legacy code.

Very good article explaining some part of the issue:
Reference:
https://blog.jooq.org/2015/12/08/3-reasons-why-you-shouldnt-replace-your-for-loops-by-stream-foreach/
https://jaxenter.com/java-8-problems-112279.html
https://dzone.com/articles/think-twice-using-java-8
