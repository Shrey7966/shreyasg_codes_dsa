# 🚀 DSA Journey — Day 1: Search Algorithms
> **Learner:** Java Developer | **Goal:** Crack Coding Interviews | **Level:** Beginner → Pro

---

## 📚 Table of Contents
1. [What is an Array?](#what-is-an-array)
2. [Linear Search](#linear-search)
3. [Binary Search](#binary-search)
4. [Comparison: Linear vs Binary](#comparison)
5. [Time Complexity (Intro)](#time-complexity)
6. [Key Takeaways](#key-takeaways)

---

## 🧱 What is an Array?

An array is a **collection of elements stored in sequence**, each accessible by an index.

```
Index:  [0]  [1]  [2]  [3]  [4]
Value:   1    2    3    4    5
        ┌────┬────┬────┬────┬────┐
arr  →  │ 1  │ 2  │ 3  │ 4  │ 5  │
        └────┴────┴────┴────┴────┘
```

```java
int[] arr = {1, 2, 3, 4, 5};
```

> 💡 Think of it like a **row of numbered boxes** — each box holds a value, and each has an address (index) starting from **0**.

---

## 🔍 Linear Search

### 🧠 The Idea
> *"Look at each element one by one until you find what you're looking for."*

This is **exactly** how a human naturally searches — and it's your first algorithm!

### 📺 Visualization

**Searching for `3` in `{1, 2, 3, 4, 5}`:**

```
Step 1:  [1]  2    3    4    5
          ↑
         Check: 1 == 3? ❌ Nope, move on

Step 2:   1   [2]  3    4    5
               ↑
              Check: 2 == 3? ❌ Nope, move on

Step 3:   1    2   [3]  4    5
                    ↑
                   Check: 3 == 3? ✅ FOUND at index 2!
```

### ☕ Java Code

```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;       // ✅ Found! Return the index
        }
    }
    return -1;              // ❌ Not found
}
```

> ⚠️ **Common Bug:** `return -1` must be **outside** the loop.
> If it's inside, the loop exits on the very first mismatch — before checking everything!

### ✅ When to Use
| Situation | Use Linear Search? |
|---|---|
| Array is unsorted | ✅ Yes |
| Array is small | ✅ Yes |
| Need exact position | ✅ Yes |
| Array has 1 million elements | ⚠️ Slow but works |

---

## 🎯 Binary Search

### 🧠 The Idea
> *"If the array is sorted, start from the middle. If the target is bigger, ignore the left half. If smaller, ignore the right half. Repeat."*

Like finding a word in a dictionary — you don't start from page 1!

### 📺 Visualization

**Searching for `7` in `{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}`:**

```
Round 1:
┌─────────────────────────────────┐
│  1  2  3  4  5 [6] 7  8  9  10 │
│              mid=5 → value=6    │
│              6 < 7 → go RIGHT ➡ │
└─────────────────────────────────┘

Round 2:
┌─────────────────┐
│  7  8 [9] 9  10 │   ← Left half ignored ❌
│     mid=7 → value=8 │
│     8 > 7 → go LEFT ⬅ │
└─────────────────┘

Round 3:
┌────┐
│ [7] │   ← Right half ignored ❌
│  7 == 7 → ✅ FOUND at index 6! │
└────┘
```

### ☕ Java Code

```java
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;             // ✅ Found!
        } else if (arr[mid] < target) {
            left = mid + 1;        // 🔼 Go right (skip mid)
        } else {
            right = mid - 1;       // 🔽 Go left (skip mid)
        }
    }
    return -1;                     // ❌ Not found
}
```

### 🔑 Two Golden Rules of Binary Search
```
Rule 1: ✅ Array MUST be sorted
Rule 2: ✅ Always update left = mid+1 or right = mid-1
                              (never just mid — you'd check it again!)
```

### 📊 Step-by-Step Dry Run

`arr = {1,2,3,4,5,6,7,8,9,10}`, `target = 7`

| Step | left | right | mid | arr[mid] | Action |
|------|------|-------|-----|----------|--------|
| 1 | 0 | 9 | 4 | 5 | 5 < 7 → left = 5 |
| 2 | 5 | 9 | 7 | 8 | 8 > 7 → right = 6 |
| 3 | 5 | 6 | 5 | 6 | 6 < 7 → left = 6 |
| 4 | 6 | 6 | 6 | 7 | ✅ Found! Return 6 |

---

## ⚖️ Comparison

| Feature | Linear Search | Binary Search |
|---|---|---|
| Array must be sorted? | ❌ No | ✅ Yes |
| Checks per search (10 items) | Up to 10 | Up to 4 |
| Checks per search (1M items) | Up to 1,000,000 | Up to 20 |
| Best case | O(1) | O(1) |
| Worst case | O(n) | O(log n) |

> 🏠 **Real World Analogy:**
> - Linear Search = Knocking on every door in a city to find someone
> - Binary Search = Using a sorted phonebook — open to middle, eliminate half, repeat

---

## ⏱️ Time Complexity (Your First Taste)

**Time Complexity** = How the number of steps grows as input size grows.

```
Linear Search:
  10 elements   → up to 10 steps
  100 elements  → up to 100 steps
  1M elements   → up to 1,000,000 steps
  📈 Grows linearly → called O(n)

Binary Search:
  10 elements   → up to 4 steps
  100 elements  → up to 7 steps
  1M elements   → up to 20 steps
  📉 Grows slowly → called O(log n)
```

> 💡 In interviews, when someone asks *"Can you optimize this?"* — they're asking you to reduce time complexity. This is the heart of DSA!

---

## 🧠 Key Takeaways

```
✅ You wrote your first algorithm: Linear Search
✅ You figured out Binary Search intuitively (by thinking like a human!)
✅ You understand why sorted arrays unlock faster search
✅ You caught a common bug (return -1 inside loop)
✅ You got your first taste of Time Complexity
```

### 🔗 What's Coming Next
- **Two Pointer Technique** (builds on array indexing)
- **Sliding Window** (builds on loops)
- **Sorting Algorithms** (needed for Binary Search to work!)

---

## 🎯 Practice Problems (Try These!)

### Level 0 — Warm Up
- Search for a number in an array and return `true`/`false`
- Find the **first** occurrence of a number in an array

### Level 1 — Basic DSA
- Find the **last** occurrence of a number
- Count how many times a number appears

### Level 2 — Interview Style
- Search in a **rotated sorted array** (classic interview problem!)
- Find the square root of a number using binary search

> 🚀 **Next session:** We'll solve the rotated sorted array problem together — it's a favourite in FAANG interviews!

---

*📅 Day 1 Complete — Keep Going! The best programmers aren't the ones who know the most, they're the ones who think the clearest.* 💪
