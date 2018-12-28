# SuanFa
算法库，记录日常学习的数据结构和相关算法
## 学习练习所做，只为能更好的理解相关知识,大部分代码都在JavaTest中  

## 目录：
- [1.基础排序算法](#1基础排序算法冒泡选择)  
  - [冒泡](#冒泡算法)  
  - [选择](#选择排序)  
- [2.分治算法](#2分治法二分查找快速排序归并算法)  
  - [二分查找](#二分查找)  
  - [快速排序](#快速排序)  
  - [归并排序](#归并排序)  
- [3.自定义单向双向链表](#3自定义单向双向链表)  
  - [双向链表和单向链表](#双向链表和单向链表)  
  - [麻将排序](#麻将排序)  
- [4.简单二叉树遍历、汉诺塔问题、斐波那契数列](#4简单二叉树遍历汉诺塔问题斐波那契数列)  
  - [二叉树遍历](#二叉树遍历)  
  - [汉诺塔](#汉诺塔)  
  - [斐波那契数列](#斐波那契数列)  
- [5.寻路算法及示例](#5寻路算法及示例)  
- [6.哈夫曼树](#6哈夫曼树)  
- [7.二叉排序树](#7二叉排序树)  
- [8.平衡二叉树](#8平衡二叉树)  
- [9.红黑树](#9红黑树)  
- [10.图论基础](#10图论基础)   
- [11.图的遍历](#11图的遍历)  
  - [深度优先](#深度优先)  
  - [广度优先](#广度优先)  
- [12.动态规划](#12动态规划)   
  - [最长公共子序列（LCS）](#最长公共子序列LCS)  
  - [KMP算法](#KMP算法改进的字符串匹配算法)  
  - [Floyd算法（罗伯特·弗洛伊德算法）](#Floyd算法罗伯特弗洛伊德算法)
### 1.基础排序算法（冒泡，选择） 
#### 冒泡算法  
（代码位置：JavaTest ExampleUnitTest）

原理：  
从第一项开始，前一项与后一项进行比较，前一项大的话两项交换，直到交换到最后一项，则最后一项为最大的元素，然后剩余元素重复上述步骤，最后排列完成便是生序排列的元素组。  

优化：  
定义flag=true，在内循环中当有元素需要互换时flag=false，循环完成后，如果flag=true，说明元素已经排好序，无需循环，直接break。  



#### 选择排序  
代码位置： 
JavaTest ExampleUnitTest   

原理：  
定义一个index，记录所有元素总最小元素的索引。然后与第一项互换，然后出去第一项外剩余的项重复此步骤直到最后一项，即可升序排列。 

优化：  
如果index与剩余元素组的首项索引相同，便不用互换。  

 

### 2.分治法（二分查找，快速排序，归并算法）  
#### 二分查找  
代码位置： 
JavaTest FenZhi  

必须是已经排好序的数组，中间值>目标值，取后半段，中间值目标值取前半段，重复直到中间值=目标值，便找到了目标值的位置。  
注意：每次移动指针是需要在mid的基础上+1或者-1，防止出现死循环。 

#### 快速排序  
代码位置： 
JavaTest FenZhi  

原理：    
指定一个数组中的元素，元素左边都比元素小，右边都比该元素大，然后左右两边再次进行该操作，直到最后完全排序完成。  

应用场景：  
数据量大并且是线性结构。    

短处：  
有大量重复数据时，性能不好，单向链表处理性能不好（一般链表都不使用）。   

方法：  
声明两个指针，低指针指向数组第一项，高指针指向数组最后一项，然后取出第一项为对比值，先与高指针指向的值对比，暂存值小，高指针后移一位，继续比较高指针，直到找到比暂存之小的，将高指针指向的值放入低指针指向的索引位置，然后比较低指针，比暂存值小，低指针前移一位，直到找到比暂存值大的，将低指针指向的元素移到高指针指向的索引位置。 直到两指针重合，将暂存之放入重合的指针指向的索引，此时，改值左侧都比它小，右侧都比它大，将数组从该索引处分为两端，每一段都递归重复该操作，直到高指针索引-低指针索引<=0，便return，排序便完成。  
- 示例图   
<div align=center><img src="https://github.com/tanglongfei/SuanFa/blob/master/image/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E5%9B%BE%E8%A7%A3.gif?raw=true"/></div>  

#### 归并排序   
代码位置： 
JavaTest FenZhi  

归并算法：  
首先需要归并算法，归并算法就是一个数组，从mid指针左数组和右数组分别都是升序排列，把两个数组归并成一个升序的数组的算法。 

归并排序： 
任何顺序排列的数组，可以分成两组，然后每一组又可以分成两组，直到每组为两个或者1个位置，然后调用归并算法，最终归并成一个排好序的数组，过程类似二叉树的后序遍历。   

应用场景：  
数据量大并且有很多重复数据，链式结构。  
短处：  
需要空间大。  

### 3.自定义单向，双向链表
#### 双向链表和单向链表  
代码位置： JavaTest Linked包 
<font face="黑体">我是黑体字</font>

区别：   
双向链表为每个节点都有三段，包括数据、left引用指向前一个结点、right引用指向下一个结点。而单向列表只有数据和right引用指向下一个结点，没有left引用。  

优点：  
因为双向链表有两个引用，分别指向前后，所以查询的时候可以根据查询位置位于链表的前半段还是后半段来从中间开始往前或者往后查询，所以双向链表查询效率高于单向列表。  
#### 麻将排序  
代码位置： 
JavaTest Linked包  

先new9个双向链表，以点数为索引把对应点数的麻将放入对应索引的链表中，放完之后把所有的链表按照点数索引的顺序添加到集合中，集合中的元素变为（花色，点数）：[（1，1），（2，1），（3，1），（3，2），（1，2），（2，2）·····（3，9），（1，9），（2，9）]，花色不固定，但是点数是按照顺序排列的。然后new3个链表，一次将同一个花色的取出放到对应链表中，最后组合起来，便排序完成（未考虑特殊花色，如东风、红中等，可单独设置花色和点数）。
### 4.简单二叉树遍历，汉诺塔问题，斐波那契数列  
#### 二叉树遍历：  
前序（DLR），中序（LDR），后序（LRD）。
#### 汉诺塔：  
解决方案即二叉树的中序遍历。  
#### 斐波那契数列：  
1 1 2 3 5 8 13 ······  
即从第三项开始每一项都是前两项的和。  
解决方案：递归。  
### 5.寻路算法及示例  
代码位置： 
程序 xunlu包   

概念：  
即两个位置之间能够联通的最短距离，常用于地图寻路和游戏寻路中。

方法：  
通过曼哈顿距离进行估值。   
- 示例图     
 <div align=center><img src="https://github.com/tanglongfei/SuanFa/blob/master/image/%E5%AF%BB%E8%B7%AF%E6%BC%94%E7%A4%BA.gif?raw=true"/></div>
 
### 6.哈夫曼树  
代码位置： 
JavaTest HuffmanTree  

定义：  
考虑带权的节点，每个节点有权重，那么从根节点开始到每个叶子节点的（路径长度*节点权）的总和最小的二叉树为哈夫曼树。 

特性：  
权重越大的节点的位置越靠近根节点。我理解为，整个从根节点开始到每个叶子节点次数和最小的即最优二叉树。  
### 7.二叉排序树  
代码位置： 
JavaTest SearchBinaryTree  

原理：  
1.若左子树不为空，那么所有左子树上面的所有节点的关键字值都比根节点的小。  
2.若右子树不为空，那么所有右子树上面的所有节点的关键字值都比根节点的大。  
3.左右子树都为二叉树。     
4.没有重复值。  

特性：  
二叉排序树的中序遍历（LDR）顺序为升序排列。  

结点操作-删除结点：  
1.被删除节点左右子树都为空，即为根节点，直接删除。  
2.被删除节点左子树为空并且右子树不为空，直接补上右子树。     
3.被删除节点右子树为空并且左子树不为空，直接补上左子树。    
4.被删除结点左右子树都不为空：  
(1):如果被删除节点的右子树的左子树为空，则直接补上右子树。    
(2):如果被删除节点的右子树的左子树不为空，则把被删除节点右子树的最子树中最小的值节点放到被删除节点的位置，该节点的右子树作为该节点父节点的左子树。  
（以上所有条件中都需要判断被删除节点的父节点是否为空，被删除节点是父节点的左子树还是右子树）    
本方法只用于学习时方便理解，实际使用基本不会使用这种方法，而是会使用红黑树的方法。

### 8.平衡二叉树  
代码位置： 
JavaTest AVLBTree    

定义：  
每个节点的左子树和右子树的高度差最大为1的二叉排序树。

生成：  
1.按照二叉排序树的插入方法进行插入。  
2.每个节点插入后都要回溯判读平衡型，如果某个节点的平衡因子（左子树高度-右子树高度）=2，左平衡调整，=-2，右平衡调整。  

调整过程( LH = 1,RH = -1,EH = 0)：    
左平衡（即节点t的不平衡是因为左子树过深）：   
1.如果新的节点插入到t的左孩子的左子树中，直接t右旋。   
2.如果新的节点插入到t的左孩子的右子树中，先t的左孩子tl左旋，然后t右旋。但是这种情况调整平衡因子需要分三种情况：  
(1).当t的左孩子的右子树根节点的balance=RIGHT_HIGH时：
```
t.balance = EH;
tl.balance = LH;
tlr.balance = EH;
```  
(2).当t的左孩子的右子树根节点的balance=LEFT_HIGH时：
```
t.balance = RH;
tl.balance = EH;
tlr.balance = EH;
```
(3).当t的左孩子的右子树根节点的balance=EQUAL_HIGH时：  
```
t.balance = EH;
tl.balance = LH;
tlr.balance = EH;
```
右平衡（即节点t的不平衡是因为右子树过深）：  
1.如果新的节点插入到t的右孩子的右子树中，直接t左旋。    
2.如果新的节点插入到t的右孩子的左子树中，先t的右孩子tr右旋，然后t左旋。但是这种情况调整平衡因子需要分三种情况：  
(1).当t的右孩子的左子树根节点的balance=RIGHT_HIGH时：
```
t.balance = LH;
tr.balance = EH;
trl.balance = EH;
```
(2).当t的右孩子的左子树根节点的balance=LEFT_HIGH时：  
```
t.balance = EH;
tr.balance = RH;
trl.balance = EH;
```
(3).当t的右孩子的左子树根节点的balance=EQUAL_HIGH时：
```
t.balance = EH;
tr.balance = EH;
trl.balance = EH;
```
### 9.红黑树  
性质：  
它时对平衡树的改进，任意一个节点，它的左右子树的层数最多不超过一倍，就是说，假如左子树为3层，那么右子树最少为2层，最多为6层。  

定义：  
或者是一颗空树，或者是具有一下性质的二叉查找树（二叉排序树）：  
1.节点非红即黑。  
2.根节点为黑色。  
3.所有NULL节点成为叶子节点，且认为颜色为黑。  
4.所有红节点的子节点都为黑色。  
5.从任一节点到其叶子节点的所有路径上都包含相同数目的黑节点。  
- 示例图  
<div align="center">
<img src="https://github.com/tanglongfei/SuanFa/blob/master/image/%E7%BA%A2%E9%BB%91%E6%A0%91.jpg"/>
</div>

应用：  
Hashtable TreeSet TreeMap，本人学习是参考TreeMap源码进行的。  

插入节点：  
1.先按照二叉排序树的方式插入一个节点(红色)。  
2.如果插入的是根节点，直接将节点涂黑。  
3.如果插入的节点的父节点是黑色，直接插入，不用调整。  
4.如果插入的节点的父节点是红色，则总体分为两种情况：  
  （1）如果父节点是祖父节点的左孩子：  
  情况1：若祖父节点的另一个节点（叔叔节点）是红色，则将当前节点的父节点和叔叔节点涂黑，祖父节点涂红，把当前节点指向祖父节点，从新的当前节点开始算法。  
  情况2：若叔叔节点是黑色，当前节点是其父节点的右孩子，则将当前节点的父节点作为新的当前节点，以新当前节点为支点左旋。    
  情况3：若叔叔节点是黑色，当前节点是其父节点的左孩子，则将父节点变成黑色，祖父节点变成红色，再以祖父节点为支点右旋。  
  最后要将根节点的颜色涂成黑色。  
  （2）如果父节点是祖父节点的右孩子，和上面情况一样，将左全部换成右即可。  
    
- 参考TreeMap源码
```
 /** From CLR */
    private void fixAfterInsertion(TreeMapEntry<K,V> x) {
        x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                TreeMapEntry<K,V> y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                TreeMapEntry<K,V> y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

```

删除节点：  
先进行二叉树排序的删除操作，然后已替换节点作为当前节点进行后面的平衡操作：  
1.当前节点是红色，直接把当前节点染成黑色，结束。  
2.当前节点x是黑色：  
（1）如果当前节点是父节点的左孩子：  
情况1:若当前节点是根节点，什么都不用做。  
情况2:若当前节点x的兄弟节点是红色（此时父节点和兄弟节点分别为黑），直接把父节点染成红色，兄弟节点染成黑色，对父节点进行左旋，重新设置x的兄弟节点。  
情况3:让前节点x的兄弟节点是黑色，这是又得分三种情况：  
  &emsp;情况3.1：兄弟节点的两个孩子都是黑色，则将x的兄弟节点设为红色，设置x的父节点为新的x节点。  
  &emsp;情况3.2：兄弟节点的右孩子为黑色，左孩子是红色，则将x兄弟节点的左孩子设为黑色，x兄弟节点设置为红色，x的兄弟节点右旋，右旋后重新设置x的兄弟节点。     
  &emsp;情况3.3：兄弟节点的右孩子为红色，则把兄弟节点染成当前节点父节点颜色，把当前节点父节点染成黑色，兄弟节点右孩子染成黑色，再以当前节点的父节点为支点进行左旋，算法结算。  
  （2）被删除节点是父节点的右孩子，则把上面的左设置为右即可。  
若看不懂文字解释，直接看TreeMap源码即可，TreeMap源码写的很清楚。  

- 参考TreeMap源码  
```
   public V remove(Object key) {
        TreeMapEntry<K,V> p = getEntry(key);
        if (p == null)
            return null;

        V oldValue = p.value;
        deleteEntry(p);
        return oldValue;
    }
    
     /**
     * Delete node p, and then rebalance the tree.
     */
    private void deleteEntry(TreeMapEntry<K,V> p) {
        modCount++;
        size--;

        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (p.left != null && p.right != null) {
            TreeMapEntry<K,V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        } // p has 2 children

        // Start fixup at replacement node, if it exists.
        TreeMapEntry<K,V> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK)
                fixAfterDeletion(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }
    
    /** From CLR */
    private void fixAfterDeletion(TreeMapEntry<K,V> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                TreeMapEntry<K,V> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib))  == BLACK &&
                    colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                TreeMapEntry<K,V> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                    colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }
```

### 10.图论基础  
定义：  
图（Graph）是由顶点的有穷集合和顶点之间的集合组成，通常表示为：G（V.E），G表示一个图，V是图G中顶点的集合，E是图G中边的集合。  

基本性质：  
线性表中我们把数据元素叫元素，树中将数据元素叫节点，在图中数据元素，我们称之为顶点。  
线性表中可以没有数据元素，称为空表，树中可以没有节点，叫空树。  
线性表中，相邻的数据元素之间具有线性关系，树结构中，相邻两层的结点之间具有层次关系，而图中，任意两个顶点之间都可能有关系，顶点之间的逻辑关系用边来表示，边集可以是空的。  

参考（https://blog.csdn.net/chichoxian/article/details/52674252）

### 11.图的遍历  
代码位置：  
JavaTest  graph包->Graph  

#### 深度优先    
假设给定图G的初态是所有顶点均未曾访问过。在G中任选一顶点v为初始出发点(源点)，则深度优先遍历可定义如下：首先访问出发点v，并将其标记为已访问过；然后依次从v出发搜索v的每个邻接点w。若w未曾访问过，则以w为新的出发点继续进行深度优先遍历，直至图中所有和源点v有路径相通的顶点(亦称为从源点可达的顶点)均已被访问为止。若此时图中仍有未访问的顶点，则另选一个尚未访问的顶点作为新的源点重复上述过程，直至图中所有顶点均已被访问为止。  
图的深度优先遍历类似于树的前序遍历。采用的搜索方法的特点是尽可能先对纵深方向进行搜索。这种搜索方法称为深度优先搜索(Depth-First Search)。相应地，用此方法遍历图就很自然地称之为图的深度优先遍历。

#### 广度优先 
1、从图中某个顶点V0出发，并访问此顶点；  
2、从V0出发，访问V0的各个未曾访问的邻接点W1，W2，…,Wk;然后,依次从W1,W2,…,Wk出发访问各自未被访问的邻接点；  
3、重复步骤2，直到全部顶点都被访问为止。  

#### 区别及应用场景  
深度优先搜素算法：不全部保留结点，占用空间少；有回溯操作(即有入栈、出栈操作)，运行速度慢。 

广度优先搜索算法：保留全部结点，占用空间大； 无回溯操作(即无入栈、出栈操作)，运行速度快。  

通常 深度优先搜索法不全部保留结点，扩展完的结点从数据库中弹出删去，这样，一般在数据库中存储的结点数就是深度值，因此它占用空间较少。所以，当搜索树的结点较多，用其它方法易产生内存溢出时，深度优先搜索不失为一种有效的求解方法。   　

广度优先搜索算法，一般需存储产生的所有结点，占用的存储空间要比深度优先搜索大得多，因此，程序设计中，必须考虑溢出和节省内存空间的问题。但广度优先搜索法一般无回溯操作，即入栈和出栈的操作，所以运行速度比深度优先搜索要快些

### 12.动态规划  
#### 基础    
概念：  
动态规划是运筹学的一个分支，是求解决策过程最优化的数学方法。  

原理：  
把多阶段过程转化为一系列单阶段问题，利用各阶段之间的关系，逐个求解。  

特点：  
分析是从大到小，写代码是从小到大，计算过程会把结果都记录下来，最终结果在记录中找到。

#### 最长公共子序列（LCS）  
定义：  
一个序列A任意删除若干个字符后得到的心序列B，则B叫做A的子序列。  
两个序列X和Y的公共子序列中，长度最长的那个，定义为X和Y的最长公共子序列。  
例如X={A,B,C,B,D,A,B},Y={B,D,C,A,B,A}，则他们的lcs是{B,C,B,A}和{B,D,A,B}。求出一个即可。  

应用：  
相似度比较：计算生物学DNA比对（亲自验证），百度云盘找非法数据（岛国片··）。  
图像相似处理，媒体流的相似比较，百度知道，百部百科，web页面中找非法言论。  

解决办法：  
穷举法（实际不可取）  
动态规划  
参考（https://blog.csdn.net/u013921430/article/details/79299678）

#### KMP算法（改进的字符串匹配算法）  

### Floyd算法（罗伯特·弗洛伊德算法）  

## 后续还在不断学习更新······
