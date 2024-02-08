package com.shamshad.bookmyshow.utility;

import com.shamshad.bookmyshow.models.*;
import com.shamshad.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {
    SeatTypeRepository seatTypeRepository;
    SeatRepository seatRepository;
    ShowRepository showRepository;
    AuditoriumRepository auditoriumRepository;
    TheatreRepository theatreRepository;
    CityRepository cityRepository;
    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;

    @Autowired
    public DummyData(SeatTypeRepository seatTypeRepository, SeatRepository seatRepository, ShowRepository showRepository, AuditoriumRepository auditoriumRepository, TheatreRepository theatreRepository, CityRepository cityRepository,
                     UserRepository userRepository,
                     ShowSeatRepository showSeatRepository) {
        this.seatTypeRepository = seatTypeRepository;
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public void addDummyData() {
        System.out.println("Adding Dummy data for required classes");
        SeatType goldSeatType = new SeatType();
        goldSeatType.setName("Gold");

        SeatType silverSeatType = new SeatType();
        silverSeatType.setName("Silver");

        SeatType platinumSeatType = new SeatType();
        platinumSeatType.setName("Platinum");

        List<Seat> seats = List.of(
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat()
        );

        City city1 = new City();
        city1.setName("Bangalore");
        city1.setState("Karnataka");

        City city2 = new City();
        city2.setName("Mumbai");
        city2.setState("Maharashtra");

        City city3 = new City();
        city3.setName("Delhi");
        city3.setState("Delhi");

        City city4 = new City();
        city4.setName("Chennai");
        city4.setState("Tamil Nadu");

        Theatre theatre1 = new Theatre();
        theatre1.setName("PVR Cinemas");
        theatre1.setCity(city1);

        Auditorium auditorium1 = new Auditorium();
        auditorium1.setName("Auditorium 1");
        auditorium1.setTheatre(theatre1);
        auditorium1.setSeats(seats);

//        city1.setTheatres(List.of(theatre1));

//        Seat seat1 = new Seat();
//        seat1.setSeatNumber("A1");
//        seat1.setRow(1);
//        seat1.setCol(1);
//        seat1.setSeatType(goldSeatType);

        Show show1 = new Show();
        show1.setShowName("Show 1");
        show1.setAuditorium(auditorium1);

        List<ShowSeat> showSeats = new ArrayList<>();

        for(Seat seat: seats){
            ShowSeat showSeat = new ShowSeat();
            seat.setSeatType(goldSeatType);
            showSeat.setSeat(seat);
            showSeat.setShow(show1);
            showSeats.add(showSeat);
        }

        User user1 = new User();
        user1.setUserName("John Doe");

        seatTypeRepository.saveAll(List.of(goldSeatType, silverSeatType, platinumSeatType));
        seatRepository.saveAll(seats);
        cityRepository.saveAll(List.of(city1, city2, city3, city4));
        theatreRepository.save(theatre1);
        auditoriumRepository.save(auditorium1);
        showRepository.save(show1);
        showSeatRepository.saveAll(showSeats);
        userRepository.save(user1);

    }
}
