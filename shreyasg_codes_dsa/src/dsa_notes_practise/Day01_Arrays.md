# 📘 DSA Learning Notes — Day 1
**Learner:** Java Developer | **Goal:** Crack Coding Interviews  
**Date:** Session 1

---

## 🧠 What is an Algorithm?
An algorithm is a **step-by-step process** to solve a problem.

Your brain already thinks algorithmically — for example, when you look for the number `3` in `{1, 2, 3, 4, 5}`, you naturally check each element one by one. That's an algorithm!

---

## 📦 Arrays (Quick Recap)

```java
int[] arr = {1, 2, 3, 4, 5};
```

- Stores elements **sequentially** in memory
- Each element has an **index** (starting from 0)
- Fast to access by index: `arr[2]` → `3`

```
Index:  0   1   2   3   4
Value:  1   2   3   4   5
```

---

## 🔍 Algorithm 1: Linear Search

### What is it?
Check **each element one by one** until you find the target.

### When to use it?
- Array is **unsorted**
- You have **no prior knowledge** about the data

### Visual Trace
`arr = {1, 2, 3, 4, 5}`, `target = 3`

```
i=0 → arr[0]=1 → 1==3? ❌
i=1 → arr[1]=2 → 2==3? ❌
i=2 → arr[2]=3 → 3==3? ✅ → return 2
```

### Java Implementation

```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;       // found → return index
        }
    }
    return -1;              // not found → return -1
}
```

### Key Insight
- Returns **index** if found, **-1** if not found
- `return -1` must be **outside** the loop (common bug!)

### Efficiency
- Worst case: check **every** element
- 1 million elements → up to **1,000,000** checks 😬

---

## ⚡ Algorithm 2: Binary Search

### What is it?
Repeatedly **divide the search space in half** by comparing with the middle element.

### When to use it?
- Array **must be sorted** ✅
- You want to search **fast**

### The Core Idea
> If the middle element is less than the target → target is in the **right half**  
> If the middle element is greater than the target → target is in the **left half**  
> Eliminate the other half entirely each time!

### Visual Trace
`arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}`, `target = 7`

```
Step 1: left=0, right=9 → mid=4 → arr[4]=5 → 5<7 → go right → left=5
Step 2: left=5, right=9 → mid=7 → arr[7]=8 → 8>7 → go left  → right=6
Step 3: left=5, right=6 → mid=5 → arr[5]=6 → 6<7 → go right → left=6
Step 4: left=6, right=6 → mid=6 → arr[6]=7 → 7==7 ✅ → return 6
```

Found in **4 steps** instead of 7! 🚀

### Java Implementation

```java
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;             // found!
        } else if (arr[mid] < target) {
            left = mid + 1;         // go right half
        } else {
            right = mid - 1;        // go left half
        }
    }
    return -1;                      // not found
}
```

### Key Insights
- `mid = (left + right) / 2` — always find the middle
- `left = mid + 1` — skip mid (already checked), go right
- `right = mid - 1` — skip mid (already checked), go left
- Loop ends when `left > right` — search space exhausted

---

## 📊 Comparison: Linear vs Binary Search

| | Linear Search | Binary Search |
|---|---|---|
| Array needs sorting? | ❌ No | ✅ Yes |
| Max steps (10 elements) | 10 | 4 |
| Max steps (1M elements) | 1,000,000 | ~20 |
| Best for | Unsorted data | Sorted data |

---

## 🧮 Introduction to Time Complexity

> **Time Complexity** = how the number of steps grows as input size grows

| Algorithm | Time Complexity | Meaning |
|---|---|---|
| Linear Search | O(n) | Steps grow with array size |
| Binary Search | O(log n) | Steps grow very slowly |

### Analogy
- **O(n):** Reading a book page by page to find a word
- **O(log n):** Using the index at the back of the book

---

## 🐛 Common Bug to Remember

```java
// ❌ WRONG — return -1 inside loop
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
    return -1;  // exits after first element!
}

// ✅ CORRECT — return -1 outside loop
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
}
return -1;  // only reaches here if nothing found
```

---

## ✅ What You Learned Today

- [x] Arrays store data sequentially with index-based access
- [x] Linear Search — check every element, works on unsorted arrays
- [x] Binary Search — divide and conquer, requires sorted array
- [x] Why `return -1` belongs outside the loop
- [x] Basic intuition for Time Complexity (O(n) vs O(log n))

---

## 🔮 Coming Up Next
- Your first real interview problem using Linear & Binary Search
- Pattern recognition: how to identify which search to use
- Introduction to Two Pointers (builds directly on binary search logic)

---

*"The expert in anything was once a beginner." — Keep going! 💪*
