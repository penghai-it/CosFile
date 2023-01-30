package it.ph.com.cosfiletest.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author PH
 * @时间： 2022/11/24
 * @描述： 流处理练习
 */
public class Streamtest {

    public static void main(String[] args) {

        List<UserPo> list = new ArrayList<>();
        list.add(new UserPo("小一", 10.d));
        list.add(new UserPo("小五", 50.d));
        list.add(new UserPo("小六", 60.d));
        list.add(new UserPo("小6", 60.d));
        list.add(new UserPo("小空", null));
        list.add(new UserPo("小九", 90.d));

        // filter 过滤器的使用
        // 筛选出成绩不为空的学生人数
        long count = list.stream().filter(p -> null != p.getScore()).count();
        System.out.println("成绩不为空的学生人数：" + count);

        // 筛选出成绩不为空的学生集合
        List<UserPo> collect = list.stream().filter(p -> null != p.getScore()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        collect.forEach(UserPo::getName);

        // map 将集合映射为另外一个集合
        // 取出所有学生的成绩
        List<Double> collect1 = list.stream().map(p -> {
            //判读是否为空
            if (null != p.getScore()) {
                return p.getScore();
            }
            return 0.d;
        }).collect(Collectors.toList());
        System.out.println("所有学生的成绩集合：" + collect1);

        //取出所有学生的姓名
        List<String> collect2 = list.stream().map(UserPo::getName).collect(Collectors.toList());
        collect2.forEach(System.out::println);

        // 将学生姓名集合串成字符串，用逗号分隔
        String collect3 = list.stream().map(UserPo::getName).collect(Collectors.joining(","));
        System.out.println(collect3);
        System.out.println(collect3);

        // sorted排序
        // 按学生成绩逆序排序 正序则不需要加.reversed()
        //正序
        List<UserPo> collect4 = list.stream().filter(p -> null != p.getScore()).sorted(Comparator.comparing(UserPo::getScore)).collect(Collectors.toList());
        //倒序
        List<UserPo> collect5 = list.stream().filter(p -> null != p.getScore()).sorted(Comparator.comparing(UserPo::getScore).reversed()).collect(Collectors.toList());
        System.out.println("collect5:" + collect5);

        //按学生成绩归集
        Map<Double, List<UserPo>> collect6 = list.stream().filter(p -> null != p.getScore()).collect(Collectors.groupingBy(UserPo::getScore));
        for (Map.Entry<Double, List<UserPo>> entry : collect6.entrySet()) {
            System.out.println("成绩：" + entry.getKey() + " 人数：" + entry.getValue().size());
        }
        //给每人成绩加10分
        //list.forEach(p -> p.setScore(p.getScore() + 10d));
        list.forEach(p -> {
            if (null != p.getScore()) {
                p.setScore(p.getScore() + 10);
            }
        });
        list.forEach(System.out::println);


        DoubleSummaryStatistics statistics = list.stream().mapToDouble(p -> {
            if (null != p.getScore()) {
                return p.getScore();
            }
            return 0.d;
        }).summaryStatistics();
        System.out.println("列表中最大的数 : " + statistics.getMax());
        System.out.println("列表中最小的数 : " + statistics.getMin());
        System.out.println("所有数之和 : " + statistics.getSum());
        System.out.println("平均数 : " + statistics.getAverage());

    }

}
