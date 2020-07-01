package com.stillhere.pojo;

import com.stillhere.interfaceIml.testSortInterface;
import com.stillhere.utils.ClassSortUtil;

/**
 * Created by DJ026743 on 2020/7/1.
 */
public class testSortPojo {

    @testSortInterface(sort = 2)
    protected String b;
    @testSortInterface(sort = 3)
    protected String c;
    @testSortInterface(sort = 1)
    protected String a;
}
