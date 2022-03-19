package com.clone.netflix.msuser;

import com.clone.netflix.msuser.config.DefaultProfileUtil;
import com.clone.netflix.msuser.config.MsUserConstants;
import com.clone.netflix.msuser.config.SwaggerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
@Import({SwaggerConfig.class})
public class MsUserApplication {

    private static final Logger log = LoggerFactory.getLogger(MsUserApplication.class);

    private final Environment env;

    public MsUserApplication(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());

        if (activeProfiles.contains(MsUserConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(MsUserConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run with both the 'dev' and 'prod' profiles at the same time.");
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(MsUserApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";

        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }

        final String contextPath = Optional.ofNullable(env.getProperty("server.context-path")).orElse("");

        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' microservice is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("app.microservice"),
                protocol,
                env.getProperty("server.port"),
                contextPath,
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                contextPath,
                env.getActiveProfiles());
    }
}
