package sg.edu.nus.iss.paf_day28;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.paf_day28.repository.TVShowRepo;

@SpringBootApplication
public class PafDay28Application implements CommandLineRunner{

	@Autowired
	private TVShowRepo tvShowRepo;
	public static void main(String[] args){
		SpringApplication.run(PafDay28Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//List<Document> result = tvshowRepo.findShowsByLanguage("english");
		//List<Document> result = tvshowRepo.getTitleSummary();
		List<Document> result = tvShowRepo.getGenresStats();

		for (Document d : result){
			System.out.printf(">>> %s\n\n", d.toJson());
		}

		System.exit(0);
	}
}
