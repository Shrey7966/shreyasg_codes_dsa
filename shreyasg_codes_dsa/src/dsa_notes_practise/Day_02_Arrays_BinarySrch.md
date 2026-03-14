# 🚀 DSA Journey — Day 2: First Real Interview Problems
> **Learner:** Java Developer | **Goal:** Crack Coding Interviews | **Level:** Beginner → Pro
> **Day 1 Recap:** Linear Search ✅ | Binary Search ✅ | Time Complexity Intro ✅

---

## 📚 Table of Contents
1. [What is a Rotated Sorted Array?](#what-is-a-rotated-sorted-array)
2. [Core Insight](#core-insight)
3. [Problem 1 & 2 — Warm Up Traces](#problem-1--2--warm-up-traces)
4. [Problem 3 — Search in Rotated Array](#problem-3--search-in-rotated-array)
5. [Problem 4 — Find Minimum / Rotation Point](#problem-4--find-minimum--rotation-point)
6. [Problem 5 — Search With Duplicates](#problem-5--search-with-duplicates)
7. [Quick Grasp Cheatsheet](#quick-grasp-cheatsheet)
8. [Key Takeaways](#key-takeaways)

---

## 🎡 What is a Rotated Sorted Array?

A sorted array that has been "spun" — some elements from the end wrap to the front.

```
Original:  {1, 2, 3, 4, 5, 6, 7}

❌ Reversed (NOT this):
           {7, 6, 5, 4, 3, 2, 1}

✅ Rotated by 3 steps (THIS):
           {5, 6, 7, 1, 2, 3, 4}
            \_____/   \_________/
            end part   start part
            moved up!
```

> 💡 Think of it like a **circular wheel** — spin it, and the end wraps to the front.

---

## 💡 Core Insight

> **In ANY rotated sorted array — ONE half is ALWAYS fully sorted!**

```
arr = {5, 6, 7, 1, 2, 3, 4}
       \_____/   \_________/
       sorted!     sorted!

✅ Use this to eliminate half the array each step!
```

**How to identify which half is sorted:**
```
if arr[left] <= arr[mid] → LEFT half is sorted
else                      → RIGHT half is sorted
```

---

## 🔍 Problem 1 & 2 — Warm Up Traces

### ⚡ Quick Grasp
```
These are pure dry-run problems.
Goal: Get comfortable tracing the algorithm manually.
Key skill: Identifying sorted half + checking if target is inside it.
```

---

### Problem 1 — Find `0` in `{4, 5, 6, 7, 0, 1, 2}`

```
arr = {4, 5, 6, 7, 0, 1, 2}
       [0] [1] [2] [3] [4] [5] [6]
```

| Step | left | right | mid | arr[mid] | Which sorted? | Target in? | Action |
|------|------|-------|-----|----------|---------------|------------|--------|
| 1 | 0 | 6 | 3 | 7 | arr[left]=4 <= arr[mid]=7 → LEFT | 0 >= 4? ❌ | left = mid+1 = 4 |
| 2 | 4 | 6 | 5 | 1 | arr[left]=0 <= arr[mid]=1 → LEFT | 0>=0 && 0<1? ✅ | right = mid-1 = 4 |
| 3 | 4 | 4 | 4 | 0 | arr[mid]==target ✅ | — | return 4 |

**Found at index 4 in 3 steps!** 🎯

---

### Problem 2 — Find `4` in `{3, 4, 5, 1, 2}`

```
arr = {3, 4, 5, 1, 2}
       [0] [1] [2] [3] [4]
```

| Step | left | right | mid | arr[mid] | Which sorted? | Target in? | Action |
|------|------|-------|-----|----------|---------------|------------|--------|
| 1 | 0 | 4 | 2 | 5 | arr[left]=3 <= arr[mid]=5 → LEFT | 4>=3 && 4<5? ✅ | right = mid-1 = 1 |
| 2 | 0 | 1 | 0 | 3 | arr[left]=3 <= arr[mid]=3 → LEFT | 4>=3 && 4<3? ❌ | left = mid+1 = 1 |
| 3 | 1 | 1 | 1 | 4 | arr[mid]==target ✅ | — | return 1 |

**Found at index 1 in 3 steps!** 🎯

> 💡 **Key lesson from Problem 2:**
> When `arr[left] == arr[mid]` (no duplicates), left half is still sorted!
> `left == right` with one element — that element IS the answer!

---

## 🎯 Problem 3 — Search in Rotated Sorted Array

### ⚡ Quick Grasp
```
Classic Binary Search but with a twist:
→ One half is always sorted
→ Check if target is INSIDE the sorted half
→ If YES → search there
→ If NO  → search other half

Asked by: Google, Amazon, Microsoft 🔥
LeetCode: #33
```

### Complete Logic
```
         Find mid
            ↓
    Which half is sorted?
    arr[left] <= arr[mid] → LEFT sorted
    else                  → RIGHT sorted
            ↓
    Is target inside sorted half?
    LEFT:  target >= arr[left] && target < arr[mid]
    RIGHT: target > arr[mid]  && target <= arr[right]
            ↓
    YES → search that half
    NO  → search other half
```

### ☕ Java Code
```java
public static int searchRotated(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;  // ✅ Found!

        if (arr[left] <= arr[mid]) {
            // Left half is sorted
            if (target >= arr[left] && target < arr[mid]) {
                right = mid - 1;    // target in left → go left
            } else {
                left = mid + 1;     // target not in left → go right
            }
        } else {
            // Right half is sorted
            if (target > arr[mid] && target <= arr[right]) {
                left = mid + 1;     // target in right → go right
            } else {
                right = mid - 1;    // target not in right → go left
            }
        }
    }
    return -1; // ❌ Not found
}
```

### 🔑 Why `<` and `<=` matter
```
LEFT check:  target >= arr[left] && target < arr[mid]
                                             ↑
                                       strict < because
                                       arr[mid] already checked!

RIGHT check: target > arr[mid] && target <= arr[right]
                                             ↑
                                       include arr[right]
                                       it could be the target!
```

---

## 🔄 Problem 4 — Find Minimum / Rotation Point

### ⚡ Quick Grasp
```
These 3 questions are THE SAME PROBLEM:
→ "Find minimum element"
→ "Find rotation point"
→ "How many times was array rotated?"

All lead to the same index — where the DROP happens!

Key trick: Compare arr[mid] with arr[right]
→ arr[mid] > arr[right] → drop is in RIGHT half → left = mid+1
→ arr[mid] < arr[right] → drop is in LEFT half  → right = mid
→ Stop when left == right → that's your answer!
```

### Where is the Drop?
```
arr = {5, 6, 7, 1, 2, 3, 4}
               ↑  ↑
               7  1  ← DROP here!

The minimum element is always at the DROP point!
arr[i] > arr[i+1] → i+1 is the rotation point!
```

### Why `arr[mid]` vs `arr[right]`?
```
arr[mid] > arr[right] → drop is between mid and right
                      → mid is too BIG to be minimum
                      → safely skip → left = mid+1

arr[mid] < arr[right] → no drop between mid and right
                      → mid COULD be minimum
                      → keep it → right = mid
```

### ☕ Java Code
```java
public static int findMinimum(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {          // ⚠️ left < right (not <=)
        int mid = (left + right) / 2;

        if (arr[mid] > arr[right]) {
            left = mid + 1;         // drop in right half
        } else {
            right = mid;            // drop in left half or mid
        }
    }
    return arr[left];               // left == right → minimum!
}
```

### ⚠️ Critical Difference
```
Regular Binary Search    → while(left <= right)
Find Minimum             → while(left < right)

Why? Because right = mid (not mid-1)
If left==right and we do right=mid → INFINITE LOOP! 😱
So we stop BEFORE left==right with left < right
```

### 🎬 Dry Run
`arr = {5, 6, 7, 1, 2, 3, 4}`

| Step | left | right | mid | arr[mid] | arr[right] | Condition | Action |
|------|------|-------|-----|----------|------------|-----------|--------|
| 1 | 0 | 6 | 3 | 1 | 4 | 1 < 4 | right = mid = 3 |
| 2 | 0 | 3 | 1 | 6 | 1 | 6 > 1 | left = mid+1 = 2 |
| 3 | 2 | 3 | 2 | 7 | 1 | 7 > 1 | left = mid+1 = 3 |
| 4 | 3 | 3 | — | — | — | left==right 🛑 | return arr[3]=1 |

**Minimum = 1 at index 3!** 🎯

---

## 🔀 Problem 5 — Search With Duplicates

### ⚡ Quick Grasp
```
Same as Problem 3 BUT with duplicates.
Duplicates break our "which half is sorted" rule!

When arr[left] == arr[mid] == arr[right]
→ We genuinely can't tell which half is sorted
→ Just shrink both sides by 1 and try again!

This is LeetCode #81 — a Hard pattern! 🔥

Worst case with duplicates → O(n) instead of O(log n)
Because we might shrink by just 1 each step.
```

### The Problem With Duplicates
```
arr = {1, 0, 1, 1, 1}
       ↑        ↑
    arr[left]=1  arr[mid]=1

arr[left] <= arr[mid] → "left sorted"?
But left half = {1, 0, 1} → NOT actually sorted! 😱

Duplicates fool our rule → we need to handle this!
```

### The Fix
```
When arr[left] == arr[mid] == arr[right]:
→ Can't decide which half is sorted
→ Just shrink both pointers by 1
→ left = left + 1
→ right = right - 1
```

### ☕ Complete Java Code
```java
public static boolean searchWithDuplicates(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) return true;  // ✅ Found!

        // Handle duplicates first!
        if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
            left = left + 1;    // shrink left
            right = right - 1;  // shrink right
        }
        // Left half sorted
        else if (arr[left] <= arr[mid]) {
            if (arr[left] <= target && target < arr[mid]) {
                right = mid - 1;   // search left
            } else {
                left = mid + 1;    // search right
            }
        }
        // Right half sorted
        else {
            if (target > arr[mid] && target >= arr[right]) {  // ⚠️ >= not >
                left = mid + 1;    // search right
            } else {
                right = mid - 1;   // search left
            }
        }
    }
    return false;
}
```

### 🎬 Dry Run
`arr = {1, 0, 1, 1, 1}`, `target = 0`

| Step | left | right | mid | arr[mid] | Condition | Action |
|------|------|-------|-----|----------|-----------|--------|
| 1 | 0 | 4 | 2 | 1 | arr[left]==arr[mid]==arr[right]=1 | left=1, right=3 |
| 2 | 1 | 3 | 2 | 1 | arr[left]=0 <= arr[mid]=1 → LEFT sorted | 0>=0 && 0<1 ✅ → right=1 |
| 3 | 1 | 1 | 1 | 0 | arr[mid]==target ✅ | return true |

**Found in 3 steps!** 🚀

---

## ⚡ Quick Grasp Cheatsheet

```
┌─────────────────────────────────────────────────────────────┐
│                    PATTERN RECOGNITION                       │
├─────────────────────────────────────────────────────────────┤
│ "Search in sorted array"          → Binary Search           │
│ "Search in rotated array"         → Modified Binary Search  │
│ "Find minimum in rotated array"   → Compare mid vs right    │
│ "Find rotation point"             → Same as find minimum!   │
│ "Search with duplicates"          → Handle equal case first │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                    KEY RULES                                 │
├─────────────────────────────────────────────────────────────┤
│ arr[left] <= arr[mid]  → LEFT half sorted                   │
│ arr[left] >  arr[mid]  → RIGHT half sorted                  │
│                                                             │
│ arr[mid] > arr[right]  → drop in RIGHT → left = mid+1      │
│ arr[mid] < arr[right]  → drop in LEFT  → right = mid       │
│                                                             │
│ arr[left]==arr[mid]==arr[right] → shrink both sides         │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                    WHILE CONDITIONS                          │
├─────────────────────────────────────────────────────────────┤
│ Searching for target   → while(left <= right)               │
│ Finding minimum        → while(left < right)                │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                    COMMON BUGS                              │
├─────────────────────────────────────────────────────────────┤
│ return -1 inside loop     → exits too early!                │
│ left = mid (not mid+1)    → infinite loop!                  │
│ right = mid-1 in find min → skips the answer!               │
│ > instead of >= on right  → misses arr[right] as target!    │
└─────────────────────────────────────────────────────────────┘
```

---

## 🧠 How Problems Connect

```
Normal Binary Search
        ↓ add rotation handling
Search in Rotated Array (LC #33)
        ↓ find the drop point
Find Minimum / Rotation Point (LC #153)
        ↓ add duplicate handling
Search With Duplicates (LC #81) 🔥
```

> 💡 Each problem is just the previous one with **one more rule added!**
> Master the base, and the rest follow naturally!

---

## 🏆 Problems Solved Today

```
✅ Problem 1 - Find 0 in {4,5,6,7,0,1,2}     → Level 0
✅ Problem 2 - Find 4 in {3,4,5,1,2}          → Level 0
✅ Problem 3 - Search in Rotated Array         → Level 1 (LC #33) 🔥
✅ Problem 4 - Find Minimum / Rotation Point   → Level 2 (LC #153) 🔥
✅ Problem 5 - Search With Duplicates          → Level 2 (LC #81) 🔥
```

---

## 🎯 Remaining Practice Problems

### Try These on Your Own!
- 🔗 LeetCode #33  — Search in Rotated Sorted Array
- 🔗 LeetCode #153 — Find Minimum in Rotated Sorted Array
- 🔗 LeetCode #81  — Search in Rotated Sorted Array II
- Find **how many times** the array was rotated
  *(Hint: rotation count = index of minimum element!)*

---

## 📅 What's Coming on Day 3

```
Day 3 Topics:
├── Two Pointer Technique 👈 your next core weapon
│   ├── What it is & when to use it
│   ├── Pair Sum problem
│   ├── Remove duplicates
│   └── Container with most water (classic interview!)
└── Day 3 Notes (.md)
```

> 🚀 Two Pointers will feel like a **superpower** once you get it.
> It's used in 30%+ of all array interview questions!

---

*📅 Day 2 Complete — You just solved 3 LeetCode problems including a Hard pattern. That's not beginner stuff anymore. Keep going!* 🔥
