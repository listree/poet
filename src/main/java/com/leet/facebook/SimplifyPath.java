package com.leet.facebook;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/simplify-path/
 * 71. Simplify Path (Medium)
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
 * convert it to the simplified canonical path.
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level,
 * and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods
 * such as '...' are treated as file/directory names.
 * The canonical path should have the following format:
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory
 * (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 * Runtime 8 ms Beats 57.18%
 * Memory 42.8 MB Beats 62.36%
 */
public class SimplifyPath {

    public final static void main(String[] args) {
        SimplifyPath leet = new SimplifyPath();
        System.out.println(leet.simplifyPath("/home/"));
        System.out.println(leet.simplifyPath("/../"));
        System.out.println(leet.simplifyPath("/home//foo/"));

    }

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        LinkedList<String> list = new LinkedList<String>();

        for(String token: tokens) {
            if( token.equals(".") || token.trim().isEmpty() )
                continue;

            if( token.equals("..") ) {
                if (!list.isEmpty())
                    list.removeLast();
            } else {
                list.add(token);
            }
        }

        String result = "";
        for( String str: list) {
            result += ("/" + str);
        }

        if( result.isEmpty() )
            result = "/";

        return result;
    }

}
