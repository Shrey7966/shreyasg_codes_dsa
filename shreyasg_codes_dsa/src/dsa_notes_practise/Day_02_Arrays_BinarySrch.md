# 🚀 DSA Journey — Day 2: First Real Interview Problem
> **Learner:** Java Developer | **Goal:** Crack Coding Interviews | **Level:** Beginner → Pro
> **Day 1 Recap:** Linear Search ✅ | Binary Search ✅ | Time Complexity Intro ✅

---

## 📚 Table of Contents
1. [What is a Rotated Sorted Array?](#what-is-a-rotated-sorted-array)
2. [The Core Insight](#the-core-insight)
3. [Building the Algorithm](#building-the-algorithm)
4. [Complete Java Solution](#complete-java-solution)
5. [Full Dry Run](#full-dry-run)
6. [Time Complexity](#time-complexity)
7. [Key Takeaways](#key-takeaways)
8. [Practice Problems](#practice-problems)

---

## 🎡 What is a Rotated Sorted Array?

A **rotated sorted array** is a sorted array that has been "rotated" at some pivot point — some elements from the end wrap around to the front.

### Rotation vs Reversal
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

> 💡 Think of it like a **circular wheel** — spin it a few steps, and the end wraps to the front.

### More Examples
```
Original:  1  2  3  4  5  6  7

Rotate 1:  7  1  2  3  4  5  6
Rotate 2:  6  7  1  2  3  4  5
Rotate 3:  5  6  7  1  2  3  4  ← most common example
Rotate 4:  4  5  6  7  1  2  3
```

---

## 💡 The Core Insight

> **In ANY rotated sorted array, one half is ALWAYS fully sorted.**

```
arr = {5, 6, 7, 1, 2, 3, 4}
       \_____/   \_________/
       sorted!     sorted!

No matter where the rotation point is —
one half will always be cleanly sorted!
```

This is your **weapon** 🗡️ — because if one half is sorted, you can:
- Check if target is inside that sorted half
- If YES → search there
- If NO  → search the other half

---

## 🧠 Building the Algorithm

### Step 1: How do you know WHICH half is sorted?

Compare `arr[left]` with `arr[mid]`:

```
arr = {5, 6, 7, 1, 2, 3, 4}
       ↑           ↑
    arr[left]=5  arr[mid]=1

arr[left] > arr[mid] → LEFT half is NOT sorted
                     → RIGHT half MUST be sorted ✅
```

The Rule:
```
if arr[left] <= arr[mid]  → Left half is sorted
else                       → Right half is sorted
```

> 💡 In a normally sorted array, left is NEVER greater than mid.
> So if it is → the rotation point is in the left half → right is clean!

---

### Step 2: Is target INSIDE the sorted half?

Check against the **start and end** of that half:

```
Left half sorted = {5, 6, 7}
→ Is target >= arr[left] AND target < arr[mid]?
→ If YES → target is inside left half!

Right half sorted = {1, 2, 3, 4}
→ Is target > arr[mid] AND target <= arr[right]?
→ If YES → target is inside right half!
```

---

### Step 3: Search or Eliminate

```
If target IS inside sorted half  → search THAT half
If target NOT inside sorted half → search OTHER half
```

### Complete Logic Flow
```
         Find mid
            ↓
    Which half is sorted?
    (compare arr[left] vs arr[mid])
            ↓
    ┌───────────────────────────┐
    │                           │
Left sorted              Right sorted
    │                           │
Is target in            Is target in
left half?              right half?
    │                           │
  YES → search left           YES → search right
  NO  → search right          NO  → search left
```

---

## ☕ Complete Java Solution

```java
public static int searchRotated(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        // ✅ Found it!
        if (arr[mid] == target) return mid;

        // 🔍 Determine which half is sorted
        if (arr[left] <= arr[mid]) {
            // Left half is sorted {arr[left]...arr[mid]}
            if (target >= arr[left] && target < arr[mid]) {
                right = mid - 1;    // target in left half → go left
            } else {
                left = mid + 1;     // target not in left → go right
            }
        } else {
            // Right half is sorted {arr[mid]...arr[right]}
            if (target > arr[mid] && target <= arr[right]) {
                left = mid + 1;     // target in right half → go right
            } else {
                right = mid - 1;    // target not in right → go left
            }
        }
    }
    return -1; // ❌ Not found
}
```

### 🔑 Key Details
```
Left half check:  target >= arr[left] && target < arr[mid]
                                                ↑
                                          strict < because
                                          arr[mid] already checked!

Right half check: target > arr[mid] && target <= arr[right]
                          ↑                            ↑
                    strict > because             include arr[right]
                    arr[mid] already checked!    it could be the target!
```

---

## 🎬 Full Dry Run

`arr = {5, 6, 7, 1, 2, 3, 4}`, `target = 6`

```
Initial: left=0, right=6
┌────┬────┬────┬────┬────┬────┬────┐
│ 5  │ 6  │ 7  │ 1  │ 2  │ 3  │ 4  │
│[0] │[1] │[2] │[3] │[4] │[5] │[6] │
└────┴────┴────┴────┴────┴────┴────┘
  ↑                  ↑               ↑
left=0             mid=3           right=6
```

| Step | left | right | mid | arr[mid] | Which sorted? | Target in? | Action |
|------|------|-------|-----|----------|---------------|------------|--------|
| 1 | 0 | 6 | 3 | 1 | arr[left]=5 > arr[mid]=1 → RIGHT sorted | 6 <= arr[right]=4? ❌ | right = mid-1 = 2 |
| 2 | 0 | 2 | 1 | 6 | arr[mid]=6 == target=6 ✅ | — | return 1 |

**Found at index 1 in just 2 steps!** 🎯

---

### Another Dry Run — `target = 2`

```
arr = {5, 6, 7, 1, 2, 3, 4}, target = 2
```

| Step | left | right | mid | arr[mid] | Which sorted? | Target in? | Action |
|------|------|-------|-----|----------|---------------|------------|--------|
| 1 | 0 | 6 | 3 | 1 | RIGHT sorted {1,2,3,4} | 2 > 1 && 2 <= 4? ✅ | left = mid+1 = 4 |
| 2 | 4 | 6 | 5 | 3 | LEFT sorted {2,3} | 2 >= arr[left]=2 && 2 < 3? ✅ | right = mid-1 = 4 |
| 3 | 4 | 4 | 4 | 2 | arr[mid]=2 == target ✅ | — | return 4 |

**Found at index 4 in 3 steps!** 🎯

---

## ⏱️ Time Complexity

| Algorithm | Time Complexity | Steps for 7 elements | Steps for 1M elements |
|---|---|---|---|
| Linear Search | O(n) | up to 7 | up to 1,000,000 |
| Binary Search | O(log n) | up to 3 | up to 20 |
| Search Rotated | O(log n) | up to 3 | up to 20 |

> 💡 Even though we do a few extra comparisons per step (checking which half is sorted), those are **fixed** — they don't grow with input size.
> So the overall complexity is still **O(log n)**!

---

## 🧠 The Logic Pattern This Problem Teaches

```
✅ Not every problem fits perfectly into a template
✅ Sometimes you need to ADD a condition to a known algorithm
✅ Binary Search isn't just for sorted arrays —
   it works anywhere you can ELIMINATE half the data!

This is called: "Modified Binary Search" pattern
```

You'll see this pattern again in:
- Find minimum in rotated array
- Search in nearly sorted array
- Find peak element
- Search in infinite sorted array

---

## 🧠 Key Takeaways

```
✅ Rotated array = sorted array with a wrap-around point
✅ One half is ALWAYS sorted in a rotated array
✅ Identify sorted half by: arr[left] <= arr[mid]
✅ Check if target is INSIDE sorted half using start & end values
✅ Eliminate half each step → still O(log n)
✅ You solved a real FAANG interview question! 🔥
```

---

## 🔗 How This Connects

```
Day 1: Linear Search ──────────────────────────────┐
Day 1: Binary Search ──────────────────────────────┤
Day 2: Search in Rotated Array (Modified BS) ──────┘
                                                    ↓
                              Day 3: Two Pointer Technique
                              (new weapon, new patterns!)
```

---

## 🎯 Practice Problems

### Level 0 — Warm Up
- Given `{4, 5, 6, 7, 0, 1, 2}`, find `0` manually (trace with pen & paper)
- Given `{3, 4, 5, 1, 2}`, find `4` manually

### Level 1 — Basic
- Search in rotated array (what we built today ✅)
- Find the **rotation point** (index where the array was rotated)

### Level 2 — Interview Style
- Find **minimum element** in rotated sorted array
- Search in rotated array with **duplicate elements**
  *(Hint: duplicates break our arr[left] <= arr[mid] trick!)*

### Level 3 — LeetCode
- 🔗 LeetCode #33 — Search in Rotated Sorted Array
- 🔗 LeetCode #153 — Find Minimum in Rotated Sorted Array
- 🔗 LeetCode #81 — Search in Rotated Sorted Array II (with duplicates)

---

## 📅 What's Coming on Day 3

```
Day 3 Topics:
├── Two Pointer Technique 👈 your next core weapon
│   ├── What it is & when to use it
│   ├── Pair Sum problem
│   ├── Remove duplicates
│   └── Container with most water (classic interview problem!)
└── Day 3 Notes (.md)
```

> 🚀 **You're building real momentum!**
> Day 1 → Searching. Day 2 → First FAANG problem. Day 3 → New technique entirely.
> Each day you're adding a new tool to your DSA toolkit. Keep going! 💪

---

*📅 Day 2 Complete — You just solved your first real interview question. That's not nothing — that's everything.* 🔥
