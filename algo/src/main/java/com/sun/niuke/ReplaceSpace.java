package com.sun.niuke;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String str = replaceSpace.replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(str);
    }

    /**
     * 使用StringBuffer
     * 遍历字符串，如果i不为空格，则拼接字符，如果i处为空格，则拼接%20
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}

