package com.stillhere.applet;

import com.stillhere.pojo.ZQZHXX;
import com.stillhere.utils.ClassSortUtil;

import java.lang.reflect.Field;

/**
 * Created by DJ026743 on 2020/7/1.
 */
public class SortAsFields {

    /**
     * 根据tSortFields内字段的顺序，将tValues的各个值对应的存到tObject对象中，例子可见main方法
     * 如果使用JDK1.8版本以上，可以使用注解排序
     *
     * @param tObject     传入对象
     * @param tValues     字段对应的值
     * @param tSortFields 字段顺序
     * @return
     */
    public static Boolean setPojoValues(Object tObject, String[] tValues, String[] tSortFields) {
        Boolean tResult = true;
        try {
            //使用Math.min函数是为了防止字段与值数量不对应
            for (int i = 0; i < Math.min(tValues.length, tSortFields.length); i++) {
                Field declaredField = tObject.getClass().getDeclaredField(tSortFields[i]);
                declaredField.setAccessible(true);
                Class<?> type = declaredField.getType();
                Object o = type.newInstance();
                if (o instanceof String) {
                    o = tValues[i];
                }
                declaredField.set(tObject, o);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            tResult = false;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            tResult = false;
        } catch (InstantiationException e) {
            e.printStackTrace();
            tResult = false;
        }
        return tResult;
    }

    public static void main(String[] args) {
        //setPojoValues方法举例：
        /*ZQZHXX t = new ZQZHXX();
        String[] a = {"1", "2"};
        Boolean aBoolean = SortAsFields.setPojoValues(t, a, ClassSortUtil.ZXZHXXSetFields);
        System.out.println(aBoolean);*/
    }
}
