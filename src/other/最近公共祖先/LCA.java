package other.最近公共祖先;

/**
 * Created by jiangyunxiong on 2018/5/3.
 */

import 剑指offer.TreeNode;

/**
 * 对于有根树T的两个结点u、v，最近公共祖先LCA(T,u,v)表示一个结点x，满足x是u、v的祖先且x的深度尽可能大。
 */
public class LCA {

    /**
     * 解法一：暴力对待
     * 1.1、是二叉查找树
     * 那么从树根开始：
     1、如果当前结点t 大于结点u、v，说明u、v都在t 的左侧，所以它们的共同祖先必定在t 的左子树中，故从t 的左子树中继续查找；
     2、如果当前结点t 小于结点u、v，说明u、v都在t 的右侧，所以它们的共同祖先必定在t 的右子树中，故从t 的右子树中继续查找；
     3、如果当前结点t 满足 u <t < v，说明u和v分居在t 的两侧，故当前结点t 即为最近公共祖先；
     4、而如果u是v的祖先，那么返回u的父结点，同理，如果v是u的祖先，那么返回v的父结点。
     */
    public int query(TreeNode t, TreeNode u, TreeNode v){
        int left = u.val;
        int right = v.val;

        //二叉查找数，如果左节点大于右节点，不对，交换
        if(left > right){
            int temp = left;
            left = right;
            right = temp;
        }

        while(true){
            if (t.val < left){
                t = t.right;
            }else if(t.val > right){
                t = t.left;
            }
            return t.val;
        }
    }
}
