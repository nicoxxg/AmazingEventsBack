package com.MindHub.AmazingEvents;

import com.MindHub.AmazingEvents.Models.*;
import com.MindHub.AmazingEvents.Models.Enums.Genders;
import com.MindHub.AmazingEvents.Models.Enums.Rol;
import com.MindHub.AmazingEvents.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AmazingEventsApplication {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerEventRepository customerEventRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventLocationRepository eventLocationRepository;
	@Autowired
	private LikeEventRepository likeEventRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CommentRepository messageRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmazingEventsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(CustomerRepository customerRepository, CustomerEventRepository customerEventRepository, EventRepository eventRepository, EventLocationRepository eventLocationRepository, LikeEventRepository likeEventRepository, LocationRepository locationRepository, CommentRepository messageRepository){
		return args -> {
			Customer customer1 = new Customer(UUID.randomUUID(),"Admin","admin",true,"admin@admin","admin",10000, Genders.agender, Rol.rol);
			customerRepository.save(customer1);

			Customer customer2 = createUniqueCustomer("User", "user", true,"asdasdas@gmail", "password", 25, Genders.male, Rol.rol);
			customerRepository.save(customer2);

			Event event1 = createUniqueEvent("Evento1", "Descripción del Evento 1", "imagen1.jpg", 18, customer1);
			eventRepository.save(event1);

			Event event2 = createUniqueEvent("Evento2", "Descripción del Evento 2", "imagen2.jpg", 21, customer2);
			eventRepository.save(event2);


			Location location1 = createUniqueLocation("Ubicación1", "Dirección1", 100, "imagen1.jpg");
			locationRepository.save(location1);

			Location location2 = createUniqueLocation("Ubicación2", "Dirección2", 200, "imagen2.jpg");
			locationRepository.save(location2);

			EventLocation eventLocation1 = createUniqueEventLocation(event1, location1, 50);
			eventLocationRepository.save(eventLocation1);

			EventLocation eventLocation2 = createUniqueEventLocation(event2, location2, 70);
			eventLocationRepository.save(eventLocation2);


			LikeEvent likeEvent1 = createUniqueLikeEvent(customer1, event1);
			likeEventRepository.save(likeEvent1);

			LikeEvent likeEvent2 = createUniqueLikeEvent(customer2, event2);
			likeEventRepository.save(likeEvent2);


			Comment comment1 = createUniqueMessage(customer1, event1, "Comentario 1", 5);
			messageRepository.save(comment1);

			Comment comment2 = createUniqueMessage(customer2, event2, "Comentario 2", 4);
			messageRepository.save(comment2);


			CustomerEvent customerEvent1 = createUniqueCustomerEvent(customer1, eventLocation1);
			customerEventRepository.save(customerEvent1);

			CustomerEvent customerEvent2 = createUniqueCustomerEvent(customer2, eventLocation2);
			customerEventRepository.save(customerEvent2);
		};
	}


	private Customer createUniqueCustomer(String name, String lastName, boolean activated,String email, String password, int years, Genders gender, Rol rol) {
		UUID customerId = UUID.randomUUID();
		while (customerRepository.existsById(customerId)) {
			customerId = UUID.randomUUID();
		}
		return new Customer(customerId, name, lastName, activated, email, password, years, gender, rol);
	}

	private Event createUniqueEvent(String name, String description, String img, int ageRequerided, Customer customer) {
		UUID eventId = UUID.randomUUID();
		while (eventRepository.existsById(eventId)) {
			eventId = UUID.randomUUID();
		}
		return new Event(eventId, name, description, img, ageRequerided, customer);
	}

	private Location createUniqueLocation(String name, String location, int capacity, String img) {
		UUID locationId = UUID.randomUUID();
		while (locationRepository.existsById(locationId)) {
			locationId = UUID.randomUUID();
		}
		return new Location(locationId, name, location, capacity, img);
	}
	private EventLocation createUniqueEventLocation(Event event, Location location, int assistance) {
		UUID eventLocationId = UUID.randomUUID();
		while (eventLocationRepository.existsById(eventLocationId)) {
			eventLocationId = UUID.randomUUID();
		}
		return new EventLocation(eventLocationId, new Date(), assistance, event, location);
	}

	private LikeEvent createUniqueLikeEvent(Customer customer, Event event) {
		UUID likeEventId = UUID.randomUUID();
		while (likeEventRepository.existsById(likeEventId)) {
			likeEventId = UUID.randomUUID();
		}
		return new LikeEvent(likeEventId, customer, event);
	}

	private Comment createUniqueMessage(Customer customer, Event event, String comment, int calification) {
		UUID messageId = UUID.randomUUID();
		while (messageRepository.existsById(messageId)) {
			messageId = UUID.randomUUID();
		}
		return new Comment(messageId, customer, event, comment, calification);
	}

	private CustomerEvent createUniqueCustomerEvent(Customer customer, EventLocation eventLocation) {
		UUID customerEventId = UUID.randomUUID();
		while (customerEventRepository.existsById(customerEventId)) {
			customerEventId = UUID.randomUUID();
		}
		return new CustomerEvent(customerEventId, customer, eventLocation);
	}
}
