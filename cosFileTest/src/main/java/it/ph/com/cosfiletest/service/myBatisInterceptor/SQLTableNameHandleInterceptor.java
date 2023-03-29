package it.ph.com.cosfiletest.service.myBatisInterceptor;

import it.ph.com.cosfiletest.utils.ThreadLocalUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author: P H
 * @时间: 2023/3/17
 * @描述: Mybatis预执行替换表
 */
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class SQLTableNameHandleInterceptor implements Interceptor {
    private final static String[] SOURCE_TABLE = {"staff", "staffss", "staffssss"};

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        // 获取执行的SQL
        String sql = boundSql.getSql();
        // 获取执行的参数
        Object parameterObject = boundSql.getParameterObject();
        String name = ThreadLocalUtils.getTableName();
        // 需要拦截的参数是map类型，{tableName="",id=""...}，因此可以转Map的继续，其他的放行
  /*      if (parameterObject instanceof MapperMethod.ParamMap) {
            for (String tableName : SOURCE_TABLE) {
                if (sql.contains(tableName)) {
                    sql = sql.replaceAll(tableName, tableName + "_" + name);
                }
            }
            metaObject.setValue("delegate.boundSql.sql", sql);
        }*/
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
