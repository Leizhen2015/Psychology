package com.psychology.Entity.EntityConstant;

import java.util.HashMap;

/**
 * Created by LeiZhen on 2017/3/29.
 */

public class DoctorConstant {

    public static final HashMap<Integer,String> mMap = new HashMap<Integer,String>(){{

        put(100,"武汉大学");
        put(200,"华中师范大学");
        put(300,"武汉理工大学");
        put(400,"中国地质大学");
        put(500,"武汉科技大学");

        put(1001,"文理学部");
        put(1002,"工学部");
        put(1003,"信息学部");
        put(1004,"医学部");

        put(2001,"1校区");
        put(2002,"2校区");
        put(2003,"3校区");
        put(2004,"4校区");

        put(0,"周一上午");
        put(1,"周一下午");
        put(2,"周二上午");
        put(3,"周二下午");
        put(4,"周三上午");
        put(5,"周三下午");
        put(6,"周四上午");
        put(7,"周四下午");
        put(8,"周五上午");
        put(9,"周五下午");
        put(10,"周六上午");
        put(11,"周六下午");
        put(12,"周日上午");
        put(13,"周日下午");

    }
    };

    //关注
    public static final int GUANZHU_YES= 1;
    public static final int GUANZHU_NO = 0;

    //大学
    public static final int SCHOOL_WUHANDAXUE = 100;
    public static final int SCHOOL_HUASHI = 200;
    public static final int SCHOOL_WUHANLIGONG = 300;
    public static final int SCHOOL_ZHONGGUODIZHI =400;
    public static final int SCHOOL_WUHANKEJI =500;

    //武大校区
    public static final int SCHOOL_WUDA_WENLI = 1001;
    public static final int SCHOOL_WUDA_GONG =1002;
    public static final int SCHOOL_WUDA_XINXI =1003;
    public static final int SCHOOL_WUDA_YI = 1004;

    //华师校区
    public static final int SCHOOL_HUASHI_1 = 2001;
    public static final int SCHOOL_HUASHI_2 = 2002;
    public static final int SCHOOL_HUASHI_3 = 2003;
    public static final int SCHOOL_HUASHI_4 = 2004;

    //可预约时间
    public static final String TIME_YI_SHANG = "周一上午";

}
