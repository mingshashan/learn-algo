package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l297.Codec_LevelTraverse;
import com.mingshashan.learn.lt.l297.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * Codec_LevelTraverse_Test
 *
 * @author mingshashan
 */
public class Codec_LevelTraverse_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);

        String serialize = new Codec_LevelTraverse().serialize(root);
        System.out.println(serialize);
    }

    @Test
    public void test_02() {
        String[] nodes = "1,2,3,#,4,#,#,#,#,".split(",");
        System.out.println(Arrays.toString(nodes));
    }
}
