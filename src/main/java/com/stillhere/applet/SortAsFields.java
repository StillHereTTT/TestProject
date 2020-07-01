package com.stillhere.applet;

import com.stillhere.interfaceIml.testSortInterface;
import com.stillhere.pojo.ZQZHXX;
import com.stillhere.pojo.testSortPojo;
import com.stillhere.utils.ClassSortUtil;

import javax.xml.bind.annotation.XmlAttribute;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by DJ026743 on 2020/7/1.
 */
public class SortAsFields {

    /**
     * 根据tSortFields内字段的顺序，将tValues的各个值对应的存到tObject对象中，例子可见main方法
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
                //此处类型限制比较大，暂时没有想好如何处理
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

    /**
     * 使用注解排序，将tValues的值，按顺序放入tObject对象中
     *
     * @param tObject
     * @param tValues
     * @return
     */
    public static Boolean setPojoValues(Object tObject, String[] tValues) {
        Boolean tResult = true;
        //获取类属性，根据testSortInterface注解排序
        Field[] declaredFields = tObject.getClass().getDeclaredFields();
        List<Field> collect = Arrays.stream(declaredFields).filter(field -> {
            if (field.isAnnotationPresent(testSortInterface.class)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        collect.sort(Comparator.comparingInt(field -> field.getAnnotation(testSortInterface.class).sort()));
        //排序后，将tValue的值按顺序放入tObject对象中
        for (int i = 0; i < Math.min(tValues.length, collect.size()); i++) {
            Field declaredField = declaredFields[i];
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            try {
                Object o = type.newInstance();
                //此处类型限制比较大，暂时没有想好如何处理
                if (o instanceof String) {
                    o = tValues[i];
                }
                declaredFields[i].set(tObject, o);
            } catch (InstantiationException e) {
                e.printStackTrace();
                tResult = false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                tResult = false;
            }
        }
        return tResult;
    }

    public static void main(String[] args) {
        /*//1、setPojoValues方法举例：
        ZQZHXX t = new ZQZHXX();
        String[] a = {"1", "2"};
        Boolean aBoolean = SortAsFields.setPojoValues(t, a, ClassSortUtil.ZXZHXXSetFields);
        System.out.println(aBoolean);*/
        /*//2、setPojoValues方法举例：
        testSortPojo t2 = new testSortPojo();
        String[] a2 = {"1", "2"};
        Boolean aBoolean2 = SortAsFields.setPojoValues(t2, a2);
        System.out.println(aBoolean2);*/
    }
}
