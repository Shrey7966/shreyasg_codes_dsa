# 🚀 DSA Journey — Day 3: Two Pointer Technique
> **Learner:** Java Developer | **Goal:** Crack Coding Interviews | **Level:** Beginner → Pro
> **Day 2 Recap:** Rotated Array ✅ | Find Minimum ✅ | Search with Duplicates ✅

---

## 📚 Table of Contents
1. [What is Two Pointer?](#what-is-two-pointer)
2. [Two Pointer Patterns](#two-pointer-patterns)
3. [Problem 1 — Pair Sum](#problem-1--pair-sum)
4. [Problem 2 — Remove Duplicates](#problem-2--remove-duplicates)
5. [Problem 3 — Container With Most Water](#problem-3--container-with-most-water)
6. [Quick Grasp Cheatsheet](#quick-grasp-cheatsheet)
7. [Key Takeaways](#key-takeaways)

---

## 🎯 What is Two Pointer?

Two Pointer is a technique where you place **two pointers** on the array and move them based on a condition — instead of checking every possible combination.

```
Brute Force → check every pair → O(n²) 😱
Two Pointer → smart movement   → O(n)  🚀

For 1000 elements:
Brute Force → 1,000,000 operations!
Two Pointer → 1,000 operations!
```

> 💡 **When to use Two Pointer?**
> - Array is sorted (or order matters)
> - You need to find a pair/triplet
> - You need to compare elements from both ends
> - You need to remove/modify elements in place

---

## 🔀 Two Pointer Patterns

```
Pattern 1: Pointers move TOWARD each other
           ← →
           Used for: Pair Sum, Container With Most Water
           
           left=0 ────────────────► 
           ◄──────────────── right=n-1

Pattern 2: Pointers move in SAME direction
           → →
           Used for: Remove Duplicates, Sliding Window
           
           slow ──►
           fast ──────────────────►
```

---

## 💑 Problem 1 — Pair Sum

### ⚡ Quick Grasp
```
Find all pairs in SORTED array that add up to target.

Key insight: Array is sorted!
→ Moving left pointer  RIGHT increases sum
→ Moving right pointer LEFT  decreases sum
→ Use this to home in on target!

Pattern: Pointers move TOWARD each other ← →
```

### Logic
```
sum < target  → need bigger sum  → left++
sum > target  → need smaller sum → right--
sum == target → found pair!      → left++, right--

Stop when: left == right (same element, not a valid pair!)
```

### 🎬 Dry Run
`arr = {1,2,3,4,5,6,7,8,9}`, `target = 10`

| Step | left | right | arr[left] | arr[right] | sum | Action |
|------|------|-------|-----------|------------|-----|--------|
| 1 | 0 | 8 | 1 | 9 | 10 | ✅ print, left++, right-- |
| 2 | 1 | 7 | 2 | 8 | 10 | ✅ print, left++, right-- |
| 3 | 2 | 6 | 3 | 7 | 10 | ✅ print, left++, right-- |
| 4 | 3 | 5 | 4 | 6 | 10 | ✅ print, left++, right-- |
| 5 | 4 | 4 | — | — | — | left==right 🛑 stop! |

**All pairs found in 5 steps!** 🎯

### ☕ Java Code
```java
public static void findPairs(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
            System.out.println(arr[left] + ", " + arr[right]); // print pair
            left++;      // move both inward
            right--;
        } else if (sum < target) {
            left++;      // need bigger sum
        } else {
            right--;     // need smaller sum
        }
    }
}
```

### ⚠️ Why `while(left < right)` not `left <= right`?
```
left == right → both pointing at SAME element
→ can't use same element twice as a pair!
→ stop BEFORE they meet → left < right
```

---

## 🐢🐇 Problem 2 — Remove Duplicates

### ⚡ Quick Grasp
```
Remove duplicates from SORTED array IN PLACE.
No new array needed → O(1) space!

Key insight: Use slow & fast pointers
→ slow = "builder"  → tracks last unique element
→ fast = "explorer" → scans ahead for new unique elements

Pattern: Pointers move in SAME direction → →
```

### Logic
```
arr[slow] == arr[fast] → DUPLICATE!
    → only fast moves → fast++

arr[slow] != arr[fast] → NEW unique element!
    → slow++
    → arr[slow] = arr[fast]  (place it next to slow)
    → fast++

Stop when: fast reaches end of array
Result: arr[0] to arr[slow] contains unique elements!
```

### 🎬 Dry Run
`arr = {1, 1, 2, 2, 3, 4, 4, 5}`

| Step | slow | fast | arr[slow] | arr[fast] | Action |
|------|------|------|-----------|-----------|--------|
| 1 | 0 | 1 | 1 | 1 | duplicate → fast++ |
| 2 | 0 | 2 | 1 | 2 | unique → slow++, arr[1]=2, fast++ |
| 3 | 1 | 3 | 2 | 2 | duplicate → fast++ |
| 4 | 1 | 4 | 2 | 3 | unique → slow++, arr[2]=3, fast++ |
| 5 | 2 | 5 | 3 | 4 | unique → slow++, arr[3]=4, fast++ |
| 6 | 3 | 6 | 4 | 4 | duplicate → fast++ |
| 7 | 3 | 7 | 4 | 5 | unique → slow++, arr[4]=5, fast++ |
| 8 | 4 | 8 | — | — | fast==length 🛑 stop! |

```
Result: {1, 2, 3, 4, 5, 4, 4, 5}
         \_________________/
         only care about this part!
         arr[0] to arr[slow=4] = {1,2,3,4,5} ✅
```

### ☕ Java Code
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
    return slow + 1; // unique count
}
```

### 💡 One-Line Shorthand (Optional)
```java
// These two lines:
slow++;
arr[slow] = arr[fast++];

// Can be written as:
arr[++slow] = arr[fast++];
// ++slow → increment slow FIRST, then use
// fast++ → use fast FIRST, then increment
```

### ⏱️ Complexity
```
Time:  O(n) → fast visits each element once
Space: O(1) → modified in place, no new array! 🔥
```

---

## 🏊 Problem 3 — Container With Most Water

### ⚡ Quick Grasp
```
Find two walls that hold the MOST water.

Key formula:
Water = min(height[left], height[right]) × (right - left)
         ↑                                  ↑
      shorter wall limits height         width between walls

Key insight: Always move the SHORTER wall inward!
→ Moving taller wall → width decreases, height can't improve → pointless!
→ Moving shorter wall → width decreases BUT height MIGHT increase → chance!

Pattern: Pointers move TOWARD each other ← →
```

### Why Move the Shorter Wall?
```
Moving TALLER wall inward:
→ width DECREASES ❌
→ height stays same or DECREASES ❌
→ water can only get worse → NO POINT!

Moving SHORTER wall inward:
→ width DECREASES ❌
→ height MIGHT INCREASE ✅
→ CHANCE of finding more water!
```

### 🎬 Dry Run
`height = {1, 8, 6, 2, 5, 4, 8, 3, 7}`

```
    8           8
    |     5  4  |     7
    |  6  |  |  |  3  |
 1  |  |  |2 |  |  |  |
[0][1][2][3][4][5][6][7][8]
```

| Step | left | right | h[left] | h[right] | Water | maxWater | Move |
|------|------|-------|---------|----------|-------|----------|------|
| 1 | 0 | 8 | 1 | 7 | 1×8=8 | 8 | left++ (shorter) |
| 2 | 1 | 8 | 8 | 7 | 7×7=49 | **49** | right-- (shorter) |
| 3 | 1 | 7 | 8 | 3 | 3×6=18 | 49 | right-- (shorter) |
| 4 | 1 | 6 | 8 | 8 | 8×5=40 | 49 | right-- (equal→else) |
| 5 | 2 | 5 | 6 | 4 | 4×3=12 | 49 | right-- (shorter) |
| 6 | 2 | 4 | 6 | 5 | 5×2=10 | 49 | right-- (shorter) |
| 7 | 2 | 3 | 6 | 2 | 2×1=2 | 49 | right-- (shorter) |
| 8 | 2 | 2 | — | — | — | — | left==right 🛑 |

**Maximum Water = 49!** 🎯

### ☕ Java Code
```java
public static int maxWater(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxWater = 0;

    while (left < right) {
        int water = Math.min(height[left], height[right])
                    * (right - left);           // water formula
        maxWater = Math.max(maxWater, water);   // update max

        if (height[left] < height[right]) {
            left++;     // left is shorter → move left
        } else {
            right--;    // right is shorter OR equal → move right
        }
    }
    return maxWater;
}
```

### ⚠️ Equal Height Case
```java
} else {
    right--;  // handles BOTH height[left] > height[right]
              // AND height[left] == height[right]!
}
```
```
When equal → moving either pointer gives same water value
→ just let else handle it → right-- is perfectly fine! ✅
```

---

## ⚡ Quick Grasp Cheatsheet

```
┌──────────────────────────────────────────────────────────────┐
│                   PATTERN RECOGNITION                        │
├──────────────────────────────────────────────────────────────┤
│ "Find pair with target sum"      → Two Pointer ← →          │
│ "Remove duplicates in place"     → Slow & Fast → →          │
│ "Maximum water/area"             → Two Pointer ← →          │
│ "Sorted array + find pair"       → Think Two Pointer first!  │
└──────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────┐
│                   MOVEMENT RULES                             │
├──────────────────────────────────────────────────────────────┤
│ Pair Sum:                                                    │
│   sum < target  → left++  (need bigger)                     │
│   sum > target  → right-- (need smaller)                    │
│   sum == target → left++, right-- (find next pair)          │
│                                                              │
│ Remove Duplicates:                                           │
│   duplicate → fast++ only                                   │
│   unique    → slow++, arr[slow]=arr[fast], fast++           │
│                                                              │
│ Container With Most Water:                                   │
│   left shorter  → left++                                    │
│   right shorter → right--                                   │
│   equal         → right-- (either works!)                   │
└──────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────┐
│                   WHILE CONDITIONS                           │
├──────────────────────────────────────────────────────────────┤
│ Two pointers moving toward each other → while(left < right) │
│ Fast pointer scanning array           → while(fast < length)│
│                                                              │
│ left < right → stops BEFORE same element                    │
│ (can't use same element twice in a pair!)                   │
└──────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────┐
│                   COMMON BUGS                                │
├──────────────────────────────────────────────────────────────┤
│ left <= right instead of left < right → uses same element!  │
│ Moving taller wall in container       → never improves!     │
│ Forgetting arr[slow]=arr[fast]        → loses unique value! │
│ ++x vs x++ confusion                 → wrong index used!    │
└──────────────────────────────────────────────────────────────┘
```

---

## 🧠 How All Three Problems Connect

```
Pair Sum                    Remove Duplicates         Container With Most Water
← →                         → →                       ← →
Sorted array                Sorted array              Any array
Find pair = target          Remove duplicates         Find max area
Move based on sum           Move based on equality    Move shorter wall
O(n) time, O(1) space       O(n) time, O(1) space     O(n) time, O(1) space
```

> 💡 All Three → O(n) time, O(1) space
> Two Pointer almost always gives you this! 🔥

---

## 🏆 Problems Solved Today

```
✅ Problem 1 — Pair Sum                → Two Pointer ← →
✅ Problem 2 — Remove Duplicates       → Slow & Fast → →
✅ Problem 3 — Container With Most     → Two Pointer ← →
               Water (FAANG Classic!)
```

---

## 🎯 Practice Problems

### Try These on Your Own!
- 🔗 LeetCode #167 — Two Sum II (sorted array)
- 🔗 LeetCode #26  — Remove Duplicates from Sorted Array
- 🔗 LeetCode #11  — Container With Most Water
- 🔗 LeetCode #15  — 3Sum (Three pointers! Extension of Pair Sum)
- 🔗 LeetCode #977 — Squares of Sorted Array

---

## 📅 What's Coming on Day 4

```
Day 4 Topics:
├── Sliding Window Technique 👈 next core weapon
│   ├── Fixed size window
│   ├── Variable size window
│   ├── Maximum sum subarray (Kadane's Algorithm)
│   └── Longest substring without repeating characters
└── Day 4 Notes (.md)
```

> 🚀 Sliding Window is Two Pointer's cousin —
> once you know Two Pointer, Sliding Window will feel natural!
> Used in 25%+ of all string & array interview questions!

---

## 🗺️ Your DSA Journey So Far

```
Day 1 ✅ → Linear Search, Binary Search, Time Complexity
Day 2 ✅ → Rotated Array, Find Minimum, Search with Duplicates
Day 3 ✅ → Two Pointer (Pair Sum, Remove Duplicates, Max Water)
Day 4 🔜 → Sliding Window
Day 5 🔜 → HashMap & HashSet
Day 6 🔜 → Sorting Algorithms
...
```

> 💪 You're building real DSA muscle memory.
> Each day adds a new weapon to your interview toolkit!

---

*📅 Day 3 Complete — You just learned one of the most powerful interview techniques. Two Pointer alone can solve 30%+ of array problems. Keep going!* 🔥
