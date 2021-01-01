package com.supinfo.gmy.algorithm;

/** 
* @Description: 翻转单词顺序列
* 题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。
* 任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。正确的解法应该是和书上一样，先旋转每个单词，再旋转整个字符串。
* "nowcoder. a am I"
"I am a nowcoder."
先翻转每个单词，再反转数组
* @author: gaomingyang
* @date: 2020-12-25
*/
public class Question63 {
	public static void main(String[] args) {
		reverseStringSequence("I am a student.");
	}

	public static String reverseStringSequence(String str) {
		if (str == null || str == "") {
			return str;
		}
		char[] seq = str.toCharArray();
		int length = seq.length;
		// 定义两个指针记录要反转单词的起始位置
		int start = 0;
		int end = 0;
		// 这里一定要含有等于，因为要判断是否是最后一个单词，从而可以处理最后一个单词
		while (end <= length) {
			// 当已经遍历到字符串的最后一个字符，或者当前字符是空格时
			// 则对空格前的单词进行反转，即"am"反转为"ma"
			// 一定要把判断是否是结尾放在前面，否则seq[end]会报错，因为数组的有效索引是从0开始的
			// 反转后修改单词的起始指针为空格的下一个字符
			// 如果不符合条件，则移动指针继续判断下一个字符
			if (end == length || seq[end] == ' ') {
				reverse(seq, start, end - 1);
				start = end + 1;
			}
			end++;
		}
		// 反转这个数组
		reverse(seq, 0, length - 1);
		return new String(seq);
	}

	private static void reverse(char[] seq, int start, int end) {
		while (start < end) {
			char temp = seq[start];
			seq[start] = seq[end];
			seq[end] = temp;
			start++;
			end--;
		}
	}

}