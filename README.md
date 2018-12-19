# SuanFa
算法库，记录日常学习的数据结构和相关算法
## 学习练习所做，只为能更好的理解相关知识。
## 大部分代码都在JavaTest中
### 1.基础排序算法（冒泡，选择） 
#### 冒泡算法  
1.原理：从第一项开始，前一项与后一项进行比较，前一项大的话两项交换，直到交换到最后一项，则最后一项为最大的元素，然后剩余元素重复上述步骤，最后排列完成便是生序排列的元素组。  
2.优化：定义flag=true，在内循环中当有元素需要互换时flag=false，循环完成后，如果flag=true，说明元素已经排好序，无需循环，直接break。  
#### 选择排序  
1.原理：定义一个index，记录所有元素总最小元素的索引。然后与第一项互换，然后出去第一项外剩余的项重复此步骤直到最后一项，即可升序排列。  
2.优化：如果index与剩余元素组的首项索引相同，便不用互换。
### 2.分治法（二分查找，快速排序，归并算法）  
#### 二分查找  
必须是已经排好序的数组，中间值>目标值，取后半段，中间值目标值取前半段，重复直到中间值=目标值，便找到了目标值的位置。  
注意：每次移动指针是需要在mid的基础上+1或者-1，防止出现死循环。  
#### 快速排序  
- 原理  
指定一个数组中的元素，元素左边都比元素小，右边都比该元素大，然后左右两边再次进行该操作，直到最后完全排序完成。  
- 应用场景  
数据量大并且是线性结构。    
- 短处  
有大量重复数据时，性能不好，单向链表处理性能不好（一般链表都不使用）。    
- 方法  
声明两个指针，低指针指向数组第一项，高指针指向数组最后一项，然后取出第一项为对比值，先与高指针指向的值对比，暂存值小，高指针后移一位，继续比较高指针，直到找到比暂存之小的，将高指针指向的值放入低指针指向的索引位置，然后比较低指针，比暂存值小，低指针前移一位，直到找到比暂存值大的，将低指针指向的元素移到高指针指向的索引位置。 直到两指针重合，将暂存之放入重合的指针指向的索引，此时，改值左侧都比它小，右侧都比它大，将数组从该索引处分为两端，每一段都递归重复该操作，直到高指针索引-低指针索引<=0，便return，排序便完成。  
若文字比较难理解，请参考下方gif图： 

<div align=center><img src="https://github.com/tanglongfei/SuanFa/blob/master/image/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E5%9B%BE%E8%A7%A3.gif?raw=true"/></div>  

#### 归并算法  

### 3.自定义单向，双向链表
#### 双向链表和单向链表  
- 区别   
双向链表为每个节点都有三段，包括数据、left引用指向前一个结点、right引用指向下一个结点。而单向列表只有数据和right引用指向下一个结点，没有left引用。  
- 优点  
因为双向链表有两个引用，分别指向前后，所以查询的时候可以根据查询位置位于链表的前半段还是后半段来从中间开始往前或者往后查询，所以双向链表查询效率高于单向列表。  
#### 麻将排序  
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
- 概念：  
即两个位置之间能够联通的最短距离，常用于地图寻路和游戏寻路中。
- 方法：  
通过曼哈顿距离进行估值。   
- 示例图：     
 <div align=center><img src="https://github.com/tanglongfei/SuanFa/blob/master/image/%E5%AF%BB%E8%B7%AF%E6%BC%94%E7%A4%BA.gif?raw=true"/></div>
 
### 6.哈夫曼树  
- 定义：考虑带权的节点，每个节点有权重，那么从根节点开始到每个叶子节点的（路径长度*节点权）的总和最小的二叉树为哈夫曼树。
- 特性：权重越大的节点的位置越靠近根节点。我理解为，整个从根节点开始到每个叶子节点次数和最小的即最优二叉树。  
### 7.二叉排序树  
- 原理：  
1.若左子树不为空，那么所有左子树上面的所有节点的关键字值都比根节点的小。  
2.若右子树不为空，那么所有右子树上面的所有节点的关键字值都比根节点的大。  
3.左右子树都为二叉树。     
4.没有重复值。  
- 特性：  
二叉排序树的中序遍历（LDR）顺序为升序排列。  
- 结点操作-删除结点：    
删除结点要分别判断几种情况：  
1.被删除节点左右子树都为空，即为根节点，直接删除。  
2.被删除节点左子树为空并且右子树不为空，直接补上右子树。     
3.被删除节点右子树为空并且左子树不为空，直接补上左子树。    
4.被删除结点左右子树都不为空：  
(1):如果被删除节点的右子树的左子树为空，则直接补上右子树。    
(2):如果被删除节点的右子树的左子树不为空，则把被删除节点右子树的最子树中最小的值节点放到被删除节点的位置，该节点的右子树作为该节点父节点的左子树。  
（以上所有条件中都需要判断被删除节点的父节点是否为空，被删除节点是父节点的左子树还是右子树）   
截取删除操作代码：
```
 //删除结点
    public void delNode(TreeNode node) {
        if (node == null) {
            throw new NoSuchElementException();
        } else if (searchNode(node.data) == null) {
            throw new NoSuchElementException();
        } else {
            //先得到父亲，方便后面的操作
            TreeNode parent = node.parent;
            //1.叶子
            if (node.leftChind == null && node.rightChind == null) {
                //特殊情况：只有一个结点或者是空树
                if (parent == null) {
                    root = null;
                } else if (parent.leftChind == node) {
                    parent.leftChind = null;
                    node.parent = null;
                } else if (parent.rightChind == node) {
                    parent.rightChind = null;
                    node.parent = null;
                }

            } else if (node.leftChind != null && node.rightChind == null) {
                //2.只有左孩子
                if (parent == null) {//要删除的是根结点
                    node.leftChind.parent = null;
                    root = node.leftChind;
                    node.leftChind = null;
                } else {
                    if (node == parent.leftChind) {//要删除的是父亲的左边
                        node.leftChind.parent = parent;
                        parent.leftChind = node.leftChind;
                    } else {//要删除的是父亲的右边
                        node.leftChind.parent = parent;
                        parent.rightChind = node.leftChind;
                    }
                    node.leftChind = null;
                    node.parent = null;
                }
            } else if (node.leftChind == null && node.rightChind != null) {
                //3.只有右孩子
                if (parent == null) {//要删除的是根结点
                    node.rightChind.parent = null;
                    root = node.rightChind;
                    node.rightChind = null;
                } else {
                    if (node == parent.leftChind) {//要删除的是父亲的左边
                        node.rightChind.parent = parent;
                        parent.leftChind = node.rightChind;

                    } else {//要删除的是父亲的右边
                        node.rightChind.parent = parent;
                        parent.rightChind = node.rightChind;
                    }
                    node.parent = null;
                    node.rightChind = null;
                }
            } else {
                //4.有两个孩子
                if (node.rightChind.leftChind == null) {//如果被删除结点的右子树的左子树为空，则直接补上
                    node.rightChind.leftChind = node.leftChind;
                    if (node.parent == null) {
                        root = node.rightChind;
                    } else {
                        if (node.leftChind == node) {
                            parent.leftChind = node.rightChind;
                        } else {
                            parent.rightChind = node.rightChind;
                        }
                        node.parent = null;
                    }
                } else {//否则就补上被删除结点的右子树的左子树中最小的一个
                    TreeNode leftTreeNode = getMinLeftTreeNode(node.rightChind);
                    leftTreeNode.parent.leftChind = null;
                    leftTreeNode.leftChind = node.leftChind;
                    TreeNode leftP = leftTreeNode.parent;
                    leftP.leftChind = leftP.rightChind;
                    leftTreeNode.parent = parent;
                    if (parent == null) {
                        root = leftTreeNode;
                    } else {
                        if (parent.leftChind == node) {
                            parent.leftChind = leftTreeNode;
                        } else {
                            parent.rightChind = leftTreeNode;
                        }
                        node.parent = null;
                    }
                }
                node.leftChind = null;
                node.rightChind = null;
            }
        }
    }

```
### 8.平衡二叉树  
- 定义：  
每个节点的左子树和右子树的高度差最大为1的二叉排序树。  
- 生成：  
1.按照二叉排序树的插入方法进行插入。  
2.每个节点插入后都要回溯判读平衡型，如果某个节点的平衡因子（左子树高度-右子树高度）=2，左平衡调整，=-2，右平衡调整。  
- 调整过程：   
( LH = 1,RH = -1,EH = 0)

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

## 后续还在不断学习更新······
