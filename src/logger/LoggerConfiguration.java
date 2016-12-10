package com.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * Sets a new configuration of logger file with custom features.
 *
 * Default configuration includes a console logger. The loggers will
 * automatically save the logs on the path: /logs/log_output.log
 *
 * @author Mariana Rocha
 */
public class LoggerConfiguration {

    private static Logger logger = null;
    private String maxLog = "4";
    private String maxSize="10 KB";
    private static final String LOG_PATTERN = "%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n";
    private static final String LOG_PATH = "logs/log_output.log";
    private static final String LOG_PATH_PATTERN = "logs/log_output-%d{yyyy-MM-dd}-%i.log";
    private static final String APPENDER_FILENAME = "RollingFile";
    private static final String LOGGER_NAME = "com.logger.LoggerConfiguration";
    
    /**
     * Build the configuration with the size and a default maximun number of log
     * files.
     *
     * @param maxSize the size of the log. Must be in the format: "numer unit".
     * Example: 10 MB.
     */
    public LoggerConfiguration(String maxSize) {
        this.maxSize=maxSize;
        buildConfiguration();
        logger = LogManager.getRootLogger();
    }

    /**
     * Build the configuration with a custom size and maximum number log files.
     *
     * @param maxSize the size of the log. Must be in the format: "numer unit".
     * Example: 10 MB.
     * @param maxLog the maximum amount of log files to keep.
     */
    public LoggerConfiguration(String maxSize, String maxLog) {
        this.maxSize=maxSize;
        this.maxLog=maxLog;
        buildConfiguration();
        logger = LogManager.getRootLogger();
    }

    private void buildConfiguration() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        Configuration configuration  = context.getConfiguration();
        
        createAppender(configuration, context);
    }

    //Creates a new RollingFileAppender to save log files.
    private void createAppender(Configuration config, LoggerContext context){
        PatternLayout layout = PatternLayout.newBuilder().withConfiguration(config).withPattern(LOG_PATTERN).build();
        SizeBasedTriggeringPolicy policy = SizeBasedTriggeringPolicy.createPolicy(maxSize);
        DefaultRolloverStrategy strategy = DefaultRolloverStrategy.createStrategy(maxLog, "1", "max", null, null, true, config);
        policy.initialize();
        Appender appender = RollingFileAppender.newBuilder().
                withConfiguration(config).withFileName(LOG_PATH).
                withFilePattern(LOG_PATH_PATTERN).
                withLayout(layout).withName(APPENDER_FILENAME).withPolicy(policy).
                withStrategy(strategy).build();
        appender.start();
        
        setAppender(config, context, appender);
    }
    
    //Sets the new appender and update the configuration
    private void setAppender(Configuration configuration, LoggerContext context, Appender appender){
        configuration.addAppender(appender);
        AppenderRef ref = AppenderRef.createAppenderRef(APPENDER_FILENAME, null, null);
        AppenderRef[] refs = new AppenderRef[]{ref};
        LoggerConfig loggerConfig = configuration.getLoggerConfig(LOGGER_NAME);
        loggerConfig.addAppender(appender, Level.WARN, null);
        context.updateLoggers();
    }
    
    /**
     * @return the log
     */
    public Logger getLogger() {
        return logger;
    }
}
