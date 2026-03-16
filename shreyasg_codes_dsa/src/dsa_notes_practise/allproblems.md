# DSA Journey — All Problems Solved (Day 1 to Day 3)
> Learner: Java Developer | Goal: Crack Coding Interviews
> Progress: 3 Days | 8 Problems | 6 LeetCode Problems Covered

---

## Table of Contents

| Day | Topic | Problems |
|-----|-------|---------|
| [Day 1](#day-1--search-algorithms) | Search Algorithms | Linear Search, Binary Search |
| [Day 2](#day-2--rotated-array-problems) | Rotated Array | Search Rotated, Find Minimum, Search with Duplicates |
| [Day 3](#day-3--two-pointer-technique) | Two Pointer | Pair Sum, Remove Duplicates, Container With Most Water |
| [Master Cheatsheet](#master-cheatsheet) | All Patterns | Quick Reference |

---

# Day 1 — Search Algorithms

---

## Problem 1 — Linear Search

### Quick Grasp
```
Simplest search algorithm.
Check each element ONE BY ONE until target found.
No sorting needed — works on any array!

When to use:
- Array is unsorted
- Small arrays
- Need to find first occurrence
```

### Visualization
```
arr = {1, 2, 3, 4, 5}, target = 3

Step 1: [1] 2  3  4  5  → 1==3? No
Step 2:  1 [2] 3  4  5  → 2==3? No
Step 3:  1  2 [3] 4  5  → 3==3? Yes → Found at index 2
```

### Java Code
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;       // Found! Return index
        }
    }
    return -1;              // Not found
}
```

### Common Bug
```java
// WRONG — return -1 inside loop exits too early!
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
    return -1;  // exits on first mismatch!
}

// CORRECT — return -1 outside loop
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
}
return -1;  // only reached if nothing found
```

### Complexity
```
Time:  O(n) — checks every element in worst case
Space: O(1) — no extra memory needed
```

---

## Problem 2 — Binary Search

### Quick Grasp
```
Fast search on SORTED arrays.
Eliminate HALF the array each step.

Two Golden Rules:
1. Array MUST be sorted
2. Always update left = mid+1 or right = mid-1
   (never just mid — you would check it again!)

Like finding a word in a dictionary —
open to middle, eliminate half, repeat.
```

### Visualization
```
arr = {1,2,3,4,5,6,7,8,9,10}, target = 7

Round 1: left=0, right=9, mid=4 → arr[4]=5
         5 < 7 → ignore left half
         {7, 8, 9, 10} remain

Round 2: left=5, right=9, mid=7 → arr[7]=8
         8 > 7 → ignore right half
         {6, 7} remain

Round 3: left=5, right=6, mid=5 → arr[5]=6
         6 < 7 → left=6

Round 4: left=6, right=6, mid=6 → arr[6]=7 → Found!
```

### Dry Run Table
`arr = {1,2,3,4,5,6,7,8,9,10}`, `target = 7`

| Step | left | right | mid | arr[mid] | Action |
|------|------|-------|-----|----------|--------|
| 1 | 0 | 9 | 4 | 5 | 5 < 7 → left=5 |
| 2 | 5 | 9 | 7 | 8 | 8 > 7 → right=6 |
| 3 | 5 | 6 | 5 | 6 | 6 < 7 → left=6 |
| 4 | 6 | 6 | 6 | 7 | Found → return 6 |

### Java Code
```java
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;        // go right, skip mid
        } else {
            right = mid - 1;       // go left, skip mid
        }
    }
    return -1;
}
```

### Complexity
```
Time:  O(log n) — eliminates half each step
Space: O(1)

Linear vs Binary:
  10 elements  → Linear: 10 steps  | Binary: 4 steps
  1M elements  → Linear: 1,000,000 | Binary: 20 steps
```

---

## Day 1 — Practice Problems

### Level 0 — Warm Up
1. Search for a number in an array and return true/false
2. Find the first occurrence of a number in an array
3. Find the last occurrence of a number in an array
4. Count how many times a number appears in an array

### Level 1 — Basic
5. Binary search on array: return index or -1
6. Find if a number exists in a sorted array (use binary search)
7. Find the insertion position of a target in a sorted array

### Level 2 — Interview Style
8. Search in a nearly sorted array (element may be at i-1, i, or i+1)
9. Find the square root of a number using binary search (return floor value)
10. Find the first and last position of a target in sorted array

### LeetCode
- LC #704 — Binary Search
- LC #35  — Search Insert Position
- LC #34  — Find First and Last Position of Element in Sorted Array

---

# Day 2 — Rotated Array Problems

> Core Insight for ALL Day 2 problems:
> In a rotated sorted array, ONE half is ALWAYS fully sorted.

```
arr = {5, 6, 7, 1, 2, 3, 4}
       \_____/   \_________/
       sorted      sorted

Identify which half:
arr[left] <= arr[mid] → LEFT half sorted
arr[left] >  arr[mid] → RIGHT half sorted
```

---

## Problem 3 — Search in Rotated Sorted Array
> LeetCode #33 | Asked by Google, Amazon, Microsoft

### Quick Grasp
```
Binary Search but array is rotated.

Strategy:
1. Find mid
2. Which half is sorted? (compare arr[left] vs arr[mid])
3. Is target INSIDE the sorted half?
4. Yes → search there | No → search other half

Still O(log n) because we eliminate half each step.
```

### Visualization
```
arr = {5, 6, 7, 1, 2, 3, 4}, target = 6

       sorted      sorted
      {5,6,7}    {1,2,3,4}
          |
         mid = arr[3] = 1

arr[left]=5 > arr[mid]=1 → RIGHT half sorted
Is 6 in right half {1,2,3,4}? No
→ Search LEFT half → Found 6
```

### Dry Run Table
`arr = {5,6,7,1,2,3,4}`, `target = 6`

| Step | left | right | mid | arr[mid] | Which sorted? | Target in? | Action |
|------|------|-------|-----|----------|---------------|------------|--------|
| 1 | 0 | 6 | 3 | 1 | arr[left]=5 > arr[mid]=1 → RIGHT | 6 <= arr[right]=4? No | right=mid-1=2 |
| 2 | 0 | 2 | 1 | 6 | arr[mid] == target | — | return 1 |

### Java Code
```java
public static int searchRotated(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;

        if (arr[left] <= arr[mid]) {
            // Left half sorted
            if (target >= arr[left] && target < arr[mid]) {
                right = mid - 1;    // target in left half
            } else {
                left = mid + 1;     // target in right half
            }
        } else {
            // Right half sorted
            if (target > arr[mid] && target <= arr[right]) {
                left = mid + 1;     // target in right half
            } else {
                right = mid - 1;    // target in left half
            }
        }
    }
    return -1;
}
```

---

## Problem 4 — Find Minimum / Rotation Point
> LeetCode #153

### Quick Grasp
```
These 3 questions are THE SAME PROBLEM:
- "Find minimum element"
- "Find rotation point"
- "How many times was array rotated?"

All lead to the same index — where the DROP happens.

Key trick: Compare arr[mid] with arr[right]
- arr[mid] > arr[right] → drop in RIGHT half → left = mid+1
- arr[mid] < arr[right] → drop in LEFT half  → right = mid

Stop when left == right → that is the answer.

Use while(left < right) NOT while(left <= right)
```

### Visualization
```
arr = {5, 6, 7, 1, 2, 3, 4}
               |  |
               7  1  ← DROP here! Minimum is always at drop point.

arr[mid]=7 > arr[right]=4 → drop is between mid and right
→ left = mid+1
```

### Dry Run Table
`arr = {5,6,7,1,2,3,4}`

| Step | left | right | mid | arr[mid] | arr[right] | Action |
|------|------|-------|-----|----------|------------|--------|
| 1 | 0 | 6 | 3 | 1 | 4 | 1 < 4 → right=3 |
| 2 | 0 | 3 | 1 | 6 | 1 | 6 > 1 → left=2 |
| 3 | 2 | 3 | 2 | 7 | 1 | 7 > 1 → left=3 |
| 4 | 3 | 3 | — | — | — | left==right → return arr[3]=1 |

### Java Code
```java
public static int findMinimum(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {          // strict < not <=
        int mid = (left + right) / 2;

        if (arr[mid] > arr[right]) {
            left = mid + 1;         // drop in right half
        } else {
            right = mid;            // drop in left half or IS mid
        }
    }
    return arr[left];               // left == right → minimum
}
```

### Critical Rule
```
arr[mid] > arr[right] → mid is too big to be minimum → skip it → left = mid+1
arr[mid] < arr[right] → mid could be minimum → keep it  → right = mid

Why while(left < right)?
If left==right and we do right=mid → INFINITE LOOP
So we stop before left==right.
```

---

## Problem 5 — Search With Duplicates
> LeetCode #81

### Quick Grasp
```
Same as Problem 3 BUT with duplicates.

Problem: arr[left] == arr[mid] == arr[right]
→ Cannot tell which half is sorted
→ Our rule breaks down

Fix: When all three equal → shrink both sides
     left++, right--
     Then try again with smaller window

Worst case with duplicates → O(n) not O(log n)
Because we might shrink by 1 each step.
```

### Visualization
```
arr = {1, 0, 1, 1, 1}
       |        |
    arr[left]=1  arr[mid]=1

arr[left] == arr[mid] == arr[right] = 1
→ Cannot decide which half is sorted
→ left++, right--
→ Window is smaller, try again
```

### Dry Run Table
`arr = {1,0,1,1,1}`, `target = 0`

| Step | left | right | mid | arr[mid] | Condition | Action |
|------|------|-------|-----|----------|-----------|--------|
| 1 | 0 | 4 | 2 | 1 | arr[left]==arr[mid]==arr[right]=1 | left=1, right=3 |
| 2 | 1 | 3 | 2 | 1 | arr[left]=0 <= arr[mid]=1 → LEFT sorted | 0>=0 && 0<1 → right=1 |
| 3 | 1 | 1 | 1 | 0 | arr[mid]==target | return true |

### Java Code
```java
public static boolean searchWithDuplicates(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (arr[mid] == target) return true;

        // Handle duplicates first
        if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
            left++;
            right--;
        }
        // Left half sorted
        else if (arr[left] <= arr[mid]) {
            if (arr[left] <= target && target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // Right half sorted
        else {
            if (target > arr[mid] && target >= arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return false;
}
```

---

## Day 2 — Practice Problems

### Level 0 — Warm Up (Manual Trace)
1. Trace the algorithm manually: find `0` in `{4, 5, 6, 7, 0, 1, 2}`
2. Trace the algorithm manually: find `4` in `{3, 4, 5, 1, 2}`

### Level 1 — Basic
3. Search in rotated sorted array — return index or -1
4. Find the rotation point (index where array was rotated)

### Level 2 — Interview Style
5. Find minimum element in rotated sorted array
6. Search in rotated array with duplicate elements

### Level 3 — LeetCode
- LC #33  — Search in Rotated Sorted Array
- LC #153 — Find Minimum in Rotated Sorted Array
- LC #81  — Search in Rotated Sorted Array II (with duplicates)

### Bonus
- Given a rotated array, find how many times it was rotated
  (Hint: rotation count = index of minimum element)

---

# Day 3 — Two Pointer Technique

> Core Insight:
> Instead of checking every combination O(n squared),
> use two pointers and move smartly — O(n).

```
Pattern 1: Pointers move TOWARD each other  (left ->, <- right)
Pattern 2: Pointers move in SAME direction  (slow ->, fast ->)
```

---

## Problem 6 — Pair Sum

### Quick Grasp
```
Find all pairs in a SORTED array that add up to target.

Key insight: Array is sorted.
- Moving left pointer right  → increases sum
- Moving right pointer left  → decreases sum
- Use this to home in on target

Pattern: Pointers move toward each other
```

### Visualization
```
arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}, target = 10

Step 1: [1]  2   3   4   5   6   7   8  [9]  → 1+9=10 Found
Step 2:  1  [2]  3   4   5   6   7  [8]  9   → 2+8=10 Found
Step 3:  1   2  [3]  4   5   6  [7]  8   9   → 3+7=10 Found
Step 4:  1   2   3  [4]  5  [6]  7   8   9   → 4+6=10 Found
Step 5:  1   2   3   4  [5]  5   6   7   9   → left==right, stop
```

### Dry Run Table
`arr = {1,2,3,4,5,6,7,8,9}`, `target = 10`

| Step | left | right | arr[left] | arr[right] | sum | Action |
|------|------|-------|-----------|------------|-----|--------|
| 1 | 0 | 8 | 1 | 9 | 10 | Found, left++, right-- |
| 2 | 1 | 7 | 2 | 8 | 10 | Found, left++, right-- |
| 3 | 2 | 6 | 3 | 7 | 10 | Found, left++, right-- |
| 4 | 3 | 5 | 4 | 6 | 10 | Found, left++, right-- |
| 5 | 4 | 4 | — | — | — | left==right, stop |

### Java Code
```java
public static void findPairs(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
            System.out.println(arr[left] + ", " + arr[right]);
            left++;
            right--;
        } else if (sum < target) {
            left++;      // need bigger sum
        } else {
            right--;     // need smaller sum
        }
    }
}
```

### Why `left < right` not `left <= right`?
```
left == right → same element used twice → not a valid pair
Stop before they meet → while(left < right)
```

---

## Problem 7 — Remove Duplicates

### Quick Grasp
```
Remove duplicates from a SORTED array IN PLACE.
No new array needed — O(1) space.

slow = "builder"  → tracks last unique element placed
fast = "explorer" → scans ahead for new unique elements

Pattern: Both pointers move in same direction
```

### Visualization
```
arr = {1, 1, 2, 2, 3, 4, 4, 5}

slow=0  fast=1  → 1==1 duplicate → fast++
slow=0  fast=2  → 1!=2 unique    → slow++, arr[1]=2, fast++
slow=1  fast=3  → 2==2 duplicate → fast++
slow=1  fast=4  → 2!=3 unique    → slow++, arr[2]=3, fast++
slow=2  fast=5  → 3!=4 unique    → slow++, arr[3]=4, fast++
slow=3  fast=6  → 4==4 duplicate → fast++
slow=3  fast=7  → 4!=5 unique    → slow++, arr[4]=5, fast++
slow=4  fast=8  → end

Result: arr[0 to slow] = {1, 2, 3, 4, 5}
```

### Dry Run Table
`arr = {1,1,2,2,3,4,4,5}`

| Step | slow | fast | arr[slow] | arr[fast] | Action |
|------|------|------|-----------|-----------|--------|
| 1 | 0 | 1 | 1 | 1 | duplicate → fast++ |
| 2 | 0 | 2 | 1 | 2 | unique → slow++, arr[1]=2, fast++ |
| 3 | 1 | 3 | 2 | 2 | duplicate → fast++ |
| 4 | 1 | 4 | 2 | 3 | unique → slow++, arr[2]=3, fast++ |
| 5 | 2 | 5 | 3 | 4 | unique → slow++, arr[3]=4, fast++ |
| 6 | 3 | 6 | 4 | 4 | duplicate → fast++ |
| 7 | 3 | 7 | 4 | 5 | unique → slow++, arr[4]=5, fast++ |
| 8 | 4 | 8 | — | — | fast == length, stop |

### Java Code
```java
public static int removeDuplicates(int[] arr) {
    int slow = 0;
    int fast = 1;

    while (fast < arr.length) {
        if (arr[slow] == arr[fast]) {
            fast++;                    // duplicate → skip
        } else {
            slow++;                    // move slow forward
            arr[slow] = arr[fast];    // place unique element
            fast++;                    // move fast forward
        }
    }
    return slow + 1;                  // unique count
}
```

### Shorthand Version (Optional)
```java
// These 3 lines:
slow++;
arr[slow] = arr[fast];
fast++;

// Can be written as one line:
arr[++slow] = arr[fast++];

// ++slow → increment slow FIRST, then use it
// fast++ → use fast FIRST, then increment it
```

### Complexity
```
Time:  O(n) — fast pointer visits each element once
Space: O(1) — modified in place, no new array
```

---

## Problem 8 — Container With Most Water
> LeetCode #11 | Classic FAANG Interview Problem

### Quick Grasp
```
Find two walls that hold the MOST water.

Formula: water = min(height[left], height[right]) x (right - left)
                      shorter wall limits height     width between walls

Key Rule: ALWAYS move the SHORTER wall inward.
- Moving taller wall  → width decreases, height same or worse → pointless
- Moving shorter wall → width decreases BUT height might increase → chance

Pattern: Pointers move toward each other
```

### Visualization
```
height = {1, 8, 6, 2, 5, 4, 8, 3, 7}

    8           8
    |     5  4  |     7
    |  6  |  |  |  3  |
 1  |  |  |2 |  |  |  |
[0][1][2][3][4][5][6][7][8]

Best container: walls at index 1 (h=8) and index 8 (h=7)
Water = min(8,7) x (8-1) = 7 x 7 = 49
```

### Dry Run Table
`height = {1,8,6,2,5,4,8,3,7}`

| Step | left | right | h[l] | h[r] | Water | maxWater | Move |
|------|------|-------|------|------|-------|----------|------|
| 1 | 0 | 8 | 1 | 7 | 8 | 8 | left++ |
| 2 | 1 | 8 | 8 | 7 | 49 | 49 | right-- |
| 3 | 1 | 7 | 8 | 3 | 18 | 49 | right-- |
| 4 | 1 | 6 | 8 | 8 | 40 | 49 | right-- |
| 5 | 2 | 5 | 6 | 4 | 12 | 49 | right-- |
| 6 | 2 | 4 | 6 | 5 | 10 | 49 | right-- |
| 7 | 2 | 3 | 6 | 2 | 2 | 49 | right-- |
| 8 | 2 | 2 | — | — | — | — | left==right, stop |

**Maximum Water = 49**

### Java Code
```java
public static int maxWater(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxWater = 0;

    while (left < right) {
        int water = Math.min(height[left], height[right])
                    * (right - left);
        maxWater = Math.max(maxWater, water);

        if (height[left] < height[right]) {
            left++;     // left is shorter, move it
        } else {
            right--;    // right is shorter OR equal, move it
        }
    }
    return maxWater;
}
```

### Equal Height Case
```java
} else {
    right--;  // handles both height[left] > height[right]
              // AND height[left] == height[right]
}

// When equal → moving either pointer gives same water value
// So letting else handle it with right-- is perfectly fine
```

---

## Day 3 — Practice Problems

### Level 0 — Warm Up
1. Given `{1,2,3,4,5,6,7,8,9}`, find all pairs that sum to 8 (trace manually)
2. Given `{1,1,2,3,3,4,5,5}`, trace remove duplicates step by step

### Level 1 — Basic
3. Find if any two numbers in a sorted array sum to a target (return true/false)
4. Remove duplicates from sorted array, return the new length
5. Move all zeros to the end of array without changing order of non-zero elements

### Level 2 — Interview Style
6. Find the pair with the smallest absolute difference in a sorted array
7. Given a sorted array, remove all occurrences of a specific value in place
8. Find three numbers (3Sum) that add up to zero — extension of Pair Sum

### Level 3 — LeetCode
- LC #167 — Two Sum II (sorted array)
- LC #26  — Remove Duplicates from Sorted Array
- LC #11  — Container With Most Water
- LC #15  — 3Sum
- LC #977 — Squares of Sorted Array

---

# Master Cheatsheet

---

## Pattern Recognition

```
Problem Type                         Algorithm              Complexity
-------------------------------------------------------------------
Search in unsorted array          →  Linear Search          O(n)
Search in sorted array            →  Binary Search          O(log n)
Search in rotated array           →  Modified BS            O(log n)
Find minimum in rotated array     →  Compare mid vs right   O(log n)
Search with duplicates            →  Handle equal case      O(n) worst
Find pair with target sum         →  Two Pointer toward     O(n)
Remove duplicates in place        →  Slow and Fast          O(n)
Maximum water or area             →  Two Pointer toward     O(n)
```

---

## Key Formulas and Rules

```
Binary Search:
  mid   = (left + right) / 2
  left  = mid + 1   (go right)
  right = mid - 1   (go left)

Rotated Array — which half is sorted:
  arr[left] <= arr[mid] → LEFT sorted
  arr[left] >  arr[mid] → RIGHT sorted

Find Minimum — where is the drop:
  arr[mid] > arr[right] → drop in RIGHT → left = mid+1
  arr[mid] < arr[right] → drop in LEFT  → right = mid

Container With Most Water:
  water = Math.min(height[left], height[right]) x (right - left)
  always move the SHORTER wall
```

---

## While Loop Conditions

```
Algorithm                         Condition
---------------------------------------------------
Binary Search                  →  left <= right
Search Rotated Array           →  left <= right
Search With Duplicates         →  left <= right
Find Minimum                   →  left < right    (important!)
Two Pointer — pair/water       →  left < right
Remove Duplicates              →  fast < arr.length
```

---

## Common Bugs

```
Bug                                    Fix
-------------------------------------------------------------------
return -1 inside loop              →  move it outside the loop
left = mid instead of mid+1        →  always use mid+1
right = mid-1 in findMinimum       →  use right = mid
while(left<=right) in findMin      →  use left < right
> instead of >= on right check     →  include arr[right] as candidate
Moving taller wall in container    →  always move the shorter wall
Forgetting arr[slow]=arr[fast]     →  always place the unique value
++x vs x++ confusion               →  ++x increments before use
                                      x++ increments after use
```

---

## How Everything Connects

```
Linear Search
    |
    | add sorting requirement
    v
Binary Search
    |
    | add rotation handling
    v
Search in Rotated Array          (LC #33)
    |
    | find the drop point
    v
Find Minimum / Rotation Point    (LC #153)
    |
    | add duplicate handling
    v
Search With Duplicates           (LC #81)


Two Pointer (toward each other)       Slow and Fast (same direction)
    |                                     |
    v                                     v
Pair Sum                           Remove Duplicates
    |                                     |
    v                                     v
Container With Most Water          Sliding Window (Day 4)
```

---

## All Problems Summary

| # | Problem | Pattern | LeetCode | Difficulty |
|---|---------|---------|----------|------------|
| 1 | Linear Search | Loop | — | Easy |
| 2 | Binary Search | Divide and Conquer | — | Easy |
| 3 | Search in Rotated Array | Modified BS | #33 | Medium |
| 4 | Find Minimum in Rotated Array | Modified BS | #153 | Medium |
| 5 | Search With Duplicates | Modified BS | #81 | Hard |
| 6 | Pair Sum | Two Pointer toward | #167 | Easy |
| 7 | Remove Duplicates | Slow and Fast | #26 | Easy |
| 8 | Container With Most Water | Two Pointer toward | #11 | Medium |

---

## LeetCode Practice List

```
Covered so far:
  LC #33  — Search in Rotated Sorted Array
  LC #153 — Find Minimum in Rotated Sorted Array
  LC #81  — Search in Rotated Sorted Array II
  LC #167 — Two Sum II
  LC #26  — Remove Duplicates from Sorted Array
  LC #11  — Container With Most Water

Coming up (Day 4 onward):
  LC #15  — 3Sum
  LC #977 — Squares of Sorted Array
  LC #76  — Minimum Window Substring
  LC #3   — Longest Substring Without Repeating Characters
```

---

## DSA Roadmap

```
Day 1  — Linear Search, Binary Search
Day 2  — Rotated Array Problems
Day 3  — Two Pointer Technique
Day 4  — Sliding Window
Day 5  — HashMap and HashSet
Day 6  — Sorting Algorithms
Day 7  — Linked List
Day 8  — Stacks and Queues
Day 9  — Trees and BST
Day 10 — Recursion and Backtracking
...    — Dynamic Programming
...    — Graphs
...    — Interview Ready
```

---

Days 1 to 3 Complete — 8 Problems Solved | 6 LeetCode Covered
