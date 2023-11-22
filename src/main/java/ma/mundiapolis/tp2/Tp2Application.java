package ma.mundiapolis.tp2;

        import ma.mundiapolis.tp2.entities.Patient;
        import ma.mundiapolis.tp2.repositories.PatientRepo;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;

        import java.util.Date;
        import java.util.List;

@SpringBootApplication
public class Tp2Application {


    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }


    @Bean
    CommandLineRunner start(PatientRepo patientRepository) {
        return args -> {

            for (int i = 1; i < 100 ; i++) {
                patientRepository.save(
                        new Patient(null,"patient "+i,new Date(), Math.random() > 0.5,(int) (Math.random()*100),null));
            }
            Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
            System.out.println("Total pages :" + patients.getTotalPages());
            System.out.println("Total elements :" + patients.getTotalElements());
            System.out.println("Num page :" + patients.getNumber());
            List<Patient> content = patients.getContent(); // la liste entière
            Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,4)); // la liste des personnes qui sont malades
            List<Patient> patientList = patientRepository.chercherPatients("patient 6", 57);
            // Consulter la liste des patients par page
            patients.forEach(p->{
                System.out.println("===================");
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getDateNaissance());
                System.out.println(p.isMalade());
                System.out.println(p.getScore());
                System.out.println("===================");
            });

            System.out.println("****************");
            //Consulter un patient
            Patient patient = patientRepository.findById(1L).orElse(null);
            if(patient!=null){
                System.out.println(patient.getNom());
                System.out.println(patient.getDateNaissance());
                System.out.println(patient.getScore());
                System.out.println(patient.isMalade());
            }
            //supprimer un patient by ID
            patientRepository.deleteById(2L);

            //Mettre à Jour un Patient
            Patient patient1 = patientRepository.findById(3L).orElse(null);
            if(patient1 != null){
                patient1.setMalade(false);
                patient1.setScore(30);
                patientRepository.save(patient1);
            }
            else {
                System.out.println("Patient Not Found");
            }
            System.out.println("*****************************");
            System.out.println(patient1.getScore());
            System.out.println(patient1.isMalade());



        };
    }
};