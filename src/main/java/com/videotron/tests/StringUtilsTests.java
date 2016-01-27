package com.videotron.tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtilsTests {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringUtilsTests obj = new StringUtilsTests();
        obj.run();
    }

    private void run() {
        // TODO Auto-generated method stub
        String a = "aaaaa";
        int b = 123;
        String c = "ccc";
        String bPadded = StringUtils.leftPad(String.valueOf(b), 5, '0');
        String cPadded = StringUtils.leftPad(c, 5, '*');
        String key = getKey(a, bPadded, cPadded);
        System.out.println("["+key+"]");
        String key2 = getKey(a, b, c);
        System.out.println("["+key2+"]");
        String key3 = getKey(45, 5d, Arrays.asList("d", "e"));
        System.out.println("["+key3+"]");
    }

    private String getKey(Object...objs) {
        ArrayList<String> values = new ArrayList<String>();
        for (Object obj: objs) {
            if (ClassUtils.isPrimitiveOrWrapper(obj.getClass())) {
                values.add(String.valueOf(obj));
            }
            else if (obj instanceof String) {
                values.add(obj.toString());
            }
        }
        return StringUtils.join(values.toArray());
    }

}
