package com.self.datasource.first.config;

import com.self.datasource.first.enums.DbTypeEnum;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Primary
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<Integer> currentDataSource = new ThreadLocal<>();

    @Resource
    private DataSource firstDataSource;

    @Resource
    private DataSource secondDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        return currentDataSource.get();
    }

    @Override
    public void afterPropertiesSet() {
        // 设置所有的数据源
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DbTypeEnum.W.getCode(), firstDataSource);
        dataSourceMap.put(DbTypeEnum.R.getCode(), secondDataSource);
        super.setTargetDataSources(dataSourceMap);
        // 设置默认的数据源
        super.setDefaultTargetDataSource(firstDataSource);
        super.afterPropertiesSet();
    }

    public static void setCurrentDataSource(DbTypeEnum dbTypeEnum) {
        currentDataSource.set(dbTypeEnum.getCode());
    }

    public static void clearCurrentDataSource() {
        currentDataSource.remove();
    }

}
