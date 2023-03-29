package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mode.Item;
import it.ph.com.cosfiletest.mode.vo.DateVo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PH
 * @时间： 2022/12/12
 * @描述： 普通用户的购物车方法实现
 */
@Service(value = "NormalUserCart")
public class NormalUserCart extends AbstractCart {
    /**
     * @param userId 用户id
     * @param item   购物车信息
     * @return: void
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 商品优惠处理逻辑
     **/
    @Override
    protected void processCouponPrice(long userId, Item item) {
        item.setCouponPrice(BigDecimal.ZERO);
    }

    /**
     * @param userId 用户id
     * @param item   购物车信息
     * @return: void
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 运费处理逻辑
     **/

    @Override
    protected void processDeliveryPrice(long userId, Item item) {
        item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()).multiply(new BigDecimal("0.1"))));
    }

    public static void main(String[] args) {
        List<DateVo> dateVos = monthRange("2020");
        dateVos.forEach(s -> {
            System.out.println("开始日期:" + s.getStartStr());
            System.out.println("结束日期:" + s.getEndStr());
        });

    }

    private static List<DateVo> monthRange(String year) {
        List<DateVo> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Month month : Month.values()) {
            if (month == Month.DECEMBER) {
                // 如果是12月，需要特殊处理，因为只有12月才是一年的结束
                YearMonth yearMonth = YearMonth.of(Integer.parseInt(year), month);
                LocalDate startDate = yearMonth.atDay(1);
                LocalDate endDate = yearMonth.atEndOfMonth();
                String startStr = startDate.format(formatter);
                String endStr = endDate.format(formatter);
                DateVo dateVo = new DateVo();
                dateVo.setStartStr(startStr);
                dateVo.setEndStr(endStr);
                list.add(dateVo);
            } else {
                YearMonth yearMonth = YearMonth.of(Integer.parseInt(year), month);
                LocalDate startDate = yearMonth.atDay(1);
                LocalDate endDate = yearMonth.plusMonths(1).atDay(1).minusDays(1);
                String startStr = startDate.format(formatter);
                String endStr = endDate.format(formatter);
                DateVo dateVo = new DateVo();
                dateVo.setStartStr(startStr);
                dateVo.setEndStr(endStr);
                list.add(dateVo);
            }
        }
        return list;
    }
}