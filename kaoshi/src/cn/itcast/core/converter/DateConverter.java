package cn.itcast.core.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换日期转换器
 * @author Administrator
 *
 */
public class DateConverter implements Converter<String, Date> {
    /**
     * 转换方法
     */
	@Override
	public Date convert(String source) {
        //自定义转换格式对象(2016-02-03 13:22:53)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
			// 转换成功直接返回
			return format.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 转换异常，返回null
		return null;
	}

	}


