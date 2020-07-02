package com.example.mybatisplus;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class MPGenerator {

        /**
         * 代码生成    示例代码 */  @Test
        public void testGenerator() {
            //1. 全局配置
            GlobalConfig config = new GlobalConfig();
            config.setActiveRecord(true) // 是否支持AR模式
                    .setAuthor("xff") // 作者
/*         .setOutputDir("D:\\workspace_mp\\mp03\\src\\main\\java") // 生成路径*/
                    .setOutputDir("D:\\IDEA\\mybatisplus-springboot-master\\mybatisplus-springboot-master\\src\\main\\java")
                    .setFileOverride(false)  // 文件覆盖
                    //.setIdType(IdType.AUTO) // 主键策略
                    .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                    // IEmployeeService  .setBaseResultMap(true)
                    .setBaseColumnList(true);
            //2. 数据源配置
            DataSourceConfig dsConfig  = new DataSourceConfig();
            dsConfig.setDbType(DbType.ORACLE)  // 设置数据库类型
                    .setDriverName("oracle.jdbc.driver.OracleDriver")
                    .setUrl("jdbc:oracle:thin:@xxx.xxx.x.xxx:xxxx:ORCL")
                    .setUsername("xxxx")
                    .setPassword("password");
            //3. 策略配置
            StrategyConfig stConfig = new StrategyConfig();
            stConfig.setCapitalMode(true) //全局大写命名
                    .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                    .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                    .setInclude("GYJCDG.M_FINANCIAL_CONDITION")
                    .setInclude("dba_users");
  /*.setTablePrefix("tbl_")
 .setInclude("tbl_employee");  // 生成的表*/       //4. 包名策略配置
            PackageConfig pkConfig = new PackageConfig();
            pkConfig.setParent("com.example.mybatisplus")
                    .setMapper("mapper")
                    .setService("service")
                    .setController("controller")
                    .setEntity("entity")
                    .setXml("mapperConfig");
            //5. 整合配置
            AutoGenerator ag = new AutoGenerator();
            ag.setGlobalConfig(config)
                    .setDataSource(dsConfig)
                    .setStrategy(stConfig)
                    .setPackageInfo(pkConfig);
            //6. 执行
            ag.execute();
        }




}
