package io.getarrays.server;

import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

import static io.getarrays.server.enumeration.Status.SERVER_DOWN;
import static io.getarrays.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.256", "Any Desk", "32 GB", "https://anydesk.com/en", "http://localhost:8090/server/image/server5.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.255", "StackOverFlow", "128 GB", "https://stackoverflow.com/", "http://localhost:8090/server/image/server6.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.160", "User Say", "16 GB", "https://www.usersay.com/", "http://localhost:8090/server/image/server1.png", SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.58", "Global Vpn", "32 GB", "https://www.globalvpn.com/","http://localhost:8090/server/image/server2.png", SERVER_DOWN));
			serverRepo.save(new Server(null, "157.240.22.35", "Facebook", "64 GB", "https://www.facebook.com/", "http://localhost:8090/server/image/server3.png", SERVER_UP));
			serverRepo.save(new Server(null, "153.238.208.65", "Youtube", "128 GB", "https://www.youtube.com/", "http://localhost:8090/server/image/server4.png", SERVER_UP));


			serverRepo.save(new Server(null, "192.168.1.110", "Instagram", "512 GB", "https://www.instagram.com/", "http://localhost:8090/server/image/server7.png", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.111", "Github", "256 GB", "https://github.com/","http://localhost:8090/server/image/server8.png", SERVER_DOWN));
			serverRepo.save(new Server(null, "157.240.22.112", "ChatGpt", "128 GB", "https://chat.openai.com/chat", "http://localhost:8090/server/image/server9.png", SERVER_UP));


		};
	}


	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
