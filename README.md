# SuanFa
算法库，记录日常学习的数据结构和相关算法
## 学习练习所做，只为能更好的理解相关知识。
## 大部分代码都在JavaTest中
### 1.基础排序算法（冒泡，选择） 

- 冒泡算法  
原理：从第一项开始，前一项与后一项进行比较，前一项大的话两项交换，直到交换到最后一项，则最后一项为最大的元素，然后剩余元素重复上述步骤，最后排列完成便是生序排列的元素组。  
优化：定义flag=true，在内循环中当有元素需要互换时flag=false，循环完成后，如果flag=true，说明元素已经排好序，无需循环，直接break。  
- 选择排序  
原理：定义一个index，记录所有元素总最小元素的索引。然后与第一项互换，然后出去第一项外剩余的项重复此步骤直到最后一项，即可升序排列。  
优化：如果index与剩余元素组的首项索引相同，便不用互换
### 2.自定义单向，双向链表
- 双向链表和单向链表  
区别：双向链表为每个节点都有三段，包括数据、left引用指向前一个结点、right引用指向下一个结点。而单向列表只有数据和right引用指向下一个结点，没有left引用。  
优点：因为双向链表有两个引用，分别指向前后，所以查询的时候可以根据查询位置位于链表的前半段还是后半段来从中间开始往前或者往后查询，所以双向链表查询效率高于单向列表。  
### 3.简单二叉树遍历，汉诺塔问题，斐波那契数列
### 4.寻路算法及示例
### 5.哈夫曼树
### 6.平衡二叉树（二叉树的左旋，右旋转等）

## 后续还在不断学习更新······
